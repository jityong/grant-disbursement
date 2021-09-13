package com.meteor.grant_disbursement.error;

public class InvalidFamilyMemberException extends RuntimeException {
    public String message;

    public InvalidFamilyMemberException(String message) {
        this.message = message;
    }
}
