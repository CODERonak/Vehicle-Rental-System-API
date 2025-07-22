package com.project.VehicleRentalSystemAPI.model.entity;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.VehicleStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marks this class as an entity for JPA
@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates a constructor with all fields
@Builder(toBuilder = true) // Generates a builder pattern for object creation
@NoArgsConstructor // Generates a no-argument constructor, required by JPA
@Table(name = "vehicles") // Maps to the 'vehicle_categories' table
public class Vehicle {
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key to be auto-generated
    private Long id;

    @Column(nullable = false) // brand cannot be null
    private String brand;

    @Column(nullable = false) // Model cannot be null
    private String model;

    @Column(nullable = false) // Year cannot be null
    private int year;

    @Column(nullable = false) // License Plate cannot be null
    private String licensePlate;

    @Enumerated(EnumType.STRING) // Maps the enum to a string in the database
    @Column(nullable = false) // Cannot be null
    private VehicleStatus status;

    @ManyToOne(fetch = FetchType.LAZY) // Many vehicles can have one category
    @JoinColumn(name = "vehicle_category_id")
    private VehicleCategory vehicle;

    @Column(nullable = false) // Mileage cannot be null
    private int mileage;
}