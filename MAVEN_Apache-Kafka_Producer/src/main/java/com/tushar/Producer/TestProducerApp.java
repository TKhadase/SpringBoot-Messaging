package com.tushar.Producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class TestProducerApp {
	public static void main(String[] args) {
		System.out.println("Starting to send MSG");
		String msg = "hello kafka world messaging ";
		String topicName = "Topic-test1";
		
		try {
			// connection props
			Properties kafkaProps = new Properties();
			kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
			kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

			// establish connection
			KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(kafkaProps);

			// create producer
			ProducerRecord<String, String> producerRecord = null;
			for (int i = 0; i < 100; i++) {
				msg = msg + ":" + i;
				producerRecord = new ProducerRecord<String, String>(topicName, msg);
				kafkaProducer.send(producerRecord);

				// send msg
				kafkaProducer.flush();
				System.out.println("MSG: "+msg+", sent on TOPIC:" + topicName);
				Thread.sleep(2000);
				producerRecord = null;
			}
			// close connection
			kafkaProducer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
