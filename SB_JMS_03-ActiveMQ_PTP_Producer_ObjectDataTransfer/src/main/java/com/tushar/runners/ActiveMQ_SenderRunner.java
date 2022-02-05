package com.tushar.runners;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.tushar.model.Account;

@Component
public class ActiveMQ_SenderRunner implements CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	Account acc =null;
	int i=0;
	
	@Override
	public void run(String... args) throws Exception {
	
		for( i=0; i<10;i++) {
		System.out.println("ActiveMQ_SenderRunner.run() sending messge#"+i);
		
		acc = new Account(i, "Tushar",  new Random().nextInt(99999));
		jmsTemplate.convertAndSend("MQ_QueueTest",acc);
		
		System.out.println("ActiveMQ_SenderRunner.run() messgae sent#"+i);
		Thread.sleep(20000);
		}//for
	}//run

}//runner