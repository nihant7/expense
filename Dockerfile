FROM openjdk:8
ADD target/expense-0.0.1-SNAPSHOT.jar expense-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","expense-0.0.1-SNAPSHOT.jar"]