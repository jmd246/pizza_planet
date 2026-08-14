# Pizza Planet Store Front

A Spring Boot REST API for a pizza store application. The project provides functionality for customer accounts, pizzas, toppings, and order management.

## Features

- Customer account management
  - Create customer accounts
  - Login
  - Update account information
  - Username uniqueness enforcement
  - Email uniqueness enforcement

- Pizza management
  - View available pizzas
  - Search pizzas

- Order management
  - Place orders
  - View order history

- Topping management
  - Add toppings
  - Update toppings
  - Delete toppings

- Persistence
  - MySQL database
  - Spring Data JPA
  - Hibernate ORM
  - Automatic database schema management during development

- Security
  - Spring Security
  - Authentication and authorization
  - CSRF configuration for API development
  - JWT authentication planned for a future implementation

## Technologies

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate
- MySQL
- Maven

## Prerequisites

Make sure the following are installed:

- Java 21 or later
- Maven
- MySQL

Verify your Java and Maven installations:

```bash
java -version
mvn -version
