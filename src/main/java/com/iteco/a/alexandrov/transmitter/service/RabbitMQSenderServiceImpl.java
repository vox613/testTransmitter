package com.iteco.a.alexandrov.transmitter.service;

import com.iteco.a.alexandrov.transmitter.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service providing interaction functions in the RabbitMQ message queue.
 */
@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {

    @Value("${rabbitmq.queue}")
    String queueName;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;


    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMQSenderServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * The method accepts the message, converts it, and sends it to the message queue.
     *
     * @param message - Message to send to the message queue.
     * @return - Received message.
     */
    public Message send(Message message) {
        amqpTemplate.convertAndSend(exchange, routingkey, message.getMsgText());
        log.info(String.format("Sended to queue \"%s\" -> message = %s", queueName, message.getMsgText()));
        return message;
    }
}