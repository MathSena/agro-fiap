package com.mathsena.agrofiapconsumer.consumer;

import constantes.RabbitMQConst;
import dto.LeituraDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class LeituraConsumer {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = RabbitMQConst.LEITURAS)
    private void consumer(LeituraDTO leituraDto){

        boolean alertaTemperatura = leituraDto.temperatura >= 35 || leituraDto.temperatura <= 0 ? true : false;
        boolean alertaUmidade = leituraDto.umidade <= 15 ? true : false;

        if(alertaTemperatura || alertaUmidade) {

            String alert = "O droneID " + String.valueOf( leituraDto.droneId) + " apresentou a "
                    + "temperatura:" + String.valueOf( leituraDto.temperatura) + "ºC"
                    + ", umidade: " + String.valueOf( leituraDto.umidade) + "%"
                    + ", latitude: " + String.valueOf( leituraDto.latitude)
                    + ", longitude: " + String.valueOf( leituraDto.longitude)
                    + ", Rastreamento Ativado: " +  (leituraDto.rastreamento  ? "Sim" : "Não");

            System.out.println(alert);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setText(alert);
            message.setSubject("Alerta posicionamento de Drone Id" + String.valueOf( leituraDto.droneId));
            message.setTo("emailDestino");
            message.setFrom("emailOrigem");
            try {
                mailSender.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
