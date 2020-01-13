package com.iteco.a.alexandrov.transmitter.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ Queue Configurator Class
 */
@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue}")
    String queueName;

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    /**
     * Creates a queue with specific parameters.
     * @return - created queue.
     */
    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }


    /**
     * Creates a exchange with specific parameters.
     * @return - created exchange.
     */
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange, true, false);
    }


    /**
     * Link queue and exchanger using routing key.
     * @return - container collecting information to describe a binding.
     */
    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

}
