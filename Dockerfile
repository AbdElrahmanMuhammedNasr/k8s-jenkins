FROM openjdk:17-alpine
EXPOSE 8080
#ARG JAR_FILE
ADD target/springBootK8s-0.0.1-SNAPSHOT.jar springBootK8s-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springBootK8s-0.0.1-SNAPSHOT.jar"]
