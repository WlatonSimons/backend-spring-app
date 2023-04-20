package com.team5.morgage.services;

import com.team5.morgage.models.Application;
import com.team5.morgage.repositories.ApplicationRepository;
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

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application saveSubmittedApplication(@Valid Application application) {
        application.setDate(new Timestamp(System.currentTimeMillis()));
        application.setStatus("New");
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        List<Application> applications = new ArrayList<>();
        Streamable.of(applicationRepository.findAll()).forEach(applications::add);
        return applications;
    }
}
