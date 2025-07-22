package com.project.VehicleRentalSystemAPI.dto.vehicle;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.VehicleStatus;

import jakarta.validation.constraints.*;

import lombok.*;

// DTO for vehicle request
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDTO {
    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Long vehicleCategoryId;

    @Min(2000)
    private int year;
    
    @NotBlank
    private String licensePlate;

    @Min(0)
    private int mileage;

    @NotNull
    private VehicleStatus status;

}
