# WorkBoard - Task Management REST API

## Overview

WorkBoard is a Task Management REST API built using Spring Boot. It allows users to manage projects, tasks, and comments with JWT-based authentication and role-based authorization.

The application supports multiple user roles and provides secure endpoints for project and task management.

---

## Features

### Authentication & Authorization

* User Registration
* User Login
* JWT Token Generation
* Spring Security Integration
* Role-Based Access Control

### Project Management

* Create Projects
* View All Projects
* View Project By ID

### Task Management

* Create Tasks
* Update Tasks
* Delete Tasks
* Update Task Status
* Get Tasks By Status
* Get Tasks By Priority
* Get Tasks By User
* Get Tasks By Project

### Comment Management

* Add Comments To Tasks
* View Task Comments

---

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* MySQL 8

### Authentication

* JWT (JSON Web Token)

### Build Tool

* Maven

### Deployment

* AWS EC2 (Ubuntu Linux)

---

## Project Structure

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
    │       │   ├── ProjectService
    │       │   ├── TaskService
    │       │   └── CommentService
    │       │
    │       ├── serviceimpl
    │       │   ├── AuthServiceImpl
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

## Database Design

### Users

* userId
* name
* email
* password
* role

### Projects

* id
* name
* description
* createdBy

### Tasks

* id
* title
* description
* priority
* status
* dueDate
* assignedUser
* project

### Comments

* id
* content
* task
* user

---

## Entity Relationships

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

## Security

### Roles

```text
ADMIN
EMPLOYEE
USER
```

### Access Rules

```text
/api/auth/**       -> Public

/api/projects/**   -> ADMIN

/api/tasks/**      -> ADMIN, EMPLOYEE, USER

/api/comments/**   -> Authenticated Users
```

JWT authentication is used to secure API endpoints.

---

## API Endpoints

### Authentication

```http
POST /api/auth/register
POST /api/auth/login
```

### Projects

```http
POST /api/projects
GET  /api/projects
GET  /api/projects/{id}
```

### Tasks

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

### Comments

```http
POST /api/comments
GET  /api/comments/task/{taskId}
```

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/yourusername/workboard.git
cd workboard
```

### Configure Database

Update:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
jwt.secret=
```

### Build

```bash
mvn clean package
```

### Run

```bash
java -jar target/workboard-0.0.1-SNAPSHOT.jar
```

---

## AWS Deployment

The application was deployed on:

* AWS EC2 (Ubuntu Linux)
* MySQL Database
* Java 21 Runtime

Deployment activities included:

* EC2 instance provisioning
* Security Group configuration
* SSH access configuration
* MySQL installation and configuration
* JAR deployment using SCP
* Remote application execution using Java

---

## Future Improvements

* Docker Containerization
* CI/CD Pipeline using GitHub Actions
* API Documentation
* Unit & Integration Testing
* Redis Caching
* Monitoring & Logging

---

## Author

Abhirama

Spring Boot | Java | SQL | AWS | REST API Development
