package com.project.VehicleRentalSystemAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.VehicleRentalSystemAPI.dto.auth.*;
import com.project.VehicleRentalSystemAPI.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

// User controller for handling user registration and login
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UserController {
   private final UserService userService;

   // registers new user
   @PostMapping("/register")
   public ResponseEntity<UserRegisterResponseDTO> register(
         @RequestBody @Valid UserRegisterRequestDTO userRegisterRequestDTO) {
      UserRegisterResponseDTO userRegisterResponse = userService.registerUser(userRegisterRequestDTO);

      // returns the user register response dto as response with status code 201
      // (Created)
      return new ResponseEntity<>(userRegisterResponse, HttpStatus.CREATED);
   }

   @PostMapping("login")
   public ResponseEntity<UserLoginResponseDTO> login(
         @RequestBody @Valid UserLoginRequestDTO userLoginRequestDTO) {
      UserLoginResponseDTO userLoginResponse = userService.loginUser(userLoginRequestDTO);
      return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
   }
}