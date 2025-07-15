package com.project.VehicleRentalSystemAPI.dto;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.Role;
import lombok.*;

// DTO for user registration response
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRegisterResponseDTO {
    private Long id;
    private String phoneNumber; // If phoneNumber is the identifier
    private String email;
    private Role role;
    private boolean isActive;
}