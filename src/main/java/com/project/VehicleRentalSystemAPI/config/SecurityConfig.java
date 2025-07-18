package com.project.VehicleRentalSystemAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.VehicleRentalSystemAPI.service.CustomUserDetailsService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // authorizes the api endpoints
        http.authorizeHttpRequests(requests -> requests
                // public endpoints which requires no authentication
                .requestMatchers("/api/auth/**", "/test").permitAll()
                .anyRequest().authenticated())

                // enables basic authentication
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.disable())
                .authenticationManager(authenticationManager())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }

    // password encoder for hashing passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}