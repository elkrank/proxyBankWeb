package com.formation.proxyBank.dto;

import com.formation.proxyBank.entities.Carte;

import java.util.ArrayList;
import java.util.List;

public class ClientDto {
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	private List<Carte> cartes = new ArrayList<Carte>();
	private int codePostal;
	public ClientDto(){

	}
	public ClientDto(String nom, String prenom, String adresse, int codePostal, String telephone) {
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	
}
