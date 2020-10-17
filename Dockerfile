FROM openjdk:8-jre-alpine
ADD /src/main/resources/application.properties //
ADD /src/main/resources/application.yml //
ADD /src/main/resources/db-config.properties //
ADD /src/main/resources/db-config-k8s.properties //

ENTRYPOINT ["java", "-jar", "./demo.jar"]
