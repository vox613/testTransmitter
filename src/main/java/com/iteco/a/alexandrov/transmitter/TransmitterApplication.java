package com.iteco.a.alexandrov.transmitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The application processes REST requests received from the web page and sends messages to the RabbitMQ queue.
 */
@SpringBootApplication
public class TransmitterApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransmitterApplication.class, args);
    }

}
