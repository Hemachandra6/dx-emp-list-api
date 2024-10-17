# Step 1: Build the Spring Boot application using Gradle 8.10.2 and JDK 21
FROM gradle:8.10.2-jdk21 AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle settings.gradle ./

# Copy the source code
COPY src ./src

# Build the application (this will create a .jar file in build/libs)
# Skipping tests to avoid build failure due to DB connection issues
RUN gradle build --no-daemon -x test

# Step 2: Create a minimal runtime image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/dx-emp-list-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the Spring Boot app will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
