package com.project.VehicleRentalSystemAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.project.VehicleRentalSystemAPI.dto.booking.*;
import com.project.VehicleRentalSystemAPI.service.BookingService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

// Controller class for managing bookings
@RestController
@RequestMapping("api/bookings")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    // Endpoint to create a new booking
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody @Valid BookingRequestDTO requestDTO) {
        BookingResponseDTO responseDTO = bookingService.createBooking(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // Endpoint to cancel a booking
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to update the status of a booking
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<BookingResponseDTO> updateBookingStatus(@PathVariable Long id,
            @RequestBody @Valid BookingStatusRequest requestDTO) {
        BookingResponseDTO responseDTO = bookingService.updateBookingStatus(id, requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}