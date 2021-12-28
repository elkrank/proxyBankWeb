package com.formation.proxyBank.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends  Employe{

    public Admin(String username,String email,String password){super(username, email, password);}

    public Admin() {

    }
}
