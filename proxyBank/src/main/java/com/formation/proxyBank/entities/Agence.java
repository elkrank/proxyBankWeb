package com.formation.proxyBank.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDeCreation =  LocalDate.now();
    private String agenceName;
    @OneToMany(mappedBy = "agence")
    public List<Conseiller> listConseiller = new ArrayList<Conseiller>();
    
    @OneToOne(mappedBy = "agence")
    private Directeur directeur;

    public Directeur getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Directeur directeur) {
		this.directeur = directeur;
	}
	

	public List<Conseiller> getListConseiller() {
        return listConseiller;
    }

    public void setListConseiller(List<Conseiller> listConseiller) {
        this.listConseiller = listConseiller;
    }

    public String getAgenceName() {
        return agenceName;
    }

    public void setAgenceName(String agenceName) {
        this.agenceName = agenceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", dateDeCreation=" + dateDeCreation +
                ", agenceName='" + agenceName + '\'' +
                ", listConseiller=" + listConseiller +
                '}';
    }
}
