package com.meteor.grant_disbursement.error;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ErrorHandler {

    @ExceptionHandler(InvalidHouseholdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidHouseholdException(InvalidHouseholdException ex) {
        return new ErrorMessage(ex.message);
    }

    @ExceptionHandler(InvalidFamilyMemberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleInvalidFamilyException(InvalidFamilyMemberException ex) {
        return new ErrorMessage(ex.message);
    }
}
