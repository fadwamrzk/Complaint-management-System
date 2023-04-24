package com.enit.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.FetchType;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorColumn(name="ETUD")
public class Etudiant extends Utilisateur implements Serializable   {
	
	@Column(name="NOMETUDIANT")
	protected String nom;
	
	@Column(name="PRENOMETUDIANT")
	protected String prenom;
	
	
	
	@OneToMany(mappedBy = "etudiant",fetch=FetchType.EAGER)
	protected Collection<Reclamation> reclamationEtud;
	
	
	
	
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
	public Etudiant(String email, String password, boolean actif, String nom, String prenom) {
super(email,password,actif);
this.nom=nom;
this.prenom=prenom;
this.actif=actif;
this.email=email;
this.password=password;

	}
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
