package com.iteco.a.alexandrov.transmitter.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMQSenderServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String message) {
        amqpTemplate.convertAndSend(exchange, routingkey, message);
        System.out.println("Send msg = " + message);
    }
}