FROM jdk:11.0.3
COPY /target/*.jar /usr/app/br-agendamento-servicos-java.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${profile}","-Duser.timezone=America/Sao_Paulo", "-jar", "/usr/app/br-agendamento-servicos-java.jar"]
