package com.project.VehicleRentalSystemAPI.dto.vehicle;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.VehicleStatus;
import lombok.*;

// DTO for vehicle response
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private Long vehicleCategoryId;
    private int year;
    private String licensePlate;
    private int mileage;
    private VehicleStatus status;
}