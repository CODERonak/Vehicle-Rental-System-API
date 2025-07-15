package com.project.VehicleRentalSystemAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.VehicleRentalSystemAPI.model.entity.Vehicle;
import com.project.VehicleRentalSystemAPI.model.enums.Enums.VehicleStatus;

@Repository // this marks this class as a repo for database interaction
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // This methods helps to find vehicles with the status
    List<Vehicle> findByStatus(VehicleStatus status);
}