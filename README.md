# **Spring Boot Learning Project**

## **Description**
This project is a **Spring Boot** based backend application that demonstrates the use of **Spring Boot**, **PostgreSQL**, and **Docker**. The application allows the management of software engineers, including functionalities to **add**, **update**, **delete**, and **retrieve** information about software engineers. It integrates **AI-based learning path recommendations** based on the skills (tech stack) of the software engineers.

## **Features**
- **Add** a new software engineer with tech stack and AI-generated learning path recommendations.
- **Update** details of an existing software engineer (e.g., name, age, tech stack).
- **Delete** software engineer records.
- **Retrieve** a list of all software engineers or fetch a specific engineer by ID.
- AI integration for generating a personalized learning path for software engineers based on their tech stack using **OpenAI** API.
- **Dockerized** for easy deployment and testing.

## **Technologies Used**
- **Spring Boot**: The main framework for developing the backend.
- **Spring Data JPA**: For data access and interacting with the PostgreSQL database.
- **PostgreSQL**: Used as the relational database for storing software engineer data.
- **Docker**: For containerizing the application and ensuring easy deployment.
- **OpenAI API**: For generating AI-powered learning paths based on the software engineer's tech stack.
- **Maven**: The build automation tool to manage dependencies and build the application.

## **Prerequisites**
- Docker
- Maven
- JDK 21 or higher (for development and building)

## **Installation**

### **Using Docker (Recommended)**

1. **Clone the repository**:
   Clone the project to your local machine:

   ```bash
   git clone https://github.com/yourusername/learning.git
   cd learning 
    ```
	2.	Build and run the application with Docker:
	•	Make sure Docker is installed on your machine.
	•	Build and run both the Spring Boot app and PostgreSQL database using Docker Compose:

```bash
docker-compose up --build
```
3.	Access the application:
Once the containers are up and running, the Spring Boot application will be available at:
```bash 
http://localhost:8080
```




   
