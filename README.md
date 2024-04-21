# Qeema Task Application: Order Management System

**Introduction**
This Order Management System is designed as part of a Java task for Qeema, showcasing a RESTful API that handles order fulfillment processes asynchronously. The system integrates CRUD functionalities for managing orders, each containing one or more unique products. The backend is implemented using Spring Boot, with an H2 in-memory database to persist data.

**Uesd Technologies:**

Java JDK 17
Maven 3.6+ (for building the application)
Docker (optional for containerization)

**Prerequisites:**
- Java 8+
- mvn
- Docker(Optional)
- 
 **Functional Requirements:**

  Each order can contain multiple products.
  Each product must have a price greater than zero and a quantity of at least one.
  Products in an order are unique.
  Post-order creation, the system should begin fulfillment asynchronously.
  
**Non-Functional Requirements:**

  Comprehensive unit and integration tests.
  Application of n-tier architecture and design patterns where applicable.
  Usage of OOP principles for domain modeling.
  Clean, concise, and well-documented code.

**How To Run:**
1. Building the Backend: 
	- Navigate to the root directory where pom.xml is located.
	- then run 'mvn clean package'

2. Running with Docker
   - Navigate to the root directory where Dockerfile is located.
   - then run 'docker build -t qeema-order-management'
   - after building rung 'docker run -d -p 8080:8080 --name qeema-order-app qeema-order-management'

