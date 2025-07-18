package com.project.VehicleRentalSystemAPI.dto;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.Role;

import jakarta.validation.constraints.*;
import lombok.*;

// DTO for user registration request
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRegisterRequestDTO {

    @NotNull
    private Long phoneNumber;

    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    private Role role;
}
