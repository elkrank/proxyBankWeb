package com.formation.proxyBank.controllers;

import com.formation.proxyBank.entities.Compte;
import com.formation.proxyBank.service.CompteService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Virement", description = " ")
@RestController
public class VirementController {
	@Autowired
	CompteService compteService;

	@CrossOrigin
	@PutMapping("/virement")
	public void virement(@RequestParam Double montant, @RequestParam Long recepteur, @RequestParam Long emeteur) {
		System.out.println("VIREMENT CONTROLLER montant :"+ montant +" recepeteur "+recepteur+" emeteur : "+emeteur );
		
		compteService.Virement(montant, emeteur, recepteur);

	}
}
