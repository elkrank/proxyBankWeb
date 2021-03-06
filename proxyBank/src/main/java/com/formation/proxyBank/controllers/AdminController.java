package com.formation.proxyBank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.entities.Admin;
import com.formation.proxyBank.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Admin", description = " ")
@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	@CrossOrigin
	@ApiOperation(value = "Récupération de tous les administrateurs")
	@GetMapping("/admin")
	public List<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}

	@CrossOrigin
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);
	}

	@CrossOrigin
	@GetMapping("/admin/{id}")
	public Admin getAdminById(@PathVariable Long id) {
		return adminService.findById(id);
	}
}
