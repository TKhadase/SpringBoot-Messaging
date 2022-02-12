package com.tushar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.kafka.consumer.Kafka_MessageStore;
import com.tushar.kafka.producer.Kafka_Producer;

@RestController
public class KafkaMessagingController {

	@Autowired
	private Kafka_Producer producer;
	
	@Autowired
	private Kafka_MessageStore MessageStore;
	
	@GetMapping("/send")
	public String sendMessgae(@RequestParam("data") String msg) {
		System.out.println("KafkaMessagingController.sendMessgae(): "+msg);
		return ""+producer.publishMessageString(msg);
	}
	
	@GetMapping("/readMessages")
	public String getAllReceivedMessage() {
		System.out.println("KafkaMessagingController.getAllReceivedMessage()");
		return ""+MessageStore.getAllMessage();
	}
	
}
