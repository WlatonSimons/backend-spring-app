package com.team5.mortgage.models.enums;

public enum ApplicationStatus {
    NEW("New"),
    IN_PROGRESS("In progress"),
    DONE("Done"),
    REJECTED("Rejected");

    private String status;

    ApplicationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
