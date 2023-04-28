package com.team5.mortgage.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/chat-bot")
@RestController
public class ChatBotController {

    @GetMapping
    public ResponseEntity<String> fetchApiKey() {
        return new ResponseEntity<>(System.getenv("API_KEY"), HttpStatus.ACCEPTED);
    }
}
