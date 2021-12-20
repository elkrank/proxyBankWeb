package com.formation.proxyBank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.entities.Directeur;
import com.formation.proxyBank.service.DirecteurService;

@RestController
@RequestMapping("/directeurs")
public class DirecteurController {

	@Autowired
	DirecteurService directeurService;
	
	@PostMapping
	public Directeur createDirecteur(Directeur directeur) {
		return directeurService.createDirecteur(directeur);
	}
	
	@GetMapping
	
	public List<Directeur> findAllDirecteurs(){
		return directeurService.listerDirecteur();
	}
	@GetMapping("/{id}")
	public Optional<Directeur> findDirecteurById(@PathVariable Long id) {
		return directeurService.findDirecteurById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDirecteur(@PathVariable Long id) {
		directeurService.deleteDirecteur(id);
	}
	
	@PutMapping("/{id}")
	public void updateDirecteur(Long id, Directeur directeur) {
		directeurService.updateDirecteur(id, directeur);
	}
	
}
