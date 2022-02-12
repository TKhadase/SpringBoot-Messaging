package com.tushar.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Kafka_Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTempl;
	
	@Value("${app.kafka-topic.name}")
	private String topic;
	
	public String publishMessageString(String msg) {
		System.out.println("Kafka_Producer.publishMessageString()");
		kafkaTempl.send(topic, msg);
		return "Topic published";
	}
	
	
}
