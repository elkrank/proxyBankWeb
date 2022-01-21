package com.formation.proxyBank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.entities.CompteEpargne;
import com.formation.proxyBank.service.CompteEpargneService;

@RestController
@RequestMapping("/comptese-epargne")
public class CompteEpargneController {

	@Autowired
	CompteEpargneService compteEpargneService;

	@CrossOrigin
	@PostMapping
	public CompteEpargne createComptesEpargne(@RequestParam Long numeroDeCompte,@RequestParam Double solde,@RequestParam Long idClient) {
		return compteEpargneService.createCompteEpargne(numeroDeCompte, solde, idClient);
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<CompteEpargne> readCompteEpargne(@PathVariable Long id){
		return compteEpargneService.readCompteEpargne(id);
		}
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void deleteCompteEpargne(@PathVariable Long id) {
		compteEpargneService.deleteCompteEpargne(id);
	}

	@CrossOrigin
	@GetMapping
	public List<CompteEpargne> getAllComptesEpargne() {
		return compteEpargneService.getAllCompteEpargne();
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public CompteEpargne updateCompteEpargne(@PathVariable Long id, @RequestBody CompteEpargne compteEpargne) {
		return compteEpargneService.updateCompteEpargne(id, compteEpargne);
	}
}
