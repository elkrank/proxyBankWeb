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
	@PutMapping("/virement/{emeteur}")
	public void virement(@RequestBody Double montant, Long recepteur, @PathVariable Long emeteur) {
		compteService.Virement(montant, emeteur, recepteur);

	}
}
