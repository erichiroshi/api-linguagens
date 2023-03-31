FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD target/linguagens-api-0.0.1-SNAPSHOT.jar linguagensapi.jar
ENTRYPOINT ["java", "-jar", "linguagensapi.jar"]