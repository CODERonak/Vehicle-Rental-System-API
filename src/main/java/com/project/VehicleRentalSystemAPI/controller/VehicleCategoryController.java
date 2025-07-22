package com.project.VehicleRentalSystemAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.project.VehicleRentalSystemAPI.dto.vehiclecategory.VehicleCategoryRequestDTO;
import com.project.VehicleRentalSystemAPI.dto.vehiclecategory.VehicleCategoryResponseDTO;
import com.project.VehicleRentalSystemAPI.service.VehicleCategoryService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class VehicleCategoryController {
    private final VehicleCategoryService service;

    // Endpoint for adding a new vehicle category
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')") // Only admins can add categories
    public ResponseEntity<VehicleCategoryResponseDTO> addCategory(
            @RequestBody @Valid VehicleCategoryRequestDTO requestDTO) {
                // Validates the request DTO using jakarta.validation
        VehicleCategoryResponseDTO saved = service.addCategory(requestDTO);
        // Saves the category and returns the response
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Endpoint for updating an existing vehicle category
    @PutMapping("/{id}") // Path variable for the category ID
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')") // Only admins can update categories
    public ResponseEntity<VehicleCategoryResponseDTO> updateCategory(@PathVariable Long id,
            @RequestBody @Valid VehicleCategoryRequestDTO requestDTO) {
                // Validates the request DTO using jakarta.validation
        VehicleCategoryResponseDTO updated = service.updateCategory(id, requestDTO);
        // Updates the category and returns the response
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // can be accessed publicely
    @GetMapping // Endpoint for getting all vehicle categories
    public ResponseEntity<List<VehicleCategoryResponseDTO>> getAllCategories() {
        List<VehicleCategoryResponseDTO> categories = service.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}