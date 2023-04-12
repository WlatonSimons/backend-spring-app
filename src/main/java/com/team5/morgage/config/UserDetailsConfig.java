package com.team5.morgage.config;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        manager.createUser(User.withUsername("user").password(passwordEncoder.encode("password")).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(passwordEncoder.encode("password")).roles("USER", "ADMIN").build());
        return manager;
    }
}*/