# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy service source code
COPY services/ocr-service/ /app/

# Copy common lib JAR into libs folder inside the build context
COPY libs/common-lib-1.0.0.jar libs/common-lib-1.0.0.jar

RUN apt-get update && apt-get install -y \
    tesseract-ocr \
    tesseract-ocr-eng \
    tesseract-ocr-spa \
    && rm -rf /var/lib/apt/lists/*

RUN mvn clean package -Pdocker-build -DskipTests

# Runtime image
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-Xms512M", "-Xmx1G", "-jar", "app.jar"]
