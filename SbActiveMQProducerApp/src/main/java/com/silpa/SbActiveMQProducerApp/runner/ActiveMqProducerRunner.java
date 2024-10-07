package com.silpa.SbActiveMQProducerApp.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


@Component
public class ActiveMqProducerRunner implements CommandLineRunner{
	@Autowired
	private JmsTemplate jmsTemplate;
	@Value("${queuename}")
	private String destinationName;
	
	@Override
	public void run(String... args) throws Exception {
		MessageCreator messageCreator=session->session.createTextMessage("From Producer : Hello Client");
		 jmsTemplate.send(destinationName, messageCreator);
		
		
	}

}
