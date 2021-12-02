package com.formation.proxyBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.repositories.ConseillerRepository;
import com.formation.proxyBank.service.ConseillerService;

@RestController
@RequestMapping("/proxybank/conseillers")
public class ConseillerController {
	@Autowired
	ConseillerService conseillerService;
	
	@PostMapping
	public Conseiller createConseiller(String nom, String prenom) {
		return conseillerService.creerConseiller( nom, prenom);
	}
	
	@GetMapping
	
	public List<Conseiller> findAllConseillers(){
		return conseillerService.listerConseiller();
	}
	
	@DeleteMapping("/{id}")
	public void deleteConseiller(@PathVariable Long id) {
		conseillerService.deleteConseiller(id);
	}
	
	@PutMapping
	public void updateConseiller(Conseiller conseiller) {
		conseillerService.updateConseiller(conseiller);
	}

}
