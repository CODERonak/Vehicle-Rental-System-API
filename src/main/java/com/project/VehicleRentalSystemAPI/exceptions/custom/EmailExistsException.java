package com.project.VehicleRentalSystemAPI.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This exception is thrown when an email already exists in the database
@ResponseStatus(HttpStatus.CONFLICT)
public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String message) {
        // Calls the parent constructor with the provided message
        super(message);
    }
}