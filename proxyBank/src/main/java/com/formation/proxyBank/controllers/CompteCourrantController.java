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

import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.service.CompteCourrantService;

@RestController
@RequestMapping("/comptes")
public class CompteCourrantController {
	@Autowired
	CompteCourrantService compteCourrantService;

	@PostMapping
	public CompteCourrant createCompteCourrant(Integer numeroDeCompte, Double solde, Long idClient) {
		return compteCourrantService.creercompteCourrant(numeroDeCompte, solde, idClient);
	}

	@GetMapping("/{id}")
	public CompteCourrant readCompteCourrant(@PathVariable Long id){
		return compteCourrantService.readCompteCourrant(id);
		}

	@DeleteMapping("/{id}")
	public void deleteCompteCourrant(@PathVariable Long id) {
		compteCourrantService.deleteCompteCourrant(id);
	}
	
	@GetMapping
	public List<CompteCourrant> getAllComptesCourrants() {
		return compteCourrantService.getAllComptesCourrants();
	} 
	
	@PutMapping("/{id}")
	public CompteCourrant updateCompteCourrant(@PathVariable Long id, @RequestBody CompteCourrant compteCourrant) {
		return compteCourrantService.updateCompteCourrant(id, compteCourrant);
	}
}
