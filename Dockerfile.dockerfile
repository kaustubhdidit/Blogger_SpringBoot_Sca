# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the build output JAR file into the container
COPY build/libs/blogapp.jar app.jar

# Expose port 8080 (or your configured port)
EXPOSE 8855

# Run the application
CMD ["java", "-jar", "app.jar"]
