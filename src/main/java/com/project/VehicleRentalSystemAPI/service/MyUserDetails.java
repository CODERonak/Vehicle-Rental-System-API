package com.project.VehicleRentalSystemAPI.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.VehicleRentalSystemAPI.model.entity.Users;

import lombok.AllArgsConstructor;

@AllArgsConstructor // Generates a constructor with the field user
public class MyUserDetails implements UserDetails {

    private final Users user;

    // returns the user's authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
        return authorities;
    }

    // returns the user's password
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // returns the user's email
    @Override
    public String getUsername() {
        return user.getEmail();
    }

}