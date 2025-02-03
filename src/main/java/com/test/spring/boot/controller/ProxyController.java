package com.test.spring.boot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @GetMapping("/stories")
    public ResponseEntity<String> getStories() {
        RestTemplate restTemplate = new RestTemplate();
        String targetUrl = "https://example.com/api/stories"; // Replace with the actual URL that provides the data
        String response = restTemplate.getForObject(targetUrl, String.class);
        return ResponseEntity.ok(response);
    }
}
