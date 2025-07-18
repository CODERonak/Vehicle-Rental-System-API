package com.project.VehicleRentalSystemAPI.exceptions;

import lombok.Data;

// added error response
@Data
public class ErrorResponse {

    // it shows these fields in the response when an error occurs
    private int status;
    private String error;
    private String message;

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}