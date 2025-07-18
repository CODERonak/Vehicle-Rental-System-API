package com.project.VehicleRentalSystemAPI.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.VehicleRentalSystemAPI.dto.UserRegisterRequestDTO;
import com.project.VehicleRentalSystemAPI.dto.UserRegisterResponseDTO;
import com.project.VehicleRentalSystemAPI.exceptions.custom.*;
import com.project.VehicleRentalSystemAPI.mappers.UserMapper;
import com.project.VehicleRentalSystemAPI.model.entity.Users;
import com.project.VehicleRentalSystemAPI.repository.UserRepository;

import lombok.AllArgsConstructor;

// This class register's and logins the user
@Service // Marks this class as a service for business logic
@AllArgsConstructor // Generates a constructor with all fields
public class UserService {
    // fields for constructor injection
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    // Registers a new user and returns the registered user
    public UserRegisterResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequestDTO) {

        // Check's if the phone number or email already exists to throw an exception
        if (userRepository.existsByPhoneNumber(userRegisterRequestDTO.getPhoneNumber())) {
            throw new PhoneNumberExistsException("Phone number already exists so use another");
        }

        if (userRepository.existsByEmail(userRegisterRequestDTO.getEmail())) {
            throw new EmailExistsException("Email already exists so use another");
        }

        // Map's the request DTO to a User entity
        Users user = userMapper.toUser(userRegisterRequestDTO);

        // Sets the isActive to true
        user.setActive(true);

        // Sets the password to the encoded password
        user.setPassword(passwordEncoder.encode(userRegisterRequestDTO.getPassword()));

        // Saves the user to the database
        Users savedUser = userRepository.save(user);

        // Maps the saved user to a response DTO
        return userMapper.toUserRegisterResponseDTO(savedUser);
    }

}