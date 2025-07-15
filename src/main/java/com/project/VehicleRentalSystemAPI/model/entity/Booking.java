package com.project.VehicleRentalSystemAPI.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.BookingStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marks this class as an entity for JPA
@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Generates a builder pattern for object creation
@NoArgsConstructor // Generates a no-argument constructor, required by JPA
@Table(name = "booking") // Maps to the 'vehicle_categories' table
public class Booking {
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key to be auto-generated
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Many bookings can be made by one user
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column, cannot be null
    private Users user; // Relationship to the User entity

    @ManyToOne(fetch = FetchType.LAZY) // Many bookings can be for one vehicle
    @JoinColumn(name = "vehicle_id", nullable = false) // Foreign key column, cannot be null
    private Vehicle vehicle; // Relationship to the Vehicle entity

    @Column(nullable = false) // Cannot be null
    private LocalDate pickupDate;

    @Column(nullable = false) // Cannot be null
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING) // Stores the enum as its String name in the database
    @Column(nullable = false) // Cannot be null
    private BookingStatus status; // 

    @Column(nullable = false, precision = 10, scale = 2) // Defines column for BigDecimal with precision and scale
    private BigDecimal totalCost;

    @Column(nullable = false, precision = 10, scale = 2) // Defines column for BigDecimal with precision and scale
    private BigDecimal lateFees;
}