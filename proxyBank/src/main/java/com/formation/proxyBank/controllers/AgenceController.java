package com.formation.proxyBank.controllers;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxybank")
public class AgenceController {
    @Autowired
    AgenceService agenceService;

    @PostMapping("/agence")
    public Agence createAgence(@RequestBody String name){
       Agence agence = agenceService.createAgence(name);
        return agence;
    }

}
