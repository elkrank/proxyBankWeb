package com.formation.proxyBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.service.CarteService;

@RestController
@RequestMapping("/proxybank")
public class CarteController {
	
	@Autowired CarteService carteService;
	
	@PostMapping(value = "/cartes", consumes = "application/json") 
		public Carte createCarte(@RequestBody CarteDto carteDto) {
			return carteService.createCarte(carteDto);
		}
	
	@GetMapping("/cartes/{id}")
		public Carte getCarteById(@PathVariable Long id) {
			return carteService.getCarteById(id);
	}
}