Download Kafka setup and unzip it.
In my case <path> is where kafka is unzip. Ex: C:\kafka_2.13-3.1.0

To run consumer:::
step 1) Start zookeeper-server using below command from kafka setup:
<path>\kafka_2.13-3.1.0\bin\windows> zookeeper-server-start  <path>\kafka_2.13-3.1.0\config\zookeeper.properties

step 2) Start kafka-server using below command from kafka setup:
<path>\kafka_2.13-3.1.0\bin\windows> kafka-server-start <path>\kafka_2.13-3.1.0\config\server.properties

Step 3) create topic if not available:
<path>\kafka_2.13-3.1.0\bin\windows> kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic Topic-test1

Step 4) Run MAVEN_Apache-Kafka_Consumer as JAVA Application.

Step 5) Run MAVEN_Apache-Kafka_Producer as JAVA Application.