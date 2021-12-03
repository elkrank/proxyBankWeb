package com.formation.proxyBank.controllers;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.service.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/agence/{id}/")
    @ResponseBody
    public Agence getAgenceById(@PathVariable Long id){
        Agence agence = agenceService.findById(id);
        return agence;
    }
    @PutMapping("/agence/{id}")
    public Agence updateAgence(@PathVariable Long id,@RequestBody Agence agenceP ){
        Agence agence = agenceService.updateAgence(id,agenceP);
        return agence;
    }
}
