package com.formation.proxyBank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.Admin;
import com.formation.proxyBank.repositories.AdminRepository;

@Service
public class AdminService {
	@Autowired 
	AdminRepository	adminRepository;
	
    public Admin findById(Long id) {
        Admin admin = adminRepository.getById(id);
        return admin;
    }
    
    public void deleteAdmin(Long id) {

        adminRepository.delete(adminRepository.getById(id));
    }
    
    public List<Admin> getAllAdmin() {

        return adminRepository.findAll();
    }
}
