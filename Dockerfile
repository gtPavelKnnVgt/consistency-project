FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/demography-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker

ENTRYPOINT ["java", "-jar", "app.jar"]
