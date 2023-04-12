package com.team5.morgage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .and()
                .cors()
                .and()
                .authorizeRequests()
                .requestMatchers("/**").hasIpAddress("3.75.158.163")
                .requestMatchers("/**").hasIpAddress("3.125.183.140")
                .requestMatchers("/**").hasIpAddress("35.157.117.28");
        return http.build();
    }
}