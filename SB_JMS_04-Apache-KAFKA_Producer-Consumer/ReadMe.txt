Download Kafka setup and unzip it.
In my case <path> is where kafka is unzip. Ex: C:\kafka_2.13-3.1.0

To send/Receive messages::
step 1) Start zookeeper-server using below command from kafka setup:
<path>\kafka_2.13-3.1.0\bin\windows> zookeeper-server-start  <path>\kafka_2.13-3.1.0\config\zookeeper.properties

step 2) Start kafka-server using below command from kafka setup:
<path>\kafka_2.13-3.1.0\bin\windows> kafka-server-start <path>\kafka_2.13-3.1.0\config\server.properties

Step 3) Run SB_JMS_04-Apache-KAFKA_Producer-Consumer as JAVA/SpringBoot Application.

Step 4) Open browser and call below url's to send message
http://localhost:9090/kafkaApp/send?data=Tushar
http://localhost:9090/kafkaApp/send?data=Khadse

Step 5) call below url's to check received messages
http://localhost:9090/kafkaApp/readMessages