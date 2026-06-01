# Stage 1: Build runtime image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the generated jar file
COPY target/*.jar app.jar

# Expose port (Render will override via PORT env)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]