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
        String tokken = "deleted";
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
