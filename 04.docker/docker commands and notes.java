in28min GUTHUB LINK - MICROSERVICES AND DOCKER
https://github.com/in28minutes/spring-microservices-v2/blob/main/03.microservices/01-step-by-step-changes/microservices-v2-1.md#docker-section---connect-microservices-with-zipkin


load balancing
blance load between multiple instances of a micoservice


DOCKER:
Docker provides the concept of dockerization. Means if you have to run an application in the system so you need to multiple configuration to run the application.
Like jdk, apache, mysql and so on. And all this process you have to do manually, and we are human and we can make mistake and it takes time.
So to overcome this problem docker comes into the picture. It says provide whatever you want in a image file and once you run the image in any system it will do all configurations
automatically.

Docker Image - where we have all the configuration related properties. Image is static
Docker container - Once you run the image it becomes container. Container is dynamic
Docker Engine - Is used to host the container
Docker compose - where you can run your multiples images with a single command. 



-------DOCKER-------

 creating image from POM -
  <configuration>
					<image>
						<name>in28min/mmv2-${project.artifactId}:${project.version}</name>
					</image>
					<pullPolicy>IF_NOT_PRESENT</pullPolicy>
				</configuration>

				
 creating image from Dockerfile
  FROM openjdk:16
  ARG JAR_FILE=target/*.jar
  COPY ${JAR_FILE} app.jar
  ENTRYPOINT ["java","-jar","/app.jar"]
 
-------DOCKER-------

Commands:
TO CREATE DOCKER IMAGE(Dockerfile) - docker build -t in28min/spring-configuration-server . 
TO CREATE DOCKER IMAGE(POM Configuration) - ./mvnw spring-boot:build-image -DskipTests
RUN DOCKER IMAGE - docker run -p 8888:8888 in28min/spring-configuration-server:latest
RUN DOCKER COMPOSE - docker-compose up
SEE ALL THE IMAGES - docker image ls
SEE ALL THE CONTAINER - docker container ls
DELETE IMAGE - docker image rmi