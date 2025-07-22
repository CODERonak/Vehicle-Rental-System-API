package com.project.VehicleRentalSystemAPI.dto.vehiclecategory;

import java.math.BigDecimal;

import lombok.*;

// DTO for vehicle category response
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class VehicleCategoryResponseDTO {
    private Long id;
    private String categoryName;
    private String description;
    private BigDecimal baseRatePerDay;
    private BigDecimal lateFeePerDay;
}