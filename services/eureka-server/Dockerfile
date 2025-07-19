# Build the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY services/eureka-server/ /app/
RUN mvn clean package -DskipTests

# Execute the application
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-Xms512M", "-Xmx1G", "-jar", "app.jar"]
