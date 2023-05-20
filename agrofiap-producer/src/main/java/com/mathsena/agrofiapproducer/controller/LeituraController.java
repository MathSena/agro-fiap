package com.mathsena.agrofiapproducer.controller;

import com.mathsena.agrofiapproducer.service.LeituraService;
import dto.LeituraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "leitura")
public class LeituraController {

    @Autowired
    private LeituraService service;

    @PostMapping
    private ResponseEntity insereLeitura(@RequestBody LeituraDTO leituraDto){
        if(this.service.sendMessage(leituraDto))
            return new ResponseEntity(HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
    }
}
