package com.formation.proxyBank.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.service.CarteService;

@RestController
public class CarteController {
	
	@Autowired CarteService carteService;
	
	@PostMapping("/cartes") 
		public Carte createCarte(@RequestBody CarteDto carteDto, Long clientId) {
			return carteService.createCarte(carteDto, clientId);
		}


	@GetMapping("/cartes/{id}")
		public Carte getCarteById(@PathVariable Long id) {
			return carteService.getCarteById(id);
	}


	@Transactional
	@DeleteMapping("/cartes/{id}")
		public void deleteCarte(@PathVariable Long id) {
			carteService.deleteCarte(id);
	}
	
	@PutMapping("/cartes/{id}") 
		public void modifyCarte(@PathVariable Long id, @RequestBody CarteDto carteDto) {
			carteService.modifyCarte(id, carteDto);
	}
}