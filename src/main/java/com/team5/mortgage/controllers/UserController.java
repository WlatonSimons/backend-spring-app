package com.team5.mortgage.controllers;

import com.team5.mortgage.models.User;
import com.team5.mortgage.services.UserService;
import com.team5.mortgage.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    private final JwtUtils jwtUtils;

    public UserController(UserService userService) {
        this.userService = userService;
        this.jwtUtils = new JwtUtils();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<User> getUserByLoginData(@RequestBody User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("JsonWebToken", JwtUtils.generateJwtToken("Admin"));

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(userService.getUserByLoginData(user));
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
