package com.team5.mortgage.exceptions.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private String message;
    private int code;
}
