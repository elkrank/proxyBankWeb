package com.formation.proxyBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
