package com.project.VehicleRentalSystemAPI.dto.booking;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.BookingStatus;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDTO {
    private Long id;
    private Long userId;
    private Long vehicleId;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BookingStatus status;
    private BigDecimal totalCost;
    private BigDecimal lateFees;
}
