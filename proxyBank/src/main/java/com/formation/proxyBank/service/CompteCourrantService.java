package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

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

	public CompteCourrant creercompteCourrant(Long numeroDeCompte, Double solde, Long idClient) {
		CompteCourrant compteCourrant = new CompteCourrant(numeroDeCompte, solde, clientService.getOneClient(idClient));
		return compteCourrantRepository.save(compteCourrant);
	}

	public CompteCourrant readCompteCourrant(Long id) {
		CompteCourrant compteCourrant = compteCourrantRepository.getById(id);
		return compteCourrant;
	}

	public void deleteCompteCourrant(Long id) {
		compteCourrantRepository.deleteById(id);

	}

	public List<CompteCourrant> getAllComptesCourrants() {
		return compteCourrantRepository.findAll();

	}

	public CompteCourrant updateCompteCourrant(Long id, CompteCourrant compteCourrant) {
		Optional<CompteCourrant> oldCompteCourrant = compteCourrantRepository.findById(id);
		if (oldCompteCourrant.isPresent() && compteCourrant != null) {
			compteCourrantRepository.save(compteCourrant);
		}
		return compteCourrant;
	}

}
