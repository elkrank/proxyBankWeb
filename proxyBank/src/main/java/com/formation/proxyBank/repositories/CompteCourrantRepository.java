package com.formation.proxyBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.proxyBank.entities.CompteCourrant;
@Repository
public interface CompteCourrantRepository extends JpaRepository<CompteCourrant, Long> {

}
