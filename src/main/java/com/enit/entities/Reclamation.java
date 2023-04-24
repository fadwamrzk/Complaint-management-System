package com.enit.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Reclamation implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
protected int id;

@Column(name="TITRE")
protected String titre;

@Column(name="DESCRIPTION")
protected String description;



@ManyToOne
@JoinColumn(name="E_ID")
protected Etudiant etudiant;



@ManyToOne
@JoinColumn(name="TYPE_ID")
protected TypeReclamation typeReclamation;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Reclamation(int id, String titre, String description,TypeReclamation typeReclamation) {
	super();
	this.id = id;
	this.titre = titre;
	this.description = description;
	this.typeReclamation = typeReclamation;
}

public Reclamation(String titre, String description,TypeReclamation typeReclamation) {
	super();
	
	this.titre = titre;
	this.description = description;
	this.typeReclamation = typeReclamation;
}

public Reclamation(Etudiant etudiant,String titre, String description,TypeReclamation typeReclamation) {
	super();
	this.etudiant = etudiant;
	this.titre = titre;
	this.description = description;
	this.typeReclamation = typeReclamation;
}
public Reclamation() {
	super();
	// TODO Auto-generated constructor stub
}
}
