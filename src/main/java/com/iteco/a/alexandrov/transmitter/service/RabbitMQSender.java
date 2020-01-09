package com.iteco.a.alexandrov.transmitter.service;

import com.iteco.a.alexandrov.transmitter.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	private AmqpTemplate amqpTemplate;


	@Autowired
	public RabbitMQSender(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public void send(Message message) {
		amqpTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Send msg = " + message);
	    
	}
}