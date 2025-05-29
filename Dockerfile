# Use Maven image to build
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use lightweight Java image for running
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/bookstore-3.4.2.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
