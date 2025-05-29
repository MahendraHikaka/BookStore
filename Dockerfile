FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/bookstore-3.4.2.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
