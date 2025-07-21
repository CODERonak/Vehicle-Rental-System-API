package com.project.VehicleRentalSystemAPI.dto.auth;

import jakarta.validation.constraints.*;
import lombok.*;

// DTO for user login request
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserLoginRequestDTO {
    @Email // Validates email format
    private String email;

    @NotBlank // Cannot be null or empty
    @Size(min = 8) // Must be at least 8 characters long
    private String password;
}