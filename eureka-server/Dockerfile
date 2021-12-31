FROM openjdk:8-jdk-alpine

RUN mkdir -p /app

ADD /target/Eurekaserver-1.jar /app/app.jar

EXPOSE 8761

ENTRYPOINT [ "/usr/bin/java", "-jar" ,"/app/app.jar"]