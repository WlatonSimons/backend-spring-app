package com.team5.morgage.services;

import com.team5.morgage.exceptions.UserAlreadyExistsException;
import com.team5.morgage.repositories.UserRepository;
import com.team5.morgage.exceptions.UserNotFoundException;
import com.team5.morgage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("Stats with id: " + userId + ", does not exist."));
    }

    public User updateUser(User user) {
        List<User> allUsers = getAllUsers();
        User updateUser = new User();

        for (User usr : allUsers) {
            if (usr.getUsername() != null && usr.getUsername().equals(user.getUsername())) {
                throw new UserAlreadyExistsException("User with name: " + user.getUsername() + " already exists");
            }
            if (usr.getEmail() != null && usr.getEmail().equals(user.getEmail())) {
                throw new UserAlreadyExistsException("User with email: " + user.getEmail() + " already exists");
            }
        }

        if (user.getUsername() != null) {
            updateUser.setUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            updateUser.setPassword(user.getPassword());
        }
        if (user.getEmail() != null) {
            updateUser.setEmail(user.getEmail());
        }

        return userRepository.save(updateUser);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll()).forEach(users::add);
        return users;
    }

    public void delete(long userId) {
        userRepository.delete(getUserById(userId));
    }
}
