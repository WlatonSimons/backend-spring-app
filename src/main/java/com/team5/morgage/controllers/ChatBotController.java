package com.team5.morgage.controllers;

import com.team5.morgage.services.MortgageValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/chatBot")
@RestController
public class ChatBotController {

    @Autowired
    private final MortgageValueService mortgageValueService;

    public ChatBotController(MortgageValueService mortgageValueService) {
        this.mortgageValueService = mortgageValueService;
    }

    @GetMapping("/getApiKey")
    public ResponseEntity<String> getChatBotApiKey() {
        return new ResponseEntity<>(mortgageValueService.getChatBotApiKey(), HttpStatus.CREATED);
    }

    @PatchMapping("/changeApiKey")
    public ResponseEntity<String> changeApiKey(@RequestBody String apiKey) {
        return new ResponseEntity<>(mortgageValueService.changeApiKey(apiKey), HttpStatus.CREATED);
    }
}
