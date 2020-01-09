package com.iteco.a.alexandrov.transmitter.controller;

import com.iteco.a.alexandrov.transmitter.model.Message;
import com.iteco.a.alexandrov.transmitter.model.Response;
import com.iteco.a.alexandrov.transmitter.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RabbitMQWebController {

    private RabbitMQSender rabbitMQSender;

    @Autowired
    public RabbitMQWebController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/message")
    private Response postProducer(@RequestBody Message message) {
        System.out.println("getMsgText = " + message.getMsgText());
        rabbitMQSender.send(message);
        Response response = new Response("Done", message);
        return response;
    }
}

