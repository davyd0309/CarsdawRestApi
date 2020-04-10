FROM adoptopenjdk/openjdk11:alpine-jre
COPY build/libs/*.jar CarsdawRestApi-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/CarsdawRestApi-0.0.1-SNAPSHOT.jar"]