package org.prueba.tecnica.dnahombresdenegro.controller;

import org.prueba.tecnica.dnahombresdenegro.service.MenInblackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alien")
public class MenInblackController {

    private final MenInblackService menInblackService;

    @Autowired
    public MenInblackController(MenInblackService menInblackService) {
        this.menInblackService = menInblackService;
    }

    @PostMapping
    public ResponseEntity<DnaResponse> verificarDna(@RequestBody DnaRequest dnaRequest){
        boolean isAlien = menInblackService.isAlien(dnaRequest.getDna());
        if(isAlien){
            DnaResponse response = new DnaResponse("El ser es un Alienigena");
            return ResponseEntity.ok(response);
        }else {
            DnaResponse response = new DnaResponse("El ser es un Humano");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

    }

}
