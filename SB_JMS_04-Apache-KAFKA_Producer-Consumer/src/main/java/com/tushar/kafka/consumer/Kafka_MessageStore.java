package com.tushar.kafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Kafka_MessageStore {

	List<String> consumedMessagesList = new ArrayList();
	
	public void addMessage(String msg) {
		consumedMessagesList.add(msg);
	}
	
	public String getAllMessage() {
		return consumedMessagesList.toString();
	}
	
}
