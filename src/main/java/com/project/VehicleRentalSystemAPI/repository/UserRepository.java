package com.project.VehicleRentalSystemAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.VehicleRentalSystemAPI.model.entity.Users;

@Repository // this marks this class as a repo for database interaction
public interface UserRepository extends JpaRepository<Users, Long> {
    // These methods helps to find user with the email and phone number
    Optional<Users> findByEmail(String email);

    Optional<Users> findByPhoneNumber(Long phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(Long phoneNumber);
}