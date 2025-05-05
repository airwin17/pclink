package com.infomega.pclink.Controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.infomega.pclink.Services.BusinessDaysService;
import com.infomega.pclink.model.BusinessDay;

@Controller
public class ViewController {
    private BusinessDaysService businessDaysService;
    public ViewController(BusinessDaysService businessDaysService) {
        this.businessDaysService = businessDaysService;
    }
    @GetMapping("/")
    public String redirectToParticuliers() {
        return "redirect:/particuliers";
    }
    
    @GetMapping("/particuliers")
    public String particuliers(Model model) {
        try {
            String activeProfile = System.getProperty("spring.profiles.active");
                model.addAttribute("reviews", new LinkedList<>());
                model.addAttribute("globalRating", 4.5);
                model.addAttribute("globalRatingCount", 198);
            Map<String, BusinessDay> businessDays = businessDaysService.getAllBusinessDays();
            System.out.println(businessDays);
            model.addAttribute("businessDays", businessDays);
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
