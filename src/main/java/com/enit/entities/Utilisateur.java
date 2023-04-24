package com.enit.entities;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
//@Inheritance (strategy =InheritanceType.JOINED)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_utilisateur",discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	@Column(name="EMAIL")
	protected String email;
	
	@Column(name="PASSWORD")
	protected String password;
	
	@Column(name="ACTIF")
	protected boolean actif;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(String email, String password, boolean actif) {
		super();
		
		this.email = email;
		this.password = password;
		this.actif = actif;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}


	


}
