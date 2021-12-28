package com.formation.proxyBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.entities.Admin;
import com.formation.proxyBank.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@GetMapping("/admin")
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	
    @DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);
	}
    
    @GetMapping("/admin/{id}") 
    public Admin getAdminById(@PathVariable Long id){
    	return adminService.findById(id);
    }
}
