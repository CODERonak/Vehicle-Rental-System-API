package com.project.VehicleRentalSystemAPI.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This exception is thrown when an phone number already exists in the database
@ResponseStatus(HttpStatus.CONFLICT)
public class PhoneNumberExistsException extends RuntimeException {
    public PhoneNumberExistsException(String message) {
        // Constructs a new PhoneNumberExistsException with the provided message
        super(message);
    }
}
