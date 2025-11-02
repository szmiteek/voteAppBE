# VoteApp Backend

## Backend Application

This is the backend part of the VoteApp application built with Spring Boot.  
It provides the API for the frontend application.  
The project uses an **H2 in-memory database** by default.

---

## Requirements

- Java JDK 17 or higher 
- Maven 3.8 or higher 

> Make sure Java and Maven are installed. You can check the versions with:

```bash
java -version
mvn -version
```
---

## Installation & Running the Application

1. Clone the repository:

```bash
git clone https://github.com/szmiteek/voteAppBE.git
cd voteAppBE
```

2. Build the project using Maven:

```bash
mvn clean install
```

3. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

4. The backend API will be available at:

```
http://localhost:8080/
```

---

## Notes

- The project uses an **H2 in-memory database** by default. No external DB setup is needed for development.  
- You can test the API endpoints using Postman or by connecting the frontend application.  
- For any changes in dependencies, rebuild the project using `mvn clean install`.
