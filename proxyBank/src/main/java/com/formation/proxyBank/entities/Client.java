package com.formation.proxyBank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String telephone;
	
	@ManyToOne
	@JsonIgnore
	private Conseiller conseiller;

	@OneToMany(mappedBy = "idClient")
	private List<Carte> cartes = new ArrayList<Carte>();

	/*@OneToMany(mappedBy = "client")
	private List<Compte> comptes = new ArrayList<Compte>();*/



	@OneToOne
	private CompteCourrant compteCourrant;

	@OneToOne
	private CompteEpargne compteEpargne;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public CompteCourrant getCompteCourrant() {
		return compteCourrant;
	}

	public void setCompteCourrant(CompteCourrant compteCourrant) {
		this.compteCourrant = compteCourrant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal="
				+ codePostal + ", telephone=" + telephone + "]";
	}

}
