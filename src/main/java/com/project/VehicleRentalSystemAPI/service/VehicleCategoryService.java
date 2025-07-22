package com.project.VehicleRentalSystemAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.VehicleRentalSystemAPI.dto.vehiclecategory.*;
import com.project.VehicleRentalSystemAPI.mappers.VehicleCategoryMapper;
import com.project.VehicleRentalSystemAPI.model.entity.VehicleCategory;
import com.project.VehicleRentalSystemAPI.repository.VehicleCategoryRepository;

import lombok.AllArgsConstructor;

// Service class for managing vehicle categories
@Service
@AllArgsConstructor
public class VehicleCategoryService {
    private final VehicleCategoryRepository vehicleCategoryRepository;
    private final VehicleCategoryMapper mapper;

    // Method to add a new vehicle category to the database
    public VehicleCategoryResponseDTO addCategory(VehicleCategoryRequestDTO requestDTO) {
        VehicleCategory newCategory = mapper.toEntity(requestDTO);
        VehicleCategory saved = vehicleCategoryRepository.save(newCategory);
        return mapper.toResponseDto(saved);
    }

    // Method to update an existing vehicle category in the database
    public VehicleCategoryResponseDTO updateCategory(Long id, VehicleCategoryRequestDTO requestDTO) {
        VehicleCategory existingCategory = mapper.toEntity(requestDTO);
        existingCategory.setId(id);
        VehicleCategory saved = vehicleCategoryRepository.save(existingCategory);
        return mapper.toResponseDto(saved);
    }

    // Method to get all vehicle categories from the database
    public List<VehicleCategoryResponseDTO> getAllCategories() {
        return vehicleCategoryRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

}