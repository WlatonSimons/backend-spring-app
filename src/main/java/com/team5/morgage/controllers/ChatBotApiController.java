package com.team5.morgage.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatBotApiController {
    @Value("${my-api-key}")
    private String apiKey;

    @GetMapping("/api-key")
    public String getApiKey() {
        return apiKey;
    }
}
