# Stage 1: Build the app
FROM maven:3.9.2-eclipse-temurin-21-jdk AS build

WORKDIR /app

# Copy only pom.xml first for caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Build the jar, skip tests to avoid Railway test failures
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/ToDoApp-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Railway uses this by default)
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "app.jar"]
