# Use official OpenJDK base image
#FROM eclipse-temurin:17-jdk
FROM openjdk:17-jdk-slim

#FROM openjdk:17-jdk-alpine

# Add metadata
LABEL maintainer="harinder.rana1998@gmail.com"

# Set working directory
WORKDIR /app

VOLUME /tmp

# Jar file name may vary
#ARG JAR_FILE=target/*.jar

# Copy the JAR file into the container
COPY target/ecommerce-backend22-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run your app
ENTRYPOINT ["java", "-jar", "app.jar"]