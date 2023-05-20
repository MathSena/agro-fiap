package com.mathsena.agrofiapproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String fila, Object message){
        this.rabbitTemplate.convertAndSend(fila, message);
    }
}
