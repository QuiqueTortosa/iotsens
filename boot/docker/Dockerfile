FROM maven:3.8.1-openjdk-17

COPY ../target/boot-0.0.1.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]