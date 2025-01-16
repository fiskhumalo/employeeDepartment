package com.fiskhumalo.employeeManagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT )
public class RegistrationValidationException extends RuntimeException {
    public RegistrationValidationException(String message) {
        super(message);
    }
}
