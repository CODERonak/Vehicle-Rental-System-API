package com.project.VehicleRentalSystemAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.project.VehicleRentalSystemAPI.dto.vehicle.*;
import com.project.VehicleRentalSystemAPI.service.VehicleService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/vehicles")
@AllArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping // Endpoint for adding a new vehicle
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<VehicleResponseDTO> addVehicle(@RequestBody @Valid VehicleRequestDTO requestDTO) {
        VehicleResponseDTO response = vehicleService.addVehicle(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // Endpoint for updating a vehicle
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<VehicleResponseDTO> updateVehicle(@PathVariable Long id,
            @RequestBody @Valid VehicleRequestDTO requestDTO) {
        VehicleResponseDTO updatedResponse = vehicleService.updateVehicle(id, requestDTO);
        return new ResponseEntity<>(updatedResponse, HttpStatus.OK);
    }

    @GetMapping // Endpoint for getting all vehicles
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles() {
        List<VehicleResponseDTO> categories = vehicleService.getAllVehicles();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

}