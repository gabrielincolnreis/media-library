# User and Media Rating Application

## Overview

This project is a simple application that allows users to create and rate media items. The application is built using Spring Boot, Java 17, and MySQL, and is documented with Swagger. The development environment is set up using Docker to manage the MySQL database.

## Features

- User management: Create and manage users.
- Media management: Create and manage media items.
- Rating system: Users can rate media items.
- Swagger documentation for API endpoints.

## Prerequisites

- Java 17
- Docker
- IntelliJ IDEA
- Maven

## Getting Started

### 1. Clone the Repository

```sh
git clone https://github.com/gabrielincolnreis/media-library.git
git checkout master
cd user-media-rating
```

### 2. Set Up MySQL with Docker

Ensure you have Docker installed. Then, run the following command to start a MySQL container:

```sh
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=mediadb -p 3307:3306 -d mysql:latest
```

### 3. Configure the Application

Update the `application.properties` file located in `src/main/resources` with your database configurations if necessary:

```properties
server.port=8005

spring.datasource.url=jdbc:mysql://localhost:3307/mediadb?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=secret

## Hibernate properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false

security.jwt.secret-key=3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b
# 24h in millisecond
security.jwt.expiration-time=86400000
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui-custom.html
springdoc.swagger-ui.operationsSorter=method
```

### 4. Build and Run the Application

You can build and run the application using Maven. In IntelliJ IDEA, you can simply run the application by clicking the Run button. Alternatively, use the following command in the terminal:

```sh
./mvnw spring-boot:run
```

### 5. Access the Application

Once the application is running, you can access the Swagger documentation to explore the API endpoints:

```
http://localhost:8080/swagger-ui.html
```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.


## Contact

If you have any questions or need further assistance, feel free to contact Gabriel Lincoln gabrielincoln17@gmail.com.
