package com.tushar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SbJms04ApacheKafkaProducerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbJms04ApacheKafkaProducerConsumerApplication.class, args);
	}

}
