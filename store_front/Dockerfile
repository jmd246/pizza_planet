# Build stage

From maven:3.9-eclipse-temurin-21 as build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package

# Runtime stage

From eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
