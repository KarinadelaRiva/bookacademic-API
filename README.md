# Bookademic API

> A smart and scalable REST API for managing educational space reservations.

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-success?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.9.2-orange?logo=apachemaven)
![License](https://img.shields.io/badge/License-Apache_2.0-blue)
![Status](https://img.shields.io/badge/status-In_Development-yellow)

---

## 🚀 Features

- Role-based access control (Admin, Teacher, Guest) with Spring Security and JWT
- Management of educational spaces (classrooms, labs, etc.)
- Reservation requests and approval workflow
- Secure authentication via JWT (using java-jwt and jjwt libraries)
- DTO validation with Jakarta Validation API
- Layered architecture (Controllers, Services, Repositories)
- OpenAPI / Swagger documentation with springdoc-openapi

---

## 🛠️ Technologies

- Java 21 (compiled with source/target 22)
- Spring Boot 3.4.5
- Spring Security + JWT (java-jwt & jjwt)
- Spring Data JPA (Hibernate)
- MySQL 8
- Maven
- Lombok (provided)
- Jakarta Validation API
- Swagger UI (springdoc-openapi)

---

## 🧪 Getting Started

### Prerequisites

- Java 21+ (JDK installed)
- Maven 3.6+
- MySQL 8+ database running

### Clone the project

```bash
git clone https://github.com/tu-usuario/bookademic-api.git
cd bookademic-api
