package com.formation.proxyBank.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.proxyBank.entities.Directeur;

@Repository
public interface DirecteurRepository extends JpaRepository<Directeur, Long> {

}
