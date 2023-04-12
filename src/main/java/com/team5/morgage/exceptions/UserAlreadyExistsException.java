package com.team5.morgage.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String text) {
        super(text);
    }
}
