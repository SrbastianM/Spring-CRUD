# Spring-CRUD

This api, is thinking to use in your local machine so if you dont have instaled Java or MySql take a short breake and go to install both

### Quick example application.properties:

```
spring.application.name=crud
spring.datasource.url=jdbc:mysql://localhost:3306/your_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=(YOUR_USER)
spring.datasource.password=(YOUR_PASS)

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```
---

## This Enpoinst are the create, delete, update, and read of table "employer"

| Method  | EndPoint | Description |
|-------- |----------|-------------|
|  GET |  "/api/v1/employers" |  getAll: Returns all the records in the DB| 
|  GET | "/api/v1/employers/{employerId}"  | getEmployer: Returns the employer matching the id in the DB |
|  POST | "/api/v1/employers/{employerId}"  | saveEmployer: Create a employer record in the DB|
|  PUT | "/api/v1/employers/{employerId}"  | updateEmployer: Update a employer record in the DB|
|  DELETE  | /api/v1/employers/{employerId}"  | deleteEmployer: Delete a employer record in the DB|

## The use of the next enpoints:
!Remember: This app runs in the host: http://localhost:8080
- Quick show returns and conditions to use the endpoints:


