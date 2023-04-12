package com.team5.morgage.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String text) {
        super(text);
    }
}
