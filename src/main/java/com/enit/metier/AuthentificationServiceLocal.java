package com.enit.metier;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import com.enit.entities.Utilisateur;
import com.enit.entities.Etudiant;
import java.util.List;

@Local
public interface AuthentificationServiceLocal {
	public Utilisateur authentifier(String login, String pwd);
	public boolean existeEmail(String login);
	public void sauvegarderUtilisateur(Utilisateur utilisateur);
	public List<Etudiant> listerEtudiants();
	
	public Etudiant recupererEtudiant(String email);
	public void changerActif(int id);
	
	/*
	void ajouterEtudiant(Integer id,String nom,String prenom,String mail,String password,boolean actif);
	public void ajouterAdmin(Integer id,String mail,String password,boolean actif);*/

}
