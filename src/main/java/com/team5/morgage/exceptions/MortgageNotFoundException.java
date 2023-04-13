package com.team5.morgage.exceptions;

public class MortgageNotFoundException extends RuntimeException {

    public MortgageNotFoundException(String text) {
        super(text);
    }
}
