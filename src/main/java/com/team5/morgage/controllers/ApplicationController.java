package com.team5.morgage.controllers;

import com.team5.morgage.models.Application;
import com.team5.morgage.models.requests.MaxLoanRequest;
import com.team5.morgage.services.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/application/submit")
    public ResponseEntity<Application> saveSubmittedApplication(@RequestBody @Valid Application application) {
        return new ResponseEntity<>(applicationService.saveSubmittedApplication(application), HttpStatus.CREATED);
    }

    @GetMapping("/application/getAll")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }
}
