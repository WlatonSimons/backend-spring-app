package com.team5.mortgage.services;

import com.team5.mortgage.exceptions.CustomException;
import com.team5.mortgage.models.Application;
import com.team5.mortgage.repositories.ApplicationRepository;
import com.team5.mortgage.validators.ApplicationValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private final ApplicationRepository applicationRepository;

    private final ApplicationValidator applicationValidator;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
        this.applicationValidator = new ApplicationValidator();
    }

    public Application saveSubmittedApplication(@Valid Application application) {
        if (application.getDate() == null) {
            application.setDate(new Timestamp(System.currentTimeMillis()));
        }
        application.setStatus("New");
        return applicationRepository.save(application);
    }

    public List<Application> fetchAllApplications() {
        List<Application> applications = new ArrayList<>();
        Streamable.of(applicationRepository.findAll()).forEach(applications::add);
        return applications;
    }

    public Application changeApplicationStatus(Long applicationId, String newStatus) {
        Application updateApplication = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new CustomException("Application with id: " + applicationId + " does not exist"));

        if (newStatus != null && applicationValidator.isStatusCorrect(newStatus)) {
            updateApplication.setStatus(newStatus);
            return applicationRepository.save(updateApplication);
        } else {
            throw new CustomException("New status is empty or null");
        }
    }

    public ResponseEntity<List<Application>> fetchApplications(Long id, String term) {
        List<Application> applications = new ArrayList<>();

        if (id != null) {
            String normalizedId = id.toString();

            fetchAllApplications()
                    .stream()
                    .filter(application -> application.getId().toString().contains(normalizedId))
                    .forEach(applications::add);
        }
        if (term != null) {
            String normalizedTerm = term.toLowerCase();

            fetchAllApplications()
                    .stream()
                    .filter(application -> (application.getFirstName().toLowerCase().contains(normalizedTerm)) ||
                            application.getLastName().toLowerCase().contains(normalizedTerm))
                    .forEach(applications::add);
        }
        if (id == null && term == null) {
            applications.addAll(fetchAllApplications());
        }

        if (applications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
}
