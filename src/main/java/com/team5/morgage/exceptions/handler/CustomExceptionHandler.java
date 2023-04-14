package com.team5.morgage.exceptions.handler;

import com.team5.morgage.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.team5.morgage.exceptions.response.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .statusCode(ex.getStatusCode())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.valueOf(ex.getStatusCode()));
    }

    // ToDo: Add more handles for different exceptions
    //  or maybe there is a way to make it dynamic?
}
