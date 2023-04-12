FROM openjdk:19-alpine
# Set the working directory
WORKDIR /app
# Copy the Gradle files
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
# Download and install Gradle
RUN chmod +x ./gradlew --version
# Copy the project files
COPY . /app
# Build the

RUN chmod +x ./gradlew build
# Set the startup command
CMD ["java", "-jar", "build/libs/morgage.jar"]
