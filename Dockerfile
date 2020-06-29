# Build-time image that is discarded
FROM openjdk:11-jdk-slim AS java-build
COPY . .
RUN ./mvnw package

# Run-time image that makes the final image
FROM openjdk:11-jre-slim
COPY --from=java-build /target/sb-mysql-0.0.1-SNAPSHOT.jar app/app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app/app.jar"]