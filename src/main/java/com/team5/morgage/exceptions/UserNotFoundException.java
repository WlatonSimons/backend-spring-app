package com.team5.morgage.exceptions;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserNotFoundException extends RuntimeException {

    private int statusCode;
    private String message;
}
