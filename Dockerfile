FROM maven:3.8.5-openjdk-17 as build
RUN mkdir /app
WORKDIR /app
ADD . /app
RUN mvn package

FROM eclipse-temurin:17-jdk
RUN mkdir /app
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java","-jar","app.jar"]



