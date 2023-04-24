package com.team5.mortgage.exceptions;

public class MortgageNotFoundException extends RuntimeException {

    public MortgageNotFoundException(String message) {
        super(message);
    }
}
