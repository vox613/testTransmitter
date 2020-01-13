package com.iteco.a.alexandrov.transmitter.controller;

import com.iteco.a.alexandrov.transmitter.model.Message;
import com.iteco.a.alexandrov.transmitter.service.RabbitMQSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RabbitMQWebController.class)
public class RabbitMQWebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RabbitMQSenderService service;

    private final Message sendedMessage = new Message("testString");

    @Test
    public void postProducerTest() throws Exception {
        String url = "/rest/messages";

        Mockito.when(service.send(any(Message.class))).thenReturn(sendedMessage);

        this.mockMvc.perform(post(url, sendedMessage.getMsgText())
                .contentType(MediaType.APPLICATION_JSON)
                .content(sendedMessage.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(sendedMessage.toString()));
    }
}