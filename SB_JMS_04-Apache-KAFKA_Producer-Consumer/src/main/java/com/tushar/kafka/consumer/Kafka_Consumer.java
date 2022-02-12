package com.tushar.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Kafka_Consumer {
	
	@Autowired
	private Kafka_MessageStore msgStore;
	
	@KafkaListener(topics = "${app.kafka-topic.name}", groupId = "GRP1")
	public void readMessage(String msg) {
		System.out.println("Kafka_Consumer.readMessage()");
		msgStore.addMessage(msg);
	}

}
