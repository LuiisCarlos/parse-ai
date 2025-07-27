# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy service source code
COPY services/document-service/ /app/

# Copy common lib JAR into libs folder inside the build context
COPY libs/common-lib-1.0.0.jar /tmp/common-lib-1.0.0.jar
RUN mvn install:install-file \
    -Dfile=/tmp/common-lib-1.0.0.jar \
    -DgroupId=dev.luisworks \
    -DartifactId=common-lib \
    -Dversion=1.0.0 \
    -Dpackaging=jar

RUN mvn clean package -DskipTests

# Runtime image
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8091
ENTRYPOINT ["java", "-Xms512M", "-Xmx1G", "-jar", "app.jar"]
