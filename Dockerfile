# Use a base image with JDK and Maven pre-installed
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy the Maven project file to the working directory
COPY pom.xml .

# Download dependencies. This step will be cached if the pom.xml file hasn't changed
RUN mvn dependency:go-offline

# Copy the rest of the project files and directories to the working directory
COPY src ./src

# Build the project with Maven
RUN mvn clean package -DskipTests --quiet

# Use a lightweight base image with JRE
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage to the working directory in the final container
COPY --from=build /app/target/*.jar ./app.jar

# Specify the command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]