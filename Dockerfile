# Use Maven image to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package -DskipTests

# Use lightweight JDK image to run the app
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
