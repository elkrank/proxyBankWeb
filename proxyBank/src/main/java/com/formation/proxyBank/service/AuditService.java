package com.formation.proxyBank.service;

import com.formation.proxyBank.entities.Agence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {
    @Autowired
    AgenceService agenceService;


    public Double SoldeTotalCompteCourrantAgence(Long agence_id){
       List<Double> listSolde = agenceService.listeSoldeCompteCourrantAgence(agence_id);
       Double totalSolde=0.0 ;
       for(int i =0 ; i<listSolde.size();i++){
           totalSolde += listSolde.get(i);
       }
    return totalSolde;
    }

    public Double SoldeTotalCompteEpargneAgence(Long agence_id){
        List<Double> listSolde = agenceService.listeSoldeCompteEpargneAgence(agence_id);
        Double totalSolde=0.0 ;
        for(int i =0 ; i<listSolde.size();i++){
            totalSolde += listSolde.get(i);
        }
        return totalSolde;
    }



}
