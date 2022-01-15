package com.formation.proxyBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.service.CompteCourrantService;

@RestController
@RequestMapping("/comptes")
public class CompteCourrantController {
	@Autowired
	CompteCourrantService compteCourrantService;

	@CrossOrigin
	@PostMapping
	public CompteCourrant createCompteCourrant(@RequestParam Long numeroDeCompte,@RequestParam Double solde,@RequestParam Long idClient) {
		return compteCourrantService.creercompteCourrant(numeroDeCompte, solde, idClient);
	}
	@CrossOrigin
	@GetMapping("/{id}")
	public CompteCourrant readCompteCourrant(@PathVariable Long id){
		return compteCourrantService.readCompteCourrant(id);
		}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public void deleteCompteCourrant(@PathVariable Long id) {
		compteCourrantService.deleteCompteCourrant(id);
	}

	@CrossOrigin
	@GetMapping
	public List<CompteCourrant> getAllComptesCourrants() {
		return compteCourrantService.getAllComptesCourrants();
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public CompteCourrant updateCompteCourrant(@PathVariable Long id, @RequestBody CompteCourrant compteCourrant) {
		return compteCourrantService.updateCompteCourrant(id, compteCourrant);
	}
}
