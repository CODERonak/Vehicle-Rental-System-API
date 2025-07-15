package com.project.VehicleRentalSystemAPI.model.enums;

public class Enums {
    public enum Role {
        ADMIN,
        CUSTOMER,
        AGENT
    }

    public enum VehicleStatus {
        AVAILABLE,
        RENTED,
        MAINTENANCE,
        RESERVED
    }

    public enum BookingStatus {
        PENDING,
        ACCEPTED,
        REJECTED,
        COMPLETED
    }
}