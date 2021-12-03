package com.formation.proxyBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDeCreation =  LocalDate.now();
    private String agenceName;
    @OneToMany
    private List<Employe> listEmploye = new ArrayList<Employe>();

    public List<Employe> getListEmploye() {
        return listEmploye;
    }

    public void setListEmploye(List<Employe> listEmploye) {
        this.listEmploye = listEmploye;
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
                ", listEmploye=" + listEmploye +
                '}';
    }
}
