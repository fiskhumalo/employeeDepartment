package com.fiskhumalo.employeeManagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmailValidationReportException extends RuntimeException{
    public EmailValidationReportException(String message) {
        super(message);
    }


    }

