package com.tushar.runners;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class  ActiveMQ_Topic_Publisher implements CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	int i=1;
	
	@Override
	public void run(String... args) throws Exception {
		for(i=1;i<=20;i++) {
		System.out.println("ActiveMQ_Topic_Publisher. sending msg"+i);
		
		jmsTemplate.send("AMQ_Topic_Test", ses->{
			return	ses.createTextMessage(i+"-Project sending message data: "+new Date()); 
		});

		System.out.println("ActiveMQ_Topic_Publisher. msg sent "+i);
		Thread.sleep(15000);
		}//for
	}//run

}//runner
