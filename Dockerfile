FROM openjdk:17-jdk
COPY build/libs/InBestBackend-0.0.1-SNAPSHOT.jar /app/InBestBackend.jar
CMD ["java", "-jar", "/app/InBestBackend.jar"]


