package com.project.VehicleRentalSystemAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.VehicleRentalSystemAPI.model.entity.Users;

@Repository // this marks this class as a repo for database interaction
public interface UserRepository extends JpaRepository<Users, Long> {
    // These methods helps to find user with the email and phone number
    Users findByEmail(String email);

    Users findByPhoneNumber(Long phoneNumber);
}