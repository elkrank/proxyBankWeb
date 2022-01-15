package com.formation.proxyBank.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.service.CarteService;

@RestController
public class CarteController {
	
	@Autowired CarteService carteService;
	@CrossOrigin
	@PostMapping("/cartes") 
		public Carte createCarte(@RequestBody CarteDto carteDto, Long clientId) {
			return carteService.createCarte(carteDto, clientId);
		}

	@CrossOrigin
	@GetMapping("/cartes/{id}")
		public Carte getCarteById(@PathVariable Long id) {
			return carteService.getCarteById(id);
	}

	@CrossOrigin
	@Transactional
	@DeleteMapping("/cartes/{id}")
		public void deleteCarte(@PathVariable Long id) {
			carteService.deleteCarte(id);
	}
	@CrossOrigin
	@PutMapping("/cartes/{id}") 
		public void modifyCarte(@PathVariable Long id, @RequestBody CarteDto carteDto) {
			carteService.modifyCarte(id, carteDto);
	}
}