package com.infomega.pclink.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.infomega.pclink.model.Review;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;



@Service
public class ReviewsService {
    private String apikey="AIzaSyD8OuOhwRkCzcW0wLKaSmQjACpH7J67UMg";
    private String placeID="ChIJrQP8HLy_yRIRoYAEOWkVIrA";
    private String globalRating;
    private String globalRatingCount;
    public List<Review> loadReview() throws URISyntaxException, IOException, InterruptedException {
        List<Review> reviews=new LinkedList<>(); //array of reviews
        //send request to google api
        RestTemplate restTemplate = new RestTemplate();
            String urlString = "https://places.googleapis.com/v1/places/"
             + placeID
             + "?key=" 
             + apikey
             + "&fields=reviews,rating,userRatingCount"
             + "&languageCode=fr";
            /*HttpRequest request=HttpRequest.newBuilder(new URI(urlString)).GET().build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());*/
            ResponseEntity<ObjectNode> res = restTemplate.getForEntity(urlString, ObjectNode.class);
            
            ObjectNode responseResviews = res.getBody();
            if (responseResviews != null) {
                ArrayNode reviewsNode = (ArrayNode) responseResviews.get("reviews");
                globalRating = responseResviews.get("rating").asText();
                globalRatingCount = responseResviews.get("userRatingCount").asText();
                for (int i = 0; i < 3; i++) {
                    Review review = new Review();
                    JsonNode reviewObjectNode = reviewsNode.get(i);
                    review.setName(reviewObjectNode.get("authorAttribution").get("displayName").asText());
                    review.setComment(reviewObjectNode.get("text").get("text").asText());
                    review.setRating(reviewObjectNode.get("rating").asInt());
                    review.setDate(reviewObjectNode.get("relativePublishTimeDescription").asText());
                    review.setProfilePic(reviewObjectNode.get("authorAttribution").get("photoUri").asText());
                    reviews.add(review);
                }
            }
        return reviews;
    }
    public String getGlobalRating() {
        return globalRating;
    }
    public String getGlobalRatingCount() {
        return globalRatingCount;
    }
}
