Here's the `README.md` for your Vehicle Rental System API, formatted similarly to your example:

-----

# 🚗 Vehicle Rental System API

**NOTE: This API is still under development.**

-----

## 🎯 Objective

This project delivers a **Vehicle Rental System API** built with Spring Boot. It adheres to clean architecture principles, RESTful design, and robust security, providing a solid foundation for managing vehicle rentals, users, and booking processes.

-----

## ✨ Features

  * **User Management & Authentication:** Secure registration and login for `CUSTOMER`, `AGENT`, and `ADMIN` roles with JWT-based authentication.
  * **Vehicle Management:** Comprehensive CRUD operations for vehicles, including make, model, year, license plate, and availability status.
  * **Vehicle Category Management:** Define and manage different categories of vehicles with base and late fees.
  * **Booking System:** Customers can create, view, update, and cancel vehicle bookings. Agents can manage booking statuses.
  * **Availability Checks:** Robust logic to check vehicle availability, handling date overlaps and concurrency.
  * **Dynamic Pricing:** Calculation of total cost and late fees based on rental duration and vehicle rates.
  * **Advanced Security:** Role-based access control, encrypted passwords, and stateless API design.
  * **Data Validation:** Extensive validation rules for DTOs and business logic.
  * **Global Exception Handling:** Consistent and informative error responses across the API.

-----

## 🛠️ Technologies Used

  * **Spring Boot:** Framework for building robust, stand-alone, production-grade Spring applications.
  * **Spring Data JPA:** For simplified data access and persistence with Hibernate.
  * **Spring Security:** Comprehensive security services for Java EE-based enterprise software applications.
  * **PostgreSQL / MySQL:** Relational database for production environments.
  * **Java 17+:** The core programming language.
  * **Lombok:** Reduces boilerplate code (getters, setters, constructors).
  * **MapStruct:** High-performance code generator for DTO \<-\> Entity mappings.
  * **Postman:** For API testing and development.
  * **Git & GitHub:** Version control and hosting.

-----

## 📦 Project Structure

The project follows a modular structure, promoting separation of concerns and maintainability:

```
src/
└── main/
    ├── java/
    │   └── com.example.vehiclerental/
    │       ├── VehicleRentalSystemApplication.java // Main application entry point
    │       ├── controller/      // REST controllers exposing API endpoints
    │       ├── service/         // Business logic and transaction management
    │       ├── repository/      // Spring Data JPA interfaces for data access
    │       ├── model/           // JPA entities, enums, and embeddables
    │       │   ├── entity/
    │       │   └── enums/
    │       ├── dto/             // Data Transfer Objects for request/response payloads
    │       ├── config/          // Security and application-specific configurations
    │       ├── security/        // JWT filters, UserDetails service, Security config
    │       ├── exception/       // Custom and global exception handlers
    │       ├── util/            // Utility classes (e.g., JWT helpers, date formatters)
    │       └── mapper/          // MapStruct interfaces for DTO-Entity conversions
    └── resources/
        ├── application.properties      // Application configurations
```

-----

## 🔑 Security & Authentication

The API uses **JWT (JSON Web Tokens)** for stateless authentication and **Role-Based Access Control (RBAC)**.

### Public Endpoints

  * `POST /auth/register` - Register a new user.
  * `POST /auth/login` - Authenticate user and receive JWT.
  * `GET /vehicles` - Browse available vehicles (limited details).
  * `GET /categories` - View vehicle categories.
  * `GET /vehicles/available` - Search for available vehicles by date range and category.

### Protected Endpoints

All other endpoints require a valid JWT in the `Authorization: Bearer <token>` header. Roles (`ADMIN`, `CUSTOMER`, `AGENT`) are enforced for specific endpoints using Spring Security's `@PreAuthorize` annotations.

-----

## 🌐 API Endpoints

Here's a summary of the main API endpoints.

### Authentication

  * `POST /auth/register` - Register a new user (`CUSTOMER` by default).
  * `POST /auth/login` - Authenticate user and receive JWT.

### Vehicle Management (ADMIN, AGENT)

  * `POST /vehicles` - Add a new vehicle.
  * `PUT /vehicles/{id}` - Update an existing vehicle.
  * `PUT /vehicles/{id}/status` - Change a vehicle's availability status.
  * `GET /vehicles` - Get a list of all vehicles.
  * `GET /vehicles/available?start=yyyy-MM-dd&end=yyyy-MM-dd&category=SUV` - Find available vehicles within a date range and optionally by category.

### Vehicle Category Management (ADMIN)

  * `POST /categories` - Create a new vehicle category.
  * `GET /categories` - Get a list of all vehicle categories.

### Booking Management (CUSTOMER, AGENT, ADMIN)

  * `POST /bookings` (CUSTOMER) - Create a new booking for a vehicle.
  * `GET /bookings/user/{userId}` (CUSTOMER, ADMIN, AGENT) - Get bookings for a specific user.
  * `PUT /bookings/{bookingId}/cancel` (CUSTOMER, ADMIN, AGENT) - Cancel an existing booking.
  * `PUT /bookings/{bookingId}/complete` (AGENT, ADMIN) - Mark a booking as completed (e.g., after vehicle return).

-----