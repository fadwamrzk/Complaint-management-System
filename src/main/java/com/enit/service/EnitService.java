package com.enit.service;

import com.enit.metier.AuthentificationServiceLocal;
import com.enit.metier.ReclamationServiceLocal;

import java.util.List;

import com.enit.entities.*;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@Stateless
@WebService
public class EnitService {
	@EJB(beanName="RO")
	private ReclamationServiceLocal metierRec;
	
	@EJB(beanName="LO")
	private AuthentificationServiceLocal metierAut;
	
	
	public EnitService() {
		super();
	}
	
	
	@WebMethod
	public void ajouterReclamation(@WebParam(name="mail") String mail,@WebParam(name="titre")String titre,@WebParam(name="description") String description,@WebParam(name="type") String type) {
		Etudiant e=metierAut.recupererEtudiant(mail);
		TypeReclamation typeReclamation=new TypeReclamation (type); 
		Reclamation rec=new Reclamation(e,titre,description,typeReclamation);
		metierRec.ajouterReclamation(rec);
	}
	
	@WebMethod
	public void ajouterTypeReclamation(@WebParam(name="typeReclamation")TypeReclamation typeReclamation) {
		metierRec.ajouterTypeReclamation(typeReclamation);
	}
	
	@WebMethod
	public List<Reclamation> listerReclamations() {
		return metierRec.listerReclamations();
	}
	
	@WebMethod
	public List<Etudiant> listerEtudiants() {
		
		return metierAut.listerEtudiants();
	}

	
	@WebMethod
	public void sauvegarderUtilisateur(@WebParam(name="email")String email, @WebParam(name="password")String password,@WebParam(name="actif") boolean actif, @WebParam(name="nom")String nom, @WebParam(name="prenom")String prenom) {
		
		Etudiant u = new Etudiant(email, password,actif,nom,prenom);
		metierAut.sauvegarderUtilisateur(u);
	}
}
