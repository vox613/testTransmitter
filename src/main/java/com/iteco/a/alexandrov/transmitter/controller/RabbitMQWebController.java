package com.iteco.a.alexandrov.transmitter.controller;

import com.iteco.a.alexandrov.transmitter.model.Message;
import com.iteco.a.alexandrov.transmitter.model.Response;
import com.iteco.a.alexandrov.transmitter.service.RabbitMQSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RabbitMQWebController {

    private RabbitMQSenderServiceImpl rabbitMQSenderServiceImpl;

    @Autowired
    public RabbitMQWebController(RabbitMQSenderServiceImpl rabbitMQSenderServiceImpl) {
        this.rabbitMQSenderServiceImpl = rabbitMQSenderServiceImpl;
    }

    @PostMapping("/message")
    private Response postProducer(@RequestBody Message message) {
        System.out.println("getMsgText = " + message.getMsgText());
        rabbitMQSenderServiceImpl.send(message.getMsgText());
        return new Response("Done", message);

        // ResponseEntity ResponseEntity<Message> respEnt = new ResponseEntity<>(message, HttpStatus.OK);
    }
}

