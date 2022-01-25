package com.formation.proxyBank.controllers;

import com.formation.proxyBank.entities.Compte;
import com.formation.proxyBank.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirementController {

    @Autowired
    CompteService compteService;

    @CrossOrigin
    @PutMapping("/virement")
    public void virement(Double montant, Long emeteur, Long recepteur){
        compteService.Virement(montant,emeteur,recepteur);

    }
}
