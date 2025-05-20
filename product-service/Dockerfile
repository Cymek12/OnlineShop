FROM openjdk:21-jdk-slim
WORKDIR /app
COPY /adapters/target/adapters-0.0.1-SNAPSHOT.jar product-service.jar
ENTRYPOINT ["java", "-jar", "product-service.jar"]