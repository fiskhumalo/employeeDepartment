package com.fiskhumalo.employeeManagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class IdVerificationResponse extends RuntimeException {
    public IdVerificationResponse(String message) {
        super(message);
    }
}
