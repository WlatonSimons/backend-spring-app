package com.team5.mortgage.controllers;

import com.team5.mortgage.models.Application;
import com.team5.mortgage.services.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/applications")
@RestController
public class ApplicationController {

    @Autowired
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> saveSubmittedApplication(@RequestBody @Valid Application application) {
        return new ResponseEntity<>(applicationService.saveSubmittedApplication(application), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Application>> fetchAllApplications(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "term", required = false) String term
    ) {

        return applicationService.fetchApplications(id, term);
    }

    @PatchMapping("/{applicationId}")
    public ResponseEntity<Application> changeApplicationStatus(@PathVariable Long applicationId, @RequestBody String newStatus) {
        return new ResponseEntity<>(applicationService.changeApplicationStatus(applicationId, newStatus), HttpStatus.CREATED);
    }
}
