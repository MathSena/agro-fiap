package com.mathsena.agrofiapproducer.service;

import constantes.RabbitMQConst;
import dto.LeituraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeituraService {

    @Autowired
    private RabbitMQService rabbitMQService;


    public boolean sendMessage(LeituraDTO leituraDto)
    {
        boolean isValid = validate(leituraDto);

        if(isValid) {
            this.rabbitMQService.sendMessage(RabbitMQConst.LEITURAS, leituraDto);
        }
        return isValid;
    }

    public  boolean validate(LeituraDTO leitura){

        if(leitura.umidade > 100 || leitura.umidade < 0)
            return false;

        if(leitura.temperatura <-25 || leitura.temperatura > 40)
            return false;

        if(leitura.latitude > 90 || leitura.latitude < -90)
            return false;

        if(leitura.longitude > 180 || leitura.longitude <-180)
            return  false;
        return  true;
    }
}