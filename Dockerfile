# Step 1: Build Stage
# Use the official Maven image with OpenJDK 17
FROM maven:3.9-eclipse-temurin AS build

# Set the working directory inside the container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application and create the jar file
RUN mvn clean package -DskipTests

# Step 2: Run Stage
# Use OpenJDK 17 image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/learning-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080, the default port for Spring Boot
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]