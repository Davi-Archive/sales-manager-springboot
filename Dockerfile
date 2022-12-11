FROM openjdk:17
WORKDIR /app
COPY ./target/*.jar ./application.jar
EXPOSE 8080

ENTRYPOINT java -jar application.jar

#docker build  -t davi38/sales-springdocker .
