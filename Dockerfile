FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml and download dependencies (layer caching)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

# Copy the rest of the project and build it
COPY src src
RUN ./mvnw clean package -DskipTests

# Step 2: Use a lightweight JDK image to run the app
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built jar from the previous image
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]