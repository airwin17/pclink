package com.infomega.pclink;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.infomega.pclink.Services.ReviewsService;

@SpringBootTest
@AutoConfigureMockMvc
public class ReviewTest {
    @Autowired
    private ReviewsService reviewsService;
    @Test
    public void testLoadReview() throws URISyntaxException, IOException, InterruptedException {
        reviewsService.loadReview();
        System.out.println(reviewsService.loadReview());
    }
}
