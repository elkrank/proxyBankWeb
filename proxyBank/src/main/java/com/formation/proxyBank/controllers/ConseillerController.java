package com.formation.proxyBank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.service.ConseillerService;

import io.swagger.annotations.Api;

@Api(tags = "Conseiller", description = " ")
@RestController
@RequestMapping("/conseillers")
public class ConseillerController {
	@Autowired
	ConseillerService conseillerService;

	@CrossOrigin
	@PostMapping
	public Conseiller createConseiller(String nom, String prenom) {
		return conseillerService.creerConseiller(nom, prenom);
	}

	@CrossOrigin
	@GetMapping
	public List<Conseiller> findAllConseillers() {

		return conseillerService.listerConseiller();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Conseiller findConseillerById(@PathVariable Long id) {
		return conseillerService.findConseillerById(id);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public void deleteConseiller(@PathVariable Long id) {

		conseillerService.deleteConseiller(id);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public void updateConseiller(Long id, Conseiller conseiller) {
		conseillerService.updateConseiller(id, conseiller);
	}

	@CrossOrigin
	@PostMapping("/{id_conseiller}/assignerClient")
	public Optional<Conseiller> addClientToConseiller(@PathVariable Long id_conseiller, @RequestParam Long clientId) {
		return conseillerService.addClientToConseiller(id_conseiller, clientId);
	}

}
