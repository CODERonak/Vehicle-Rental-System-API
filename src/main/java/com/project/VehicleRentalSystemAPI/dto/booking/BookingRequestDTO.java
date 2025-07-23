package com.project.VehicleRentalSystemAPI.dto.booking;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long vehicleId;

    @NotNull
    private LocalDate pickupDate;

    @NotNull
    private LocalDate returnDate;

    @NotNull
    private BigDecimal totalCost;

    @NotNull
    private BigDecimal lateFees;
}