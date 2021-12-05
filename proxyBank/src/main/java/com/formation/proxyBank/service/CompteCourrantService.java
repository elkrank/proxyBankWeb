package com.formation.proxyBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.repositories.CompteCourrantRepository;



@Service
public class CompteCourrantService {
	@Autowired
	CompteCourrantRepository compteCourrantRepository;
	
	@Autowired
	ClientService clientService;

	public CompteCourrant creercompteCourrant(Integer numeroDeCompte, Double solde, Long idClient) {
		CompteCourrant compteCourrant = new CompteCourrant(numeroDeCompte, solde, clientService.getOneClient(idClient));
		return compteCourrantRepository.save(compteCourrant);
	}

	public void deleteCompteCourrant(Long id) {
		compteCourrantRepository.deleteById(id);
		
	}

}
