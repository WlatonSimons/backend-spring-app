package com.team5.mortgage.services;

import com.team5.mortgage.exceptions.CustomException;
import com.team5.mortgage.models.Application;
import com.team5.mortgage.repositories.ApplicationRepository;
import com.team5.mortgage.util.JwtUtils;
import com.team5.mortgage.validations.Validation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private final ApplicationRepository applicationRepository;

    private final Validation validator;

    private final JwtUtils jwtUtils;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
        this.validator = new Validation();
        this.jwtUtils = new JwtUtils();
    }

    public Application saveSubmittedApplication(@Valid Application application) {
        application.setDate(new Timestamp(System.currentTimeMillis()));
        application.setStatus("New");
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications(String jsonWebToken) {
        if (jwtUtils.validateToken(jsonWebToken)) {
            List<Application> applications = new ArrayList<>();
            Streamable.of(applicationRepository.findAll()).forEach(applications::add);
            return applications;
        } else {
            return null;
        }
    }

    public Application setApplicationStatus(Long applicationId, String newStatus, String jsonWebToken) {

        if (jwtUtils.validateToken(jsonWebToken)) {
            Application updateApplication = applicationRepository.findById(applicationId)
                    .orElseThrow(() -> new CustomException("Application with id: " + applicationId + " does not exist"));

            if (newStatus != null && !newStatus.isEmpty() && validator.isStatusCorrect(newStatus)) {
                updateApplication.setStatus(newStatus);
                return applicationRepository.save(updateApplication);
            } else {
                throw new CustomException("New status is empty or null");
            }
        } else {
            throw new CustomException("Token is null or invalid");
        }
    }
}
