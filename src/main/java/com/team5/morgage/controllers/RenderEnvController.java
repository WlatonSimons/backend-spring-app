package com.team5.morgage.controllers;

import com.team5.morgage.models.Application;
import com.team5.morgage.services.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/API")
@RestController
public class RenderEnvController {

    @GetMapping("/get")
    public String getApiKey() {
        return System.getenv("API_KEY");
    }
}
