package com.formation.proxyBank.dto;

public class FullRegisterDto  {

    Long idClient;
    String nom;
    String prenom;
    String adresse;
    int codePostal;
    String telephone;

    Long numeroCompteCourrant;
    Double soldeCompteCourrant;

    Long numeroCompteEpargne;
    Double soldeCompteEpargne;

    String numeroDeCarte;
    String typeDeCarte;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
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

    public Long getNumeroCompteCourrant() {
        return numeroCompteCourrant;
    }

    public void setNumeroCompteCourrant(Long numeroCompteCourrant) {
        this.numeroCompteCourrant = numeroCompteCourrant;
    }

    public Double getSoldeCompteCourrant() {
        return soldeCompteCourrant;
    }

    public void setSoldeCompteCourrant(Double soldeCompteCourrant) {
        this.soldeCompteCourrant = soldeCompteCourrant;
    }

    public Long getNumeroCompteEpargne() {
        return numeroCompteEpargne;
    }

    public void setNumeroCompteEpargne(Long numeroCompteEpargne) {
        this.numeroCompteEpargne = numeroCompteEpargne;
    }

    public Double getSoldeCompteEpargne() {
        return soldeCompteEpargne;
    }

    public void setSoldeCompteEpargne(Double soldeCompteEpargne) {
        this.soldeCompteEpargne = soldeCompteEpargne;
    }

    public String getNumeroDeCarte() {
        return numeroDeCarte;
    }

    public void setNumeroDeCarte(String numeroDeCarte) {
        this.numeroDeCarte = numeroDeCarte;
    }

    public String getTypeDeCarte() {
        return typeDeCarte;
    }

    public void setTypeDeCarte(String typeDeCarte) {
        this.typeDeCarte = typeDeCarte;
    }
}
