package com.team5.morgage.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @GetMapping(value = "/")
    public String getResponse() {
        return "DB works";
    }
}
