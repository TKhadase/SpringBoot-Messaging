package com.tushar.jmsReceivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQ_Topic_Subsriber {

	@JmsListener(destination = "AMQ_Topic_Test")
	public void listenQueue(String msg) throws Exception {
		System.out.println("ActiveMQ_Topic_Subsriber-Messgae:: "+msg);
	}
	
}
