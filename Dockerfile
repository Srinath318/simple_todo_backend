# Stage 1: Build the app
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (caching layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy all source code
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy jar from the build stage
COPY --from=build /app/target/ToDoApp-0.0.1-SNAPSHOT.jar app.jar

# Expose default port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
