package com.project.VehicleRentalSystemAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.VehicleRentalSystemAPI.exceptions.custom.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Exception handler for EmailExistsException
    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<ErrorResponse> handleEmailExistsException(
            EmailExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PhoneNumberExistsException.class)
    public ResponseEntity<ErrorResponse> handlePhoneNumberExistsException(
            PhoneNumberExistsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidLoginDetailsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidLoginDetailsException(
            InvalidLoginDetailsException ex) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

}