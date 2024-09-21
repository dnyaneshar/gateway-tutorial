FROM openjdk:17
EXPOSE 8080
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT [ "java", "-jar", "/spring-boot-docker.jar" ]

#then go to docker workbench portal in yout machine 
# then go to prokect home dir, (.) is root folder
# then write command - docker build -t spring-boot-docker.jar .
#after image created run the app
#docker run -p 9090:8080 spring-boot-docker.jar
