# College

Simple Spring Boot application designed to manage basic information about a college.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Database](#database)
- [Build and Run](#build-and-run)
- [Endpoints](#endpoints)

## Prerequisites

Ensure you have the following installed on your machine:

- Java 17
- Maven
- IDE (e.g., IntelliJ, Eclipse)
- Postgres Database (for production)

## Getting Started

Clone the repository:

```bash
git clone https://github.com/SergejKubat/college
```

Change into the project directory:

```bash
cd college
```

## Configuration

Update the application.properties file with the appropriate configuration for your database:

```properties
# H2 Database Configuration (for local development)
spring.datasource.url=jdbc:h2:mem:test_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false

# Postgres Database Configuration (for production)
# Uncomment and update the following properties for production or alternative database
# spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
# spring.datasource.username=your_username
# spring.datasource.password=your_password
# spring.datasource.driverClassName=org.postgresql.Driver

# spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
# spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
# spring.jpa.hibernate.ddl-auto=update
```

## Database

This project supports both H2 and Postgres databases. You can choose the desired database by updating the 
application.properties file.

## Build and Run

Build the project using Maven:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

The application will start on http://localhost:8080.

## Endpoints

API documentation: http://localhost:8080/swagger-ui/index.html