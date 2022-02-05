package com.tushar.jmsReceivers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.tushar.model.Account;

@Component
public class ActiveMQ_Queue_Receiver  {

	@JmsListener(destination = "MQ_QueueTest")
	public void listenQueue(Account acc) throws Exception {
		System.out.println("ActiveMQ_Queue_Receiver-Messgae:: "+acc);
	}	

}
