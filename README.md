# Spring Boot Thymeleaf Security Example

This project demonstrates a simple Spring Boot application with Thymeleaf templates and Spring Security integration.

## Features

- **Spring Boot**: Simplifies the development of Java applications.
- **Thymeleaf**: A modern server-side Java template engine for web applications.
- **Spring Security**: Provides authentication and authorization capabilities.

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/your-repo/spring-boot-thymeleaf-security.git
cd spring-boot-thymeleaf-security
```

### Build the Project

```sh
./mvnw clean install
```

### Run the Application

```sh
./mvnw spring-boot:run
```

### Access the Application

- Navigate to `http://localhost:8080` to access the home page.
- Use the following credentials to log in:
    - **Username**: `user`
    - **Password**: `password`

## Project Structure

- `src/main/java/com/example/springboot/Application.java`: Main class to run the Spring Boot application.
- `src/main/java/com/example/springboot/securityweb/WebSecurityConfig.java`: Configuration class for Spring Security.
- `src/main/resources/templates/`: Directory containing Thymeleaf templates.
    - `home.html`: Home page template.
    - `login.html`: Login page template.

## Configuration

### Spring Security

- Configured to allow access to the root (`/`) and home (`/home`) paths without authentication.
- Custom login page at `/login`.
- In-memory user details service with a default user.

### Thymeleaf

- Templates are located in the `src/main/resources/templates/` directory.
- Example templates include `home.html` and `login.html`.

