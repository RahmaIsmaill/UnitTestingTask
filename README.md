# Product Admin Panel (Spring MVC + Hibernate)

[![Java](https://img.shields.io/badge/Java-17-007396?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring MVC](https://img.shields.io/badge/Spring_MVC-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-framework)
[![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white)](https://hibernate.org/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/)


A fully functional Product Admin Panel built with Spring MVC, Hibernate, and MySQL, featuring full CRUD operations and clean layered architecture.
Includes complete Unit Tests for services and repositories.

---
## Features

- Full CRUD operations: Create, Read, Update, and Delete products.
- One-to-One relationship between Product and ProductDetails.
- Clean MVC architecture for organized code structure.
- Hibernate and JPA annotations for ORM and entity mapping.
- MySQL relational mapping with proper foreign keys.
- Transactional services ensuring data consistency.
- Complete JUnit 5  test coverage for services and repositories.

---

## 📌 Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java 17** | Core backend language |
| **Spring MVC** | REST controllers, routing, and request handling |
| **Spring Core / DI** | Dependency injection & application configuration |
| **Hibernate / JPA** | ORM, entity mapping, and database operations |
| **MySQL** | Relational database for product + product details |
| **Swagger** | API documentation and endpoint testing |
| **Lombok** | Reduce boilerplate (getters, setters, constructors) |
| **Maven** | Dependency and build management |
| **JUnit 5** | Unit testing for services and controllers |
| **Tomcat** | Servlet container for running the application |

---
## Database Schema

```mermaid
erDiagram
    PRODUCT {
        int id PK "Primary Key"
        string name "Product name (e.g., Coca Cola)"
    }
    PRODUCT_DETAILS {
        int id PK "Primary Key"
        string name "Variant (e.g., 330ml Can)"
        date expiration_date "Expiration Date"
        string manufacturer "Manufacturer"
        double price "Price"
        int available "Stock Quantity"
        int product_id FK "References Product(id)"
    }

    PRODUCT ||--|| PRODUCT_DETAILS : "has (One-to-One)"
```
---
## 🔗 Current Endpoints (REST API Mode)

| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/api/v1/products` | Get all products |
| **GET** | `/api/v1/product/{id}` | Get a product by its ID |
| **GET** | `/api/v1/productDetails/{id}` | Get product details by ID |
| **GET** | `/api/v1/productDetails/name/{name}` | Get product details by name |
| **POST** | `/api/v1/productDetails` | Create new product details |
| **PUT** | `/api/v1/productDetails/{id}` | Update product details by ID |
| **DELETE** | `/api/v1/productDetails/{id}` | Delete product details |
---
### API Documentation

The project includes Swagger UI for exploring and testing the REST API endpoints:

![Swagger UI](swagger.png)

