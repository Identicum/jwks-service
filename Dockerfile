FROM maven:3-openjdk-11 as builder
WORKDIR /app
COPY . .
RUN mvn install -DskipTests

FROM openjdk:11-jre-slim
LABEL maintainer="Ezequiel Sandoval <esandoval@roundservices.biz>"

WORKDIR /app
COPY --from=builder /app/target/*.jar ./app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]