# Use an official Maven image to build the app
FROM maven:3.9.2-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use an OpenJDK image to run the app
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/ToDoApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
