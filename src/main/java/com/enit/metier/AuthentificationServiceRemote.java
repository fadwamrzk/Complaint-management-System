package com.enit.metier;

import java.util.List;

import com.enit.entities.Etudiant;
import com.enit.entities.Utilisateur;

import jakarta.ejb.Remote;

@Remote
public interface AuthentificationServiceRemote {
	public Utilisateur authentifier(String login, String pwd);
	boolean existeEmail(String login);
	void sauvegarderUtilisateur(Utilisateur utilisateur);
	List<Etudiant> listerEtudiants();
	
	Etudiant recupererEtudiant(String email);
	public void changerActif(int id);
	/*
	void ajouterEtudiant(Integer id,String nom,String prenom,String mail,String password,boolean actif);
	public void ajouterAdmin(Integer id,String mail,String password,boolean actif);*/
}
