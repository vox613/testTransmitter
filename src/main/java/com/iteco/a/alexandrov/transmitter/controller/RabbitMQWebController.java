package com.iteco.a.alexandrov.transmitter.controller;

import com.iteco.a.alexandrov.transmitter.model.Message;
import com.iteco.a.alexandrov.transmitter.service.RabbitMQSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class processes REST requests arriving at the URL "/ rest".
 */
@RestController
@RequestMapping("/rest")
public class RabbitMQWebController {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQWebController.class);
    private RabbitMQSenderService rabbitMQSenderServiceImpl;

    @Autowired
    public RabbitMQWebController(RabbitMQSenderService rabbitMQSenderServiceImpl) {
        this.rabbitMQSenderServiceImpl = rabbitMQSenderServiceImpl;
    }


    /**
     * The method accepts POST requests arriving at URL: "/rest/messages" and sends them to the RabbitMQ queue.
     *
     * @param message - POST request body
     * @return - The response on the successful receipt of the request contains the request and the successful code.
     */
    @PostMapping("/messages")
    public ResponseEntity postProducer(@RequestBody Message message) {
        log.info("POST request message : " + message.getMsgText());
        rabbitMQSenderServiceImpl.send(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

