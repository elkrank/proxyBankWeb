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

            if((emeteur.getSolde() - montant) > 0){
                emeteur.setSolde(emeteur.getSolde() - montant );
                recepteur.setSolde(recepteur.getSolde() + montant );

                compteEpargneRepository.save( (CompteEpargne) emeteur );
                compteEpargneRepository.save( (CompteEpargne) recepteur );
            }

        }
        if(typeCompteEmeteur.equals("CompteCourrant")&& typeCompteRecepteur.equals("CompteEpargne")){

            if((emeteur.getSolde() - montant) > ((CompteCourrant) emeteur).getAutorisationDecouverte()){
                emeteur.setSolde(emeteur.getSolde() - montant );
                recepteur.setSolde(recepteur.getSolde() + montant );

                compteCourrantRepository.save( (CompteCourrant) emeteur );
                compteEpargneRepository.save( (CompteEpargne) recepteur );
            }

        }
        if(typeCompteEmeteur.equals("CompteEpargne")&& typeCompteRecepteur.equals("CompteCourrant")){

            if((emeteur.getSolde() - montant) > 0){

                emeteur.setSolde(emeteur.getSolde() - montant );
                recepteur.setSolde(recepteur.getSolde() + montant );

                compteEpargneRepository.save( (CompteEpargne) emeteur );
                compteCourrantRepository.save( (CompteCourrant) recepteur );
            }
        }







    }
}
