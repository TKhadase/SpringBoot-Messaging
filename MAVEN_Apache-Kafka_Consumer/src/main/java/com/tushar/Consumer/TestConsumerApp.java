package com.tushar.Consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class TestConsumerApp 
{
    public static void main( String[] args )
    {
    	System.out.println("Starting TestConsumerApp to receive MSG");
    	String topicName = "Topic-test1";
    	//connection props
    	Properties kafkaProps = new Properties();
    	kafkaProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	kafkaProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());    	
    	kafkaProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());    	
    	kafkaProps.put(ConsumerConfig.GROUP_ID_CONFIG,  "Topic-test1_GRP1");
    			
    	//establish connection for consumption & subscribe to topic
    	KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(kafkaProps);
    	kafkaConsumer.subscribe(Arrays.asList(topicName));
    	while(true) {
    	//check for messages at fixed interval
    	ConsumerRecords<String ,String > consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
    	
    	//read messages
    	for(ConsumerRecord<String ,String > Record : consumerRecords){
    		System.out.println("Received MSG:: "+Record.value());
    	}
    	}//while
    }
}
