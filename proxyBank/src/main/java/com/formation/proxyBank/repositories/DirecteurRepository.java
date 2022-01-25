package com.formation.proxyBank.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.proxyBank.entities.Directeur;

import java.util.List;

@Repository
public interface DirecteurRepository extends JpaRepository<Directeur, Long> {



    List<Directeur> findByAgenceIsNull();

}
