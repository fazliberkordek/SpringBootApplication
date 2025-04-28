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
   Make sure Docker is installed on your machine.
   Build and run both the Spring Boot app and PostgreSQL database using Docker Compose:

```bash

docker-compose up --build
```
	•	Build the Docker images.
	•	Start both the Spring Boot application and PostgreSQL database in separate containers.
3.	Access the application:
   Once the containers are up and running, the Spring Boot application will be available at:

   ```bash
   http://localhost:8080
   ```
API Endpoints
1.	Get All Software Engineers
•	URL: /api/v1/software-engineers
•	Method: GET
•	Response: Returns a list of all software engineers.
2.	Get Software Engineer by ID
•	URL: /api/v1/software-engineers/{id}
•	Method: GET
•	Response: Returns a specific software engineer by ID.
3.	Add New Software Engineer
•	URL: /api/v1/software-engineers
•	Method: POST
•	Request Body:
	  {
	  "name": "Ana de Armas",
	  "age": 30,
	  "techStack": "Java, React"
	  }
•	Response: The software engineer is created and stored in the database.

4. Update Software Engineer
   •	URL: /api/v1/software-engineers/{id}
   •	Method: PUT
   •	Request Body:
   {
   "name": "John Doe",
   "techStack": "Java, Spring Boot, PostgreSQL"
   }•	Response: Updates the existing software engineer details.
	5.	Delete Software Engineer
		  •	URL: /api/v1/software-engineers/{id}
		  •	Method: DELETE
		  •	Response: Deletes the software engineer record from the database.

Docker Compose Configuration

The docker-compose.yml file configures the Spring Boot application and the PostgreSQL database.

docker-compose.yml Example:
```yaml
version: '3'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/learning_db
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: password
    depends_on:
      - db

  db:
    image: postgres:13
    environment:
      POSTGRES_USER: user
      POSTGRES_PASSWORD: password
      POSTGRES_DB: learning_db
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

Explanation:
•	app Service: Builds your Spring Boot application and connects it to the PostgreSQL database (db service). It exposes port 8080 for accessing the app and sets environment variables for the database connection.
•	db Service: Uses the official PostgreSQL Docker image. It sets up the database and exposes port 5432.
•	Volumes: The postgres_data volume ensures that the database persists data even if the container is stopped or recreated.

To start both services (the app and database), run:
```bash
docker-compose up --build	
```

ontributing

If you’d like to contribute to this project, please fork the repository, create a new branch, make your changes, and submit a pull request.

Steps to Contribute:
1.	Fork the repository.
2.	Create a new branch (git checkout -b feature-name).
3.	Make your changes.
4.	Commit the changes (git commit -am 'Added new feature').
5.	Push to the branch (git push origin feature-name).
6.	Submit a pull request.

License

This project is licensed under the MIT License - see the LIC
---

You can copy this content directly into your **README.md** file in your GitHub repository.

Let me know if you need any more adjustments! 😊
   
   