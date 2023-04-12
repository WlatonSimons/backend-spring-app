FROM openjdk:19-alpine
# Set the working directory
WORKDIR /app
# Copy the Gradle files
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

# Copy the project files
COPY . /app
# Download and install Gradle
# Build the app

RUN chmod +x ./gradlew && chmod +x ./gradlew build
# Set the startup command
CMD ["java", "-jar", "build/libs/morgage.jar"]
