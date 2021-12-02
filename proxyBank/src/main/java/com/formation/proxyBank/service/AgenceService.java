package com.formation.proxyBank.service;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.repositories.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenceService {
    @Autowired
    AgenceRepository agenceRepository;
    public Agence createAgence(String name){
        Agence agence = new Agence();
        agence.setAgenceName(name);
        agenceRepository.save(agence);
        return agence;
    }
}
