package com.team5.mortgage.validators;

import com.team5.mortgage.exceptions.CustomException;
import com.team5.mortgage.models.enums.ApplicationStatus;

public class ApplicationValidator {

    public boolean isStatusCorrect(String newStatus) {
        for (ApplicationStatus status : ApplicationStatus.values()) {
            if (status.getStatus().equals(newStatus)) {
                return true;
            }
        }
        throw new CustomException("New status (" + newStatus + ") is not acceptable");
    }
}
