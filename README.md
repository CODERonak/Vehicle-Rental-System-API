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

  **Available**
  * `POST api/auth/register` - Register a new user.
  * `POST api/auth/login` - Authenticate user and receive JWT.
  * `GET api/vehicles` - Browse available vehicles (limited details).
  * `GET api/categories` - View vehicle categories.
  * `GET api/vehicles/available` - Search for available vehicles by date range and category.

### Protected Endpoints

All other endpoints require a valid JWT in the `Authorization: Bearer <token>` header. Roles (`ADMIN`, `CUSTOMER`, `AGENT`) are enforced for specific endpoints using Spring Security's `@PreAuthorize` annotations.

-----

## 🌐 API Endpoints

Here's a summary of the main API endpoints.

### Authentication

  * `POST api/auth/register` - Register a new user (`CUSTOMER` by default).
  * `POST api/auth/login` - Authenticate user and receive JWT.

 **These endpoints are not yet available**
### Vehicle Management (ADMIN, AGENT)

  * `POST api/vehicles` - Add a new vehicle.
  * `PUT api/vehicles/{id}` - Update an existing vehicle.
  * `PUT api/vehicles/{id}/status` - Change a vehicle's availability status.
  * `GET api/vehicles` - Get a list of all vehicles.

### Vehicle Category Management (ADMIN)

  * `POST api/categories` - Create a new vehicle category.
  * `GET api/categories` - Get a list of all vehicle categories.

### Booking Management (CUSTOMER, AGENT, ADMIN)

  * `POST api/bookings` (CUSTOMER) - Create a new booking for a vehicle.
  * `PUT api/bookings/{id}` (ADMIN) - updates the booking status
  * `DELETE api/bookings/{id}` (CUSTOMER) - cancels the booking 
 

-----