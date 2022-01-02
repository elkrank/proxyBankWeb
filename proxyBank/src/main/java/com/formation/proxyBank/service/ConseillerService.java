package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.repositories.ClientRepository;
import com.formation.proxyBank.repositories.ConseillerRepository;

@Service
public class ConseillerService {
	
	@Autowired
	ConseillerRepository conseillerRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
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

	public void updateConseiller(Long id, Conseiller conseiller) {
		if (conseillerRepository.getById(id)!=null) {
			Conseiller conseillerAncien = conseillerRepository.getById(id);
			if (conseiller.getNom() == null) {
				conseiller.setNom(conseillerAncien.getNom());
			}
			if (conseiller.getPrenom()==null) {
				conseiller.setPrenom(conseillerAncien.getPrenom());
			}
			conseillerRepository.save(conseiller);
		}
		
	}

	public Optional<Conseiller> findConseillerById(Long id) {
		return conseillerRepository.findById(id);
		
	}

	public Optional<Conseiller> addClientToConseiller(Long conseillerId, Long clientId) {
		Optional<Conseiller> conseiller = conseillerRepository.findById(conseillerId);
		Optional<Client> client = clientRepository.findById(clientId);
		if (conseiller.isPresent() && client.isPresent()) {
			client.get().setConseiller(conseiller.get());
			clientRepository.save(client.get());
		}
		return conseiller;
	}

	

}
