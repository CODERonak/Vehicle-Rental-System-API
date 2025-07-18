package com.project.VehicleRentalSystemAPI.repository;

// import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.VehicleRentalSystemAPI.model.entity.Booking;
import com.project.VehicleRentalSystemAPI.model.enums.Enums.BookingStatus;

@Repository // this marks this class as a repo for database interaction
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // These methods helps to find bookings with the status and checks vehicle
    // availability
    List<Booking> findByUserIdAndStatus(Long userId, BookingStatus status);

    // boolean existsByVehicleIdAndDateRange(Long vehicleId, LocalDate start, LocalDate end);

}