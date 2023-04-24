package com.team5.mortgage.controllers;

import com.team5.mortgage.services.MortgageValueService;
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
    public ResponseEntity<String> getApiKey() {
        return new ResponseEntity<>(mortgageValueService.getApiKey(), HttpStatus.CREATED);
    }
}
