# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build output JAR file into the container
COPY build/libs/blogapp-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (or your configured port)
EXPOSE 8855

# Run the application
CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]

