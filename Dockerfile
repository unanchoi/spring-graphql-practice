FROM amazoncorretto:21

WORKDIR /app

COPY build/libs/graphql-0.0.1-SNAPSHOT.jar /app/myapp.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]