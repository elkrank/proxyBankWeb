package com.formation.proxyBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.proxyBank.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{
	
}
