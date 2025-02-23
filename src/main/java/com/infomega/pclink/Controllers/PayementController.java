package com.infomega.pclink.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infomega.pclink.Services.PayService;

@RestController
@RequestMapping("/api/pay")
public class PayementController {
    private PayService payService;
    public PayementController(PayService payService) {
        this.payService=payService;
    }
    @GetMapping("/checkout")
    public ResponseEntity<String> getCheckoutUrl() {
        try {
            return ResponseEntity.ok(payService.getCheckoutUrl());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occured try again later");
        }
    }
    @GetMapping("/successPayement")
    public ResponseEntity<String> successPayement() {
        System.out.println("Payement success");
        return ResponseEntity.ok("Payement success");
    }
    @GetMapping("/canceledPayement")
    public ResponseEntity<String> canceledPayement() {
        System.out.println("Payement canceled");
        return ResponseEntity.ok("Payement canceled");
    }
}
