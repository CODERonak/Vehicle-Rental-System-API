package com.project.VehicleRentalSystemAPI.dto.auth;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserLoginResponseDTO {
    private String email;
    private String phoneNumber;
    private String token;
}