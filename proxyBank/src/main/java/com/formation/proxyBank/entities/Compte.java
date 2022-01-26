package com.formation.proxyBank.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_compte")
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroDeCompte;
	private Double solde =0.0;
	private LocalDate dateOuverture;

	@OneToOne
	@JsonIgnore
	private Client client;

	public Compte() {
		super();
		this.dateOuverture = LocalDate.now();
	}
	
	public Compte(Long numeroDeCompte, Double solde, Client client) {
		super();
		this.numeroDeCompte = numeroDeCompte;
		this.solde = solde;
		this.dateOuverture = LocalDate.now();
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroDeCompte() {
		return numeroDeCompte;
	}

	public void setNumeroDeCompte(Long numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public LocalDate getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(LocalDate dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numeroDeCompte=" + numeroDeCompte + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + ", client=" + client + "]";
	}

}
