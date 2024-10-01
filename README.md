# Backend Application - User and Car Management API

This project is a Spring Boot RESTful API that provides endpoints for managing users and their cars. The API allows querying, searching, and sorting of users and cars. It connects to a PostgreSQL database for persistence.

## Prerequisites

Ensure the following tools are installed on your machine:

- **Java** (version 11 or higher)
- **Gradle** (version 6 or higher)
- **PostgreSQL** (or use any PostgreSQL-compatible cloud service)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/rkaselt/proovJava.git
cd backend-app
``` 

### 2. Configure PostgreSQL Database
CREATE DATABASE userdb;

Modify the application.properties file located in src/main/resources/ with your PostgreSQL credentials:

```bash
spring.datasource.username=postgres
spring.datasource.password=postgres
``` 

### 3. Build and Run the Application

You can build and run the application using Gradle:
```bash
./gradlew bootRun
``` 

### API access
```bash
http://localhost:8080
``` 

## Technologies Used
- Java 11 - Core backend programming language
- Spring Boot - Framework for building the RESTful API
- PostgreSQL - Database for storing user and car information
- Gradle - Build automation tool
- Lombok - Used to reduce boilerplate code for model classes
- JUnit - Testing framework for unit tests
