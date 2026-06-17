# WorkBoard - Task Management REST API

## Overview

WorkBoard is a Task Management REST API built using Spring Boot. It enables secure project, task, comment, and user management through JWT-based authentication and role-based authorization.

The application follows a layered architecture with DTO separation, service abstraction, repository pattern, global exception handling, and Spring Security integration.

---

# Features

## Authentication & Authorization

* User Registration
* User Login
* JWT Token Generation
* JWT Token Validation
* Spring Security Integration
* Role-Based Access Control

## User Management

* View User By Email
* Update User
* Delete User

## Project Management

* Create Projects
* View All Projects
* View Project By ID

## Task Management

* Create Tasks
* Update Tasks
* Delete Tasks
* Update Task Status
* Get Tasks By Status
* Get Tasks By Priority
* Get Tasks By User
* Get Tasks By Project

## Comment Management

* Add Comments To Tasks
* View Task Comments

---

# Tech Stack

## Backend

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate

## Database

* MySQL 8

## Authentication

* JWT (JSON Web Token)

## Build Tool

* Maven

## Deployment

* AWS EC2 (Ubuntu Linux)

---

# Project Structure

```text
src
└── main
    ├── java
    │   └── com.WorkBoardProject.workboard
    │       ├── config
    │       │   ├── PasswordConfig
    │       │   └── SecurityConfig
    │       │
    │       ├── controller
    │       │   ├── AuthController
    │       │   ├── UserController
    │       │   ├── ProjectController
    │       │   ├── TaskController
    │       │   └── CommentsController
    │       │
    │       ├── dto
    │       │   ├── Request
    │       │   └── Response
    │       │
    │       ├── entity
    │       │   ├── Users
    │       │   ├── Projects
    │       │   ├── Tasks
    │       │   └── Comments
    │       │
    │       ├── repository
    │       │   ├── UserRepository
    │       │   ├── ProjectRepository
    │       │   ├── TaskRepository
    │       │   └── CommentRepository
    │       │
    │       ├── security
    │       │   ├── JwtFilter
    │       │   ├── JwtUtil
    │       │   └── CustomUserDetailsService
    │       │
    │       ├── service
    │       │   ├── AuthService
    │       │   ├── UserService
    │       │   ├── ProjectService
    │       │   ├── TaskService
    │       │   └── CommentService
    │       │
    │       ├── serviceimpl
    │       │   ├── AuthServiceImpl
    │       │   ├── UserServiceImpl
    │       │   ├── ProjectServiceImpl
    │       │   ├── TaskServiceImpl
    │       │   └── CommentServiceImpl
    │       │
    │       └── WorkboardApplication
    │
    └── resources
        └── application.properties
```

---

# Database Design

## Users

* userId
* name
* email
* password
* role

## Projects

* id
* name
* description
* createdBy

## Tasks

* id
* title
* description
* priority
* status
* dueDate
* assignedUser
* project

## Comments

* id
* content
* task
* user

---

# Entity Relationships

```text
User
 ├── Projects (OneToMany)
 ├── Tasks (OneToMany)
 └── Comments (OneToMany)

Project
 └── Tasks (OneToMany)

Task
 ├── Project (ManyToOne)
 ├── Assigned User (ManyToOne)
 └── Comments (OneToMany)

Comment
 ├── User (ManyToOne)
 └── Task (ManyToOne)
```

---

# Security

## Roles

```text
ADMIN
EMPLOYEE
USER
```

## Access Rules

```text
/api/auth/**       -> Public

/api/user/**       -> ADMIN

/api/projects/**   -> ADMIN

/api/tasks/**      -> ADMIN, EMPLOYEE, USER

/api/comments/**   -> Authenticated Users
```

JWT authentication is implemented using Spring Security filters and stateless token validation.

---

# API Endpoints

## Authentication

```http
POST /api/auth/register
POST /api/auth/login
```

## Users

```http
GET    /api/user/{email}
PATCH  /api/user/{email}
DELETE /api/user/{email}
```

## Projects

```http
POST /api/projects
GET  /api/projects
GET  /api/projects/{id}
```

## Tasks

```http
POST   /api/tasks
GET    /api/tasks
GET    /api/tasks/{id}
PATCH  /api/tasks/{id}
DELETE /api/tasks/{id}

GET    /api/tasks/status/{status}
GET    /api/tasks/priority/{priority}
GET    /api/tasks/user/{userId}
GET    /api/tasks/project/{projectId}

PATCH  /api/tasks/{id}/status
```

## Comments

```http
POST /api/comments
GET  /api/comments/task/{taskId}
```

---

# Running Locally

## Clone Repository

```bash
git clone https://github.com/yourusername/workboard.git

cd workboard
```

## Configure Database

Update

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

jwt.secret=
jwt.expiration=
```

## Build

```bash
mvn clean package
```

## Run

```bash
java -jar target/workboard-0.0.1-SNAPSHOT.jar
```

---

# AWS Deployment

The application is designed for deployment on:

* AWS EC2 (Ubuntu Linux)
* MySQL Database
* Java 21 Runtime

Deployment workflow includes:

* EC2 instance provisioning
* Security Group configuration
* SSH access configuration
* MySQL installation and configuration
* JAR deployment using SCP
* Environment variable configuration
* Remote application execution

---

# Author

Abhirama

Spring Boot | Java | Spring Security | JWT | SQL | AWS | REST API Development
