package com.project.VehicleRentalSystemAPI.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.VehicleRentalSystemAPI.dto.auth.*;
import com.project.VehicleRentalSystemAPI.exceptions.custom.*;
import com.project.VehicleRentalSystemAPI.jwt.JWTUtil;
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
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

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

    // Logins a user and returns jwt token
    public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO) {
        // Authenticates the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequestDTO.getEmail(),
                        userLoginRequestDTO.getPassword()));

        // Sets the authentication in the context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generates a jwt token
        String jwtToken = jwtUtil.generateToken(userLoginRequestDTO.getEmail());

        // Finds the user by email
        Users loggedInUser = userRepository.findByEmail(userLoginRequestDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Maps the user to a response DTO
        UserLoginResponseDTO responseDTO = userMapper.toUserLoginResponseDTO(loggedInUser);

        // Sets the jwt token in the response DTO
        responseDTO.setToken(jwtToken);

        // Returns the response DTO
        return responseDTO;
    }
}