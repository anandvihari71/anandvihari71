FROM openjdk:17-jdk-slim
COPY target/data-processing-*.jar /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/data-processing-0.0.1-SNAPSHOT.jar"]