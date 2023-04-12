# Use a specific version of the OpenJDK image
FROM openjdk:19-alpine

# Set the working directory
WORKDIR /app

# Copy the Gradle files
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

# Download and install Gradle
RUN ./gradlew --version

# Copy the project files
COPY . /app

# Build the project
RUN ./gradlew build

# Set the user to run the Java process
USER appuser

# Expose the port used by the Java application
EXPOSE 8080

# Set the startup command
CMD ["java", "-jar", "build/libs/morgage.jar"]