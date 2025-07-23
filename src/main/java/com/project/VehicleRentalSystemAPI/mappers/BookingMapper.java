package com.project.VehicleRentalSystemAPI.mappers;

import org.mapstruct.*;

import com.project.VehicleRentalSystemAPI.dto.booking.BookingRequestDTO;
import com.project.VehicleRentalSystemAPI.dto.booking.BookingResponseDTO;
import com.project.VehicleRentalSystemAPI.model.entity.Booking;
import com.project.VehicleRentalSystemAPI.model.entity.Users;
import com.project.VehicleRentalSystemAPI.model.entity.Vehicle;

// MapStruct mapper for converting between Booking and Booking DTO's
@Mapper(componentModel = "spring")
public interface BookingMapper {

    // Converts a Booking entity to a BookingResponseDTO
    @Mapping(source = "user.id", target = "userId") // Maps user.id to userId
    @Mapping(source = "vehicle.id", target = "vehicleId") // Maps vehicle.id to vehicleId
    BookingResponseDTO toDto(Booking booking); // Converts a Booking entity to a BookingResponseDTO

    @Mapping(target = "id", ignore = true) // Ignores id during mapping
    @Mapping(target = "status", constant = "PENDING") // Sets status to PENDING
    @Mapping(target = "user", source = "user") // Maps user to user
    @Mapping(target = "vehicle", source = "vehicle") // Maps vehicle to vehicle
    // Converts a BookingRequestDTO to a Booking entity
    Booking toEntity(BookingRequestDTO dto, Users user, Vehicle vehicle);
}