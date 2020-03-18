FROM openjdk:latest
ADD target/CarsdawRepairs-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar CarsdawRepairs-0.0.1-SNAPSHOT.jar