package com.formation.proxyBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.repositories.ConseillerRepository;

@Service
public class ConseillerService {
	
	@Autowired
	ConseillerRepository conseillerRepository;
	
	public Conseiller creerConseiller(String nom , String prenom ) {
		Conseiller conseiller = new Conseiller(nom, prenom);
		return conseillerRepository.save(conseiller);
	}

}
