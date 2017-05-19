FROM java:8
COPY ./target /usr/src/testdevapp
WORKDIR /usr/src/testdevapp
#RUN java -jar /usr/src/testdevapp/ayo-dev-test-spring-boot-0.1.0.jar
EXPOSE 8111