package com.team5.morgage.controllers;

import com.team5.morgage.models.Application;
import com.team5.morgage.services.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/application")
@RestController
public class ApplicationController {

    @Autowired
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/submit")
    public ResponseEntity<Application> saveSubmittedApplication(@RequestBody @Valid Application application) {
        return new ResponseEntity<>(applicationService.saveSubmittedApplication(application), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }
}
