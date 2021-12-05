package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.CompteEpargne;
import com.formation.proxyBank.repositories.CompteEpargneRepository;

@Service
public class CompteEpargneService {
	@Autowired
	CompteEpargneRepository compteEpargneRepository;
	
	@Autowired
	ClientService clientService;

	public CompteEpargne createCompteEpargne(Integer numeroDeCompte, Double solde, Long idClient) {
		CompteEpargne compteEpargneNew = new CompteEpargne();
		compteEpargneNew.setNumeroDeCompte(numeroDeCompte);
		compteEpargneNew.setSolde(solde);
		compteEpargneNew.setClient(clientService.getOneClient(idClient));
		compteEpargneRepository.save(compteEpargneNew);
		return compteEpargneNew;
		
	}

	public Optional<CompteEpargne> readCompteEpargne(Long id) {
		return compteEpargneRepository.findById(id);
	}

	public void deleteCompteEpargne(Long id) {
		compteEpargneRepository.deleteById(id);
		
	}

	public List<CompteEpargne> getAllCompteEpargne() {
		return compteEpargneRepository.findAll();
	}

	public CompteEpargne updateCompteEpargne(Long id, CompteEpargne compteEpargne) {
		Optional<CompteEpargne> oldCompteEpargne = compteEpargneRepository.findById(id);
		if (oldCompteEpargne.isPresent() && compteEpargne != null) {
			compteEpargneRepository.save(compteEpargne);
		}
		return compteEpargne;
	}

}
