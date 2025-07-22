package com.project.VehicleRentalSystemAPI.mappers;

import com.project.VehicleRentalSystemAPI.dto.vehicle.*;
import com.project.VehicleRentalSystemAPI.model.entity.*;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    @Mapping(source = "vehicleCategoryId", target = "vehicle.id")
    Vehicle toEntity(VehicleRequestDTO dto);

    @Mapping(source = "vehicle.id", target = "vehicleCategoryId")
    @Mapping(source = "vehicle.categoryName", target = "vehicleCategoryName")
    VehicleResponseDTO toResponseDto(Vehicle entity);
}
