FROM maven:3.9.7-amazoncorretto-21-debian-bookworm AS builder

WORKDIR /usr/src/logs
COPY pom.xml .
RUN mvn -B dependency:go-offline

COPY . .
RUN mvn package -DskipTests

FROM amazoncorretto:21.0.3

WORKDIR /app
COPY --from=builder /usr/src/logs/target/logs-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "/app/logs-0.0.1-SNAPSHOT.jar"]
