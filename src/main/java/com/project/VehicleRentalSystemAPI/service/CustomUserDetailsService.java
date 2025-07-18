package com.project.VehicleRentalSystemAPI.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.VehicleRentalSystemAPI.model.entity.Users;
import com.project.VehicleRentalSystemAPI.repository.UserRepository;

import lombok.AllArgsConstructor;

// creates a custom user details service
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    // This method is used to load user details from the database
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Find the user by email
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("email not found with username: " + email));

        // return's a custom user details object
        return new MyUserDetails(user);
    }
}