package com.project.VehicleRentalSystemAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.VehicleRentalSystemAPI.model.entity.VehicleCategory;

@Repository // this marks this class as a repo for database interaction
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {

}
