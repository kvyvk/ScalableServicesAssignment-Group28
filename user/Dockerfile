# Use a base image with Java and Maven installed
FROM adoptopenjdk:11-jre-hotspot AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project file and download dependencies
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy the application source code
COPY src ./src

# Package the application
RUN mvn -B package -DskipTests

# Use a smaller base image for runtime
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file from the builder stage
COPY --from=builder /app/target/user-0.0.1-SNAPSHOT.jar .

# Set the entrypoint to run the JAR file
ENTRYPOINT ["java", "-jar", "user-service.jar"]
