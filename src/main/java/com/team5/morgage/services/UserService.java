package com.team5.morgage.services;

import com.team5.morgage.exceptions.UserAlreadyExistsException;
import com.team5.morgage.repositories.UserRepository;
import com.team5.morgage.exceptions.UserNotFoundException;
import com.team5.morgage.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final int SALT_LENGTH = 16;
    private static final int HASH_LENGTH = 32;
    private static final int PARALLELISM = 1;
    private static final int MEMORY = 1 << 12;
    private static final int ITERATIONS = 3;

    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new Argon2PasswordEncoder(SALT_LENGTH, HASH_LENGTH, PARALLELISM, MEMORY, ITERATIONS);
    }

    public User createUser(User userRequest) {
        checkIfUserAlreadyExist(userRequest);

        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(userRequest);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(HttpStatus.NOT_FOUND.value() +
                                " User with id: " + userId + " does not exist"));
    }

    public User getUserByLoginData(User loginUser) {
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll()).forEach(users::add);

        for (User user : users) {
            if (user.getUsername().equals(loginUser.getUsername())
                    && passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void checkIfUserAlreadyExist(User userRequest) {
        for (User usr : getAllUsers()) {
            if (usr.getUsername() != null && usr.getUsername().equals(userRequest.getUsername())) {
                throw new UserAlreadyExistsException("User with name: " + userRequest.getUsername() + " already exists");
            }
            if (usr.getEmail() != null && usr.getEmail().equals(userRequest.getEmail())) {
                throw new UserAlreadyExistsException("User with email: " + userRequest.getEmail() + " already exists");
            }
        }
    }

    public User updateUser(User userRequest) {
        checkIfUserAlreadyExist(userRequest);

        User updateUser = userRepository.findById(userRequest.getId())
                .orElseThrow(() ->
                        new UserNotFoundException(HttpStatus.NOT_FOUND.value() +
                                " User with id: " + userRequest.getId() + " does not exist"));

        if (userRequest.getUsername() != null) {
            updateUser.setUsername(userRequest.getUsername());
        }
        if (userRequest.getPassword() != null) {
            updateUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        }
        if (userRequest.getEmail() != null) {
            updateUser.setEmail(userRequest.getEmail());
        }

        return userRepository.save(updateUser);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Streamable.of(userRepository.findAll()).forEach(users::add);
        return users;
    }

    public void delete(Long userId) {
        userRepository.delete(getUserById(userId));
    }
}
