FROM openjdk:latest
COPY build/libs/*.jar CarsdawRestApi-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/CarsdawRestApi-0.0.1-SNAPSHOT.jar"]