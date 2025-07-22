package com.project.VehicleRentalSystemAPI.dto.vehiclecategory;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

// DTO for vehicle category request
@Data 
@Builder
@NoArgsConstructor 
@AllArgsConstructor
public class VehicleCategoryRequestDTO {
    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal baseRatePerDay;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal lateFeePerDay;
}