package com.formation.proxyBank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.entities.CompteEpargne;
import com.formation.proxyBank.service.CompteEpargneService;

@RestController
@RequestMapping("/comptese-epargne")
public class CompteEpargneController {

	@Autowired
	CompteEpargneService compteEpargneService;


	@PostMapping
	public CompteEpargne createComptesEpargne(Long numeroDeCompte, Double solde, Long idClient) {
		return compteEpargneService.createCompteEpargne(numeroDeCompte, solde, idClient);
	}


	@GetMapping("/{id}")
	public Optional<CompteEpargne> readCompteEpargne(@PathVariable Long id){
		return compteEpargneService.readCompteEpargne(id);
		}

	@DeleteMapping("/{id}")
	public void deleteCompteEpargne(@PathVariable Long id) {
		compteEpargneService.deleteCompteEpargne(id);
	}


	@GetMapping
	public List<CompteEpargne> getAllComptesCourrants() {
		return compteEpargneService.getAllCompteEpargne();
	}


	@PutMapping("/{id}")
	public CompteEpargne updateCompteEpargne(@PathVariable Long id, @RequestBody CompteEpargne compteEpargne) {
		return compteEpargneService.updateCompteEpargne(id, compteEpargne);
	}
}
