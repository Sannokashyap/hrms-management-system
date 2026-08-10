# HRMS - Human Resource Management System

A Human Resource Management System (HRMS) developed using Java, Spring Boot, Thymeleaf, MySQL, and Bootstrap. The application helps organizations manage employees, job postings, enquiries, feedback, and other HR-related operations through an easy-to-use web interface.

## Features

* Employee Management
* Department Management
* Employee Profile Management
* Responsive Dashboard
* Database-Driven Application
* CRUD Operations for HR Activities

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap 5

### Database

* MySQL

### Tools

* Eclipse IDE
* Git & GitHub
* Postman

## Project Structure

```text
hrms
├── src/main/java
├── src/main/resources
│   ├── templates
│   ├── static
│   └── application.properties
├── pom.xml
└── README.md
```

## Installation & Setup

### Clone Repository

```bash
git clone https://github.com/your-username/hrms-management-system.git
```

### Configure Database

1. Create a MySQL database:

   ```sql
   CREATE DATABASE hrmsdb;
   ```

2. Update database credentials in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hrmsdb
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

### Run Application

```bash
mvn spring-boot:run
```

Or run the project directly from Eclipse as a Spring Boot application.


## Future Enhancements

* Attendance Module
* Leave Management
* Payroll Management
* Role-Based Access Control
* Employee Performance Tracking
* Email Notifications
* Report Generation

## Repository

## Author

Sanno Kashyap

