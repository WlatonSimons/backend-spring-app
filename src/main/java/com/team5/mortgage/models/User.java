package com.team5.mortgage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username can`t be empty or null")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull(message = "Password can`t be empty or null")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "Email can`t be empty or null")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
