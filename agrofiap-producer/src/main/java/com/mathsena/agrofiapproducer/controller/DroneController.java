package com.mathsena.agrofiapproducer.controller;

import com.mathsena.agrofiapproducer.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "drone")
public class DroneController {
    @Autowired
    private DroneService service;

    @PostMapping
    private ResponseEntity criarDroneSimulacao(){
        for(int cont=1;cont<=10;cont++)
        {
            service.createDroneSimulation(cont);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
