FROM openjdk:17
EXPOSE 8080
ADD target/task-management.jar task-management.jar
ENTRYPOINT [ "java", "-jar", "/task-management.jar" ]

#then go to docker workbench portal in yout machine 
# then go to prokect home dir, (.) is root folder
# then write command - docker build -t spring-boot-pick.jar .
#after image created run the app
#docker run -p 9090:8080 spring-boot-pick.jar
#docker tag docker-demo dockertrainingbykul/dockerdemo

#pull image ffrom the docker and upload it to the kubernate google
  	#first remove images from the local using below command
		# docker rmi docker-demo [repo-name]
	# and then pull and run image from the docker hub
		# docker run -p 8080:8080 [repo-name]
	# Go to the google console and find kuberante-engine -> create clustur -> [provide clustor name keep other things as default]
	#after clustur is created then click on 3 dots and then upload yaml file which has created for kubernates configuration.
	#create container for that image by using below commmand
		# kubectl apply -f [yaml file name which has been uploaded]
	
	
