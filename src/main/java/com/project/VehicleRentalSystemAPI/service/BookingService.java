package com.project.VehicleRentalSystemAPI.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.VehicleRentalSystemAPI.dto.booking.*;
import com.project.VehicleRentalSystemAPI.mappers.BookingMapper;
import com.project.VehicleRentalSystemAPI.model.entity.*;
import com.project.VehicleRentalSystemAPI.repository.*;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

// Booking service to create, update booking status and cancel bookings
@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final BookingMapper mapper;

    // create a new booking
    @Transactional // Marks this method as a transaction
    public BookingResponseDTO createBooking(BookingRequestDTO requestDTO) {
        Users user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Vehicle vehicle = vehicleRepository.findById(requestDTO.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Booking booking = mapper.toEntity(requestDTO, user, vehicle);

        Booking saved = bookingRepository.save(booking);
        return mapper.toDto(saved);
    }

    @Transactional
    public BookingResponseDTO updateBookingStatus(Long id, BookingStatusRequest requestDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(requestDTO.getStatus());
        Booking saved = bookingRepository.save(booking);
        return mapper.toDto(saved);
    }

    @Transactional
    public void cancelBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new EntityNotFoundException("Booking not found");
        }
        bookingRepository.deleteById(id);

    }
}
