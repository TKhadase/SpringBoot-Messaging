package com.tushar.jmsReceivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQ_Queue_Receiver  {

	@JmsListener(destination = "MQ_QueueTest")
	public void listenQueue(String msg) throws Exception {
		System.out.println("ActiveMQ_Queue_Receiver-Messgae:: "+msg);
	}

}
