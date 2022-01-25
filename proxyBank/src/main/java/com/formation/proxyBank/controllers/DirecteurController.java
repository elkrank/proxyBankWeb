package com.formation.proxyBank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.entities.Directeur;
import com.formation.proxyBank.service.DirecteurService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Directeur", description = " ")
@RestController
@RequestMapping("/directeurs")
public class DirecteurController {

	@Autowired
	DirecteurService directeurService;

	@CrossOrigin
	@PostMapping
	public Directeur createDirecteur(Directeur directeur) {
		return directeurService.createDirecteur(directeur);
	}

	@CrossOrigin
	@ApiOperation(value = "Récupération de tous les directeurs")
	@GetMapping
	public List<Directeur> findAllDirecteurs() {
		return directeurService.listerDirecteur();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<Directeur> findDirecteurById(@PathVariable Long id) {

		return directeurService.findDirecteurById(id);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public void deleteDirecteur(@PathVariable Long id) {
		directeurService.deleteDirecteur(id);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public void updateDirecteur(Long id, Directeur directeur) {
		directeurService.updateDirecteur(id, directeur);
	}

}
