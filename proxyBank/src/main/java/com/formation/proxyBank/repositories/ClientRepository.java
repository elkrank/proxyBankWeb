package com.formation.proxyBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.proxyBank.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
