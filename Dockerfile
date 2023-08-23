FROM openjdk:17
ENV IMG_PATH="/img"
RUN mkdir -p /img
ADD ./target/exchange-rate-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]