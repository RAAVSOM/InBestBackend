FROM openjdk:11-jre-slim
COPY build/libs/InBestBackend-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "build/libs/InBestBackend-0.0.1-SNAPSHOT.jar"]


