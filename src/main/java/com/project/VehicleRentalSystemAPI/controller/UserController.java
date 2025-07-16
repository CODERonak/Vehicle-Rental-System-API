package com.project.VehicleRentalSystemAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.VehicleRentalSystemAPI.dto.UserRegisterRequestDTO;
import com.project.VehicleRentalSystemAPI.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UserController {
   private final UserService userService;

   @PostMapping("/register")
   public ResponseEntity<String> register(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO) {
      userService.registerUser(userRegisterRequestDTO);
      return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
   }
}