# Step 1: Use Maven with JDK 21 to build the project
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copy all necessary files
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY src src

# Build the application (skip tests if you want faster builds)
RUN ./mvnw clean package -DskipTests

# Step 2: Use JDK 21 lightweight runtime to run the app
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built JAR from the previous build step
COPY --from=build /app/target/*.jar app.jar

# Expose your Spring Boot port (default is 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
