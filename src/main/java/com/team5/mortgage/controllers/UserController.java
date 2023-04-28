package com.team5.mortgage.controllers;

import com.team5.mortgage.models.User;
import com.team5.mortgage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/users")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User fetchUserById(@PathVariable Long userId) {
        return userService.fetchUserById(userId);
    }

    @PostMapping("/login")
    public User getUserByLoginData(@RequestBody User user) {
        return userService.getUserByLoginData(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
