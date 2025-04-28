# Use a Java 21 base image
FROM openjdk:21-jdk-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and POM file
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Build dependencies without running tests
RUN ./mvnw dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Use a Java 21 base image for the runtime (final image)
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/learning-0.0.1-SNAPSHOT.jar /app/learning.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/learning.jar"]