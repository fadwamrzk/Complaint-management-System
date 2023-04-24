package com.enit.entities;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
@Entity
@DiscriminatorColumn(name="ADMIN")
public class Administrateur extends Utilisateur implements Serializable {

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void gererCompteEtudiant(boolean c)
	{
		this.setActif(c);
	}

}
