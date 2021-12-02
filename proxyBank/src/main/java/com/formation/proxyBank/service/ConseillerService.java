package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

	public List<Conseiller> listerConseiller() {
		return conseillerRepository.findAll();
	}

	public void deleteConseiller(Long id) {
		conseillerRepository.deleteById(id);;
		
	}

	public void updateConseiller(Conseiller conseiller) {
		conseillerRepository.save(conseiller);
		
	}

	

}
