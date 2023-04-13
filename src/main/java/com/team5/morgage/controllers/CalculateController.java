package com.team5.morgage.controllers;

import com.team5.morgage.models.SecondResponse;
import com.team5.morgage.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping("/calculate/first_form")
    public float firstForm(@RequestBody CalculateService.FirstRequest request) {
        return calculateService.firstForm(request);
    }

    @PostMapping("/calculate/second_form")
    public SecondResponse secondForm(@RequestBody CalculateService.SecondRequest request) {
        return calculateService.secondForm(request);
    }
}
