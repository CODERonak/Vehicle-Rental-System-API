package com.project.VehicleRentalSystemAPI.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This excption is thrown when the user details are invalid
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidLoginDetailsException extends RuntimeException {
    public InvalidLoginDetailsException(String message) {
        super(message);
    }
}