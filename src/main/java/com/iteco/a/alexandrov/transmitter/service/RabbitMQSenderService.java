package com.iteco.a.alexandrov.transmitter.service;

import com.iteco.a.alexandrov.transmitter.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface RabbitMQSenderService {
    Logger log = LoggerFactory.getLogger(RabbitMQSenderService.class);
    Message send(Message message);
}
