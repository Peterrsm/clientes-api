FROM openjdk

WORKDIR /app

COPY target/clientes-api-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT {"java", "-jar", "clientes-api.jar"}