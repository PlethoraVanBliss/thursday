# thursday
Thursday Khula DEV hackathon 

#Build Image
docker build -t devtestkhula/v1 .

#Execute Image
docker run -p 8111:8111 -it devtestkhula/v1  java -jar /usr/src/testdevapp/ayo-dev-test-spring-boot-0.1.0.jar


#Services available are HTTP POST Method with Header Content-Type:application/json and body example: 100

http://localhost:8111/ayo-dev-test/fahrenheittotocelcius
http://localhost:8111/ayo-dev-test/kmtomile
http://localhost:8111/ayo-dev-test/metertoyard

