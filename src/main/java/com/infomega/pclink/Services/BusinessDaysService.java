package com.infomega.pclink.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.infomega.pclink.model.BusinessDay;

@Service
public class BusinessDaysService {
    @SuppressWarnings("null")
    public Map<String,BusinessDay> getAllBusinessDays() {
        Map<String,BusinessDay> businessDays = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:1337/api/business-days";
        String tokken = "40af8071cf84d43558885e6db0d5c932348d780d1f4c658ab0d5623063066b755090c58f573745c032f6a71ce5d3bb8af22af13b6d2a888c674d2adf48acf1e1f74505b7370dccb839c6bd5ec58cd7484f4b48a4ae0783f082815e3447025edb65950b91779028e816abed4eacdee00d91952f751ed8d269b80265160f5c28d4";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);
        for(int i = 0; i < 6; i++) {
            BusinessDay businessDay = new BusinessDay();
            businessDay.setDay(responseEntity.getBody().get("data").get(i).get("day").asText());
            businessDay.setMornig(responseEntity.getBody().get("data").get(i).get("morning").asText());
            businessDay.setEvening(responseEntity.getBody().get("data").get(i).get("evening").asText());
            businessDays.put(businessDay.getDay(), businessDay);
        }
        return businessDays;
    }
}
