package com.project.VehicleRentalSystemAPI.dto.booking;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.BookingStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

// DTO for updating the booking status request
@Data
public class BookingStatusRequest {
    @NotNull
    BookingStatus status;
}