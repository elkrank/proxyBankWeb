package com.formation.proxyBank.service;

import com.formation.proxyBank.entities.Compte;
import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.entities.CompteEpargne;
import com.formation.proxyBank.repositories.CompteCourrantRepository;
import com.formation.proxyBank.repositories.CompteEpargneRepository;
import com.formation.proxyBank.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;

    @Autowired
    CompteCourrantRepository compteCourrantRepository;

    @Autowired
    CompteEpargneRepository compteEpargneRepository;


    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);

    }


    public void Virement(Double montantVirement,Long compteEmeteur, Long compteRecepteur){

        Compte emeteur = compteRepository.getById(compteEmeteur);
        Compte recepteur = compteRepository.getById(compteRecepteur);
        Double montant = montantVirement;

        String typeCompteEmeteur = compteRepository.getTypeCompte(emeteur.getId());
        String typeCompteRecepteur = compteRepository.getTypeCompte(recepteur.getId());

        if(typeCompteEmeteur.equals("CompteCourrant")&& typeCompteRecepteur.equals("CompteCourrant")){
        	CompteCourrant comptecourrantR = compteCourrantRepository.getById(recepteur.getId());
        	CompteCourrant comptecourrantE = compteCourrantRepository.getById(emeteur.getId());

                if((comptecourrantE.getSolde() - montant) > comptecourrantE.getAutorisationDecouverte()){
                		
                	comptecourrantE.setSolde(comptecourrantE.getSolde() - montant );
                    comptecourrantR.setSolde(comptecourrantR.getSolde() + montant );

                    compteCourrantRepository.save( comptecourrantE );
                    compteCourrantRepository.save( comptecourrantR );
                }

        }
        if(typeCompteEmeteur.equals("CompteEpargne")&& typeCompteRecepteur.equals("CompteEpargne")){
            CompteEpargne compteEpargneR = compteEpargneRepository.getById(emeteur.getId());
            CompteEpargne compteEpargneE = compteEpargneRepository.getById(recepteur.getId());
            if((compteEpargneE.getSolde() - montant) > 0){
                compteEpargneE.setSolde(compteEpargneE.getSolde() - montant );
                compteEpargneR.setSolde(compteEpargneR.getSolde() + montant );

                compteEpargneRepository.save(  compteEpargneE );
                compteEpargneRepository.save(  compteEpargneR );
            }

        }
        if(typeCompteEmeteur.equals("CompteCourrant")&& typeCompteRecepteur.equals("CompteEpargne")){
            CompteCourrant compteCourrantE = compteCourrantRepository.getById(emeteur.getId());
            CompteEpargne compteEpargneR = compteEpargneRepository.getById(recepteur.getId());
            if((compteCourrantE.getSolde() - montant) > compteCourrantE.getAutorisationDecouverte()){
                compteCourrantE.setSolde(compteCourrantE.getSolde() - montant );
                compteEpargneR.setSolde(compteEpargneR.getSolde() + montant );

                compteCourrantRepository.save( compteCourrantE );
                compteEpargneRepository.save( compteEpargneR );
            }

        }
        if(typeCompteEmeteur.equals("CompteEpargne")&& typeCompteRecepteur.equals("CompteCourrant")){
            CompteEpargne compteEpargneE = compteEpargneRepository.getById(emeteur.getId());
            CompteCourrant compteCourrantR = compteCourrantRepository.getById(recepteur.getId());
            if((compteEpargneE.getSolde() - montant) > 0){

                compteEpargneE.setSolde(compteEpargneE.getSolde() - montant );
                compteCourrantR.setSolde(compteCourrantR.getSolde() + montant );

                compteEpargneRepository.save( compteEpargneE );
                compteCourrantRepository.save( compteCourrantR );
            }
        }







    }
}
