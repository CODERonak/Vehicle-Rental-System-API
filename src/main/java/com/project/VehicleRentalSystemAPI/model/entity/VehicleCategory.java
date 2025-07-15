package com.project.VehicleRentalSystemAPI.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marks this class as an entity for JPA
@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Generates a builder pattern for object creation
@NoArgsConstructor // Generates a no-argument constructor, required by JPA
@Table(name = "vehicle_categories") // Maps to the 'vehicle_categories' table
public class VehicleCategory {
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key to be auto-generated
    private Long id;

    @Column(nullable = false, unique = true) // Category name cannot be null and must be unique
    private String categoryName;

    @Column(nullable = false) // Description cannot be null
    private String description;

    @Column(nullable = false, precision = 10, scale = 2) // Defines column for BigDecimal with precision and scale
    private BigDecimal baseRatePerDay; // Base rate per day for this category

    @Column(nullable = false, precision = 10, scale = 2) // Defines column for BigDecimal with precision and scale
    private BigDecimal lateFeePerDay; // Late fee per day for this category
}
