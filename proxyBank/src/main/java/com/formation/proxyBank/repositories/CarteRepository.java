package com.formation.proxyBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.proxyBank.entities.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte, String>{

	Carte getById(Long id);

	void deleteById(Long id);
	Carte getCarteByIdClient(Long id);
}
