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
    public void Virement(double montantVirement,Compte compteEmeteur, Compte compteRecepteur){

        Compte emeteur = compteEmeteur;
        Compte recepteur = compteRecepteur;
        double montant = montantVirement;

        String typeCompteEmeteur = compteRepository.getTypeCompte(emeteur.getId());
        String typeCompteRecepteur = compteRepository.getTypeCompte(recepteur.getId());

        if(typeCompteEmeteur.equals("CompteCourrant")&& typeCompteRecepteur.equals("CompteCourrant")){

                if((emeteur.getSolde() - montant) > ((CompteCourrant) emeteur).getAutorisationDecouverte()){

                    emeteur.setSolde(emeteur.getSolde() - montant );
                    recepteur.setSolde(recepteur.getSolde() + montant );

                    compteCourrantRepository.save( (CompteCourrant) emeteur );
                    compteCourrantRepository.save( (CompteCourrant) compteRecepteur );
                }

        }
        if(typeCompteEmeteur.equals("CompteEpargne")&& typeCompteRecepteur.equals("CompteEpargne")){

            if((emeteur.getSolde() - montant) > 0){
                emeteur.setSolde(emeteur.getSolde() - montant );
                recepteur.setSolde(recepteur.getSolde() + montant );

                compteEpargneRepository.save( (CompteEpargne) emeteur );
                compteEpargneRepository.save( (CompteEpargne) compteRecepteur );
            }

        }
        if(typeCompteEmeteur.equals("CompteCourrant")&& typeCompteRecepteur.equals("CompteEpargne")){

            if((emeteur.getSolde() - montant) > ((CompteCourrant) emeteur).getAutorisationDecouverte()){
                emeteur.setSolde(emeteur.getSolde() - montant );
                recepteur.setSolde(recepteur.getSolde() + montant );
                compteCourrantRepository.save( (CompteCourrant) emeteur );
                compteEpargneRepository.save( (CompteEpargne) compteRecepteur );
            }

        }
        if(typeCompteEmeteur.equals("CompteEpargne")&& typeCompteRecepteur.equals("CompteCourrant")){

            if((emeteur.getSolde() - montant) > 0){

                emeteur.setSolde(emeteur.getSolde() - montant );
                recepteur.setSolde(recepteur.getSolde() + montant );

                compteEpargneRepository.save( (CompteEpargne) emeteur );
                compteCourrantRepository.save( (CompteCourrant) compteRecepteur );
            }
        }

        // verifier le type du compte





    }
}
