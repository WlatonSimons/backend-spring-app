package com.team5.mortgage.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/chat-bot")
@RestController
public class ChatBotController {

    @GetMapping
    public String getApiKey() {
        return System.getenv("API_KEY");
    }
}
