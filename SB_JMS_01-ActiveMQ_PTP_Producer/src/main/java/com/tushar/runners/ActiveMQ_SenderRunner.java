package com.tushar.runners;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQ_SenderRunner implements CommandLineRunner {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	int i=0;
	
	@Override
	public void run(String... args) throws Exception {
	
		for( i=0; i<10;i++) {
		System.out.println("ActiveMQ_SenderRunner.run() sending messge#"+i);
		/*jmsTemplate.send("MQ_QueueTest", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage("Project sending message data:"+new Date()); 
				return msg;
			}
		});*/
		
		jmsTemplate.send("MQ_QueueTest", ses->{
			return	ses.createTextMessage(i+"-Project sending message data:"+new Date()); 
		});
		
		System.out.println("ActiveMQ_SenderRunner.run() messgae sent#"+i);
		Thread.sleep(20000);
		}//for
	}//run

}//runner