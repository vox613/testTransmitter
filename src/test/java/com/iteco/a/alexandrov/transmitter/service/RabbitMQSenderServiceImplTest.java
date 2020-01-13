package com.iteco.a.alexandrov.transmitter.service;

import com.iteco.a.alexandrov.transmitter.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;


@RunWith(MockitoJUnitRunner.class)
public class RabbitMQSenderServiceImplTest {

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Mock
    public AmqpTemplate amqpTemplate;
    @InjectMocks
    public RabbitMQSenderServiceImpl messageService;


    @Test
    public void send() {
        Message testMessage = new Message("testMessage");
        messageService.send(testMessage);
        Mockito.verify(amqpTemplate, Mockito.times(1))
                .convertAndSend(exchange, routingkey, testMessage.getMsgText());
    }
}