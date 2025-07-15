package com.project.VehicleRentalSystemAPI.model.entity;

import com.project.VehicleRentalSystemAPI.model.enums.Enums.Role;

import jakarta.persistence.*;
import lombok.*;

@Entity // Marks this class as an entity for JPA
@Data // Generates getters, setters, toString, equals, hashCode
@AllArgsConstructor // Generates a constructor with all fields
@Builder // Generates a builder pattern for object creation
@NoArgsConstructor // Generates a no-argument constructor, required by JPA
@Table(name = "users") // Maps to the 'users' table
public class Users {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the primary key to be auto-generated
    private Long id; // Primary key field

    @Column(nullable = false, unique = true) // Phone number cannot be null
    private Long phoneNumber;

    @Column(nullable = false, unique = true) // Email cannot be null and must be unique
    private String email;

    @Column(nullable = false) // Password cannot be null
    private String password;

    @Enumerated(EnumType.STRING) // Maps the enum to a string in the database
    @Column(nullable = false) // Cannot be null
    private Role role;

    @Column(nullable = false) // IsActive cannot be null
    private boolean isActive; // Indicates if the user is active
}