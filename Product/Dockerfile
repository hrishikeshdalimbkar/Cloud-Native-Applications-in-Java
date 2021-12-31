
#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

#
# Package stage
#
FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/Product-1.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java","-jar","/app/app.jar","--spring.profiles.active=docker","--spring.profiles.active=mysql"]