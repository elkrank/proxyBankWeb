package com.formation.proxyBank.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends  Employe{

    public Admin(String username,String email,String password){super(username, email, password);}
    public Admin(String username,String email,String password,String nom, String prenom){
        super(username, email, password,nom,prenom);
    }
    public Admin() {

    }
}
