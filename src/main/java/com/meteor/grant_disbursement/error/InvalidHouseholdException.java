package com.meteor.grant_disbursement.error;

import org.springframework.web.server.ResponseStatusException;

public class InvalidHouseholdException extends RuntimeException {
    public String message;

    public InvalidHouseholdException(String message) {
        this.message = message;
    }
}
