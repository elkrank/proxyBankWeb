package com.formation.proxyBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.entities.Agence;
import com.formation.proxyBank.service.AgenceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Agence", description = " ")
@RestController
public class AgenceController {
	@Autowired
	AgenceService agenceService;

	@CrossOrigin
	@PostMapping("/agences")
	public Agence createAgence(@RequestBody String name) {
		Agence agence = agenceService.createAgence(name);
		return agence;
	}

	@CrossOrigin
	@ApiOperation(value = "Récupération de toutes les agences")
	@GetMapping("/agences/{id}/")
	@ResponseBody
	public Agence getAgenceById(@PathVariable Long id) {
		Agence agence = agenceService.findById(id);
		return agence;
	}

	@CrossOrigin
	@PutMapping("/agences/{id}")
	public Agence updateAgence(@PathVariable Long id, @RequestBody Agence agenceP) {
		Agence agence = agenceService.updateAgence(id, agenceP);
		return agence;
	}

	@CrossOrigin
	@PutMapping("/agences/{id_agence}/ajouterEmploye/{idEmploye}")
	public Agence addEmployeToAgence(@PathVariable Long id_agence, @PathVariable Long idEmploye) {
		Agence agence = agenceService.addEmployeToAgence(id_agence, idEmploye);
		return agence;
	}

	@CrossOrigin
	@PutMapping("/agences/{id_agence}/associer/{idDirecteur}")
	public Agence associateDirecteurToAgence(@PathVariable Long id_agence, @PathVariable Long idDirecteur) {
		Agence agence = agenceService.associateDirecteurToAgence(id_agence, idDirecteur);
		return agence;
	}

	@CrossOrigin
	@DeleteMapping("/agences/{id}")
	public void deleteAgence(@PathVariable Long id) {
		agenceService.deleteAgence(id);
	}

	@CrossOrigin
	@GetMapping("/agences")
	public List<Agence> getAllAgence() {
		List<Agence> listAgence = agenceService.getAllAgence();
		return listAgence;
	}
}
