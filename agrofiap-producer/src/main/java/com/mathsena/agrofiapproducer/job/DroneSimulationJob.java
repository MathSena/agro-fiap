package com.mathsena.agrofiapproducer.job;

import dto.LeituraDTO;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class DroneSimulationJob implements Job {
    private RestTemplate restTemplate = new RestTemplate();

    public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {

        JobDataMap dataMap = jExeCtx.getJobDetail().getJobDataMap();
        int droneId = dataMap.getInt("droneId");

        LeituraDTO leituraDTO = new LeituraDTO();
        leituraDTO.droneId = droneId;
        leituraDTO.temperatura = getRandomNumber(-25,40);
        leituraDTO.umidade=getRandomNumber(0,100);
        leituraDTO.latitude = getRandomNumber(-90,90);
        leituraDTO.longitude = getRandomNumber(-180,180);;
        leituraDTO.rastreamento = (getRandomNumber(0,1)==1);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LeituraDTO> httpExampleRequest = new HttpEntity<>(leituraDTO, headers);
        HttpEntity response = restTemplate.postForObject("http://localhost:8080/leitura", httpExampleRequest, HttpEntity.class);
    }
    private int getRandomNumber (int min, int max) {
        int numAleatorio = ( int )( Math.random() * max );
        if( numAleatorio <= min ) {
            numAleatorio = numAleatorio + min;
        }
        return numAleatorio;
    }
}
