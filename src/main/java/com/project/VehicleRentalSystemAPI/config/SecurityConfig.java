package com.project.VehicleRentalSystemAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // authorizes the api endpoints
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated())

                // enables basic authentication
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.disable())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // password encoder for hashing passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}