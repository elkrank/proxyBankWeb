package com.formation.proxyBank.service;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.entities.Employe;
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

    public Agence findById(Long id) {
        Agence agence = agenceRepository.getById(id);
        return agence;
    }

    public Agence updateAgence(Long id,Agence agenceP) {
    Agence agence = agenceRepository.getById(id);
    agence.setAgenceName(agenceP.getAgenceName());
    agence.setId(agence.getId());
    agence.setDateDeCreation(agence.getDateDeCreation());
    return agence;

    }
    @Autowired
    ConseillerService conseillerService;
    public Agence addEmployeToAgence(Long id_agence, Long idEmploye) {
        Agence agence = agenceRepository.getById(id_agence);
        Employe employe = conseillerService.
        agence.getListEmploye().add()
    }
}
