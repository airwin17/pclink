package com.infomega.pclink.Controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.infomega.pclink.Services.ReviewsService;

@Controller
public class ViewController {
    private ReviewsService reviewsService;
    public ViewController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }
    @GetMapping("/")
    public String redirectToParticuliers() {
        
        return "redirect:/particuliers";
    }
    @GetMapping("/particuliers")
    public String particuliers(Model model) {
        try {
            model.addAttribute("reviews", new LinkedList<>()/*reviewsService.loadReview()*/);
            model.addAttribute("globalRating", 4.5 /**Double.valueOf(reviewsService.getGlobalRating())*/);
            model.addAttribute("globalRatingCount", 198/*reviewsService.getGlobalRatingCount()*/);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "particuliers.html";
    }
    @GetMapping("/pro")
    public String professionnels() {
        return "pro.html";
    }
    @GetMapping("/getexe")
    public ResponseEntity<Resource> getExe() {
        Path filePath = Paths.get("src/main/resources/static/TeamViewerQS_x64.exe");
        Resource resource;
        try {
            resource = new UrlResource(filePath.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                throw new RuntimeException("File not found or not readable");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
