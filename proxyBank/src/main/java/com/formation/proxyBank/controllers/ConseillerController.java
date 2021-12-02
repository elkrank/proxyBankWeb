package com.formation.proxyBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.service.ConseillerService;

@RestController
@RequestMapping("/proxybank")
public class ConseillerController {
	@Autowired
	ConseillerService conseillerService;
	
	@PostMapping
	public Conseiller creerConseiller(String nom, String prenom) {
		return conseillerService.creerConseiller( nom, prenom);
	}


}
