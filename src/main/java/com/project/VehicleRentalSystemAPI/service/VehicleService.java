package com.project.VehicleRentalSystemAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.VehicleRentalSystemAPI.dto.vehicle.*;
import com.project.VehicleRentalSystemAPI.mappers.VehicleMapper;
import com.project.VehicleRentalSystemAPI.model.entity.Vehicle;
import com.project.VehicleRentalSystemAPI.model.entity.VehicleCategory;
import com.project.VehicleRentalSystemAPI.model.enums.Enums.VehicleStatus;
import com.project.VehicleRentalSystemAPI.repository.VehicleCategoryRepository;
import com.project.VehicleRentalSystemAPI.repository.VehicleRepository;

import lombok.AllArgsConstructor;

// Service class for managing vehicles
@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleCategoryRepository vehicleCategoryRepository;
    private final VehicleMapper mapper;

    // Method to add a new vehicle to the database
    public VehicleResponseDTO addVehicle(VehicleRequestDTO requestDTO) {
        Vehicle vehicle = mapper.toEntity(requestDTO);
        vehicle.setVehicle(vehicleCategoryRepository.findById(requestDTO.getVehicleCategoryId()).orElseThrow());
        Vehicle saved = vehicleRepository.save(vehicle);
        return mapper.toResponseDto(saved);
    }

    // Method to update an existing vehicle in the database
    public VehicleResponseDTO updateVehicle(Long id, VehicleRequestDTO requestDTO) {

        Vehicle existing = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        VehicleCategory category = vehicleCategoryRepository.findById(requestDTO.getVehicleCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle category not found"));

        Vehicle updated = existing.toBuilder()
                .id(id)
                .brand(requestDTO.getBrand())
                .model(requestDTO.getModel())
                .year(requestDTO.getYear())
                .licensePlate(requestDTO.getLicensePlate())
                .status(requestDTO.getStatus())
                .vehicle(category)
                .mileage(requestDTO.getMileage())
                .build();

        Vehicle saved = vehicleRepository.save(updated);
        return mapper.toResponseDto(saved);
    }

    // Method to get all vehicles from the database
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    // method to get vehicles according to their status
    public List<VehicleResponseDTO> getVehiclesByStatus(VehicleStatus status) {
        return vehicleRepository.findByStatus(status.AVAILABLE)
                .stream()
                .map(mapper::toResponseDto)
                .toList();
    }

}