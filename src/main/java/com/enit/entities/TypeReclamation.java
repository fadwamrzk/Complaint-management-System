package com.enit.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeReclamation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="TYPE")
    private String type;
	
	@OneToMany(mappedBy = "typeReclamation",fetch=FetchType.EAGER)
	private Collection<Reclamation> reclamationTypeRec;
public TypeReclamation() {
	super();
	// TODO Auto-generated constructor stub
}
public TypeReclamation(int id, String type) {
	super();
	this.id = id;
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public TypeReclamation(String type, List<Reclamation> reclamations) {
	super();
	this.type = type;
	this.reclamationTypeRec = reclamations;
}
public TypeReclamation(String type) {
	super();
	this.type = type;
	
}
}
