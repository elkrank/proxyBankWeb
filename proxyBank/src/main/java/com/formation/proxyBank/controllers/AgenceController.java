package com.formation.proxyBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.service.AgenceService;

@RestController
public class AgenceController {
    @Autowired
    AgenceService agenceService;

    @PostMapping("/agences")
    public Agence createAgence(@RequestBody String name){
       Agence agence = agenceService.createAgence(name);
        return agence;
    }

    @GetMapping("/agences/{id}/")
    @ResponseBody
    public Agence getAgenceById(@PathVariable Long id){
        Agence agence = agenceService.findById(id);
        return agence;
    }

    @PutMapping("/agences/{id}")
    public Agence updateAgence(@PathVariable Long id,@RequestBody Agence agenceP ){
        Agence agence = agenceService.updateAgence(id,agenceP);
        return agence;
    }

    @PutMapping("/agences/{id_agence}/ajouterEmploye/{idEmploye}")
    public Agence addEmployeToAgence(@PathVariable Long id_agence,@PathVariable Long idEmploye){
    Agence agence = agenceService.addEmployeToAgence(id_agence,idEmploye);
    return agence;
    }

    @DeleteMapping("/agences/{id}")
    public void deleteAgence(@PathVariable Long id ){
        agenceService.deleteAgence(id);
    }


    @GetMapping ("/agences")
    public List<Agence> getAllAgence(){
        List<Agence> listAgence = agenceService.getAllAgence();
        return listAgence;
    }
}
