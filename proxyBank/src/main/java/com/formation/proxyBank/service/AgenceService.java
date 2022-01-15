package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.repositories.AgenceRepository;

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
        Conseiller employe = conseillerService.findConseillerById(idEmploye);
        employe.setAgence(agence);
        agenceRepository.save(agence);
        return  agence;
    }

    public void deleteAgence(Long id) {
        agenceRepository.delete(agenceRepository.getById(id));
    }

    public List<Agence> getAllAgence() {
        return agenceRepository.findAll();
    }

    public List<Double> listeSoldeCompteCourrantAgence(Long agence_id){
        return agenceRepository.listeSoldeCompteCourrantAgence(agence_id);
    }
    public List<Double> listeSoldeCompteEpargneAgence(Long agence_id){
        return agenceRepository.listeSoldeCompteEpargneAgence(agence_id);
    }
}
