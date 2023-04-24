package com.enit.metier;

import java.util.List;

import com.enit.entities.Etudiant;
import com.enit.entities.Utilisateur;

import com.enit.entities.*;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Stateless(name="LO")
public class AuthentificationServiceImp implements AuthentificationServiceRemote, AuthentificationServiceLocal{
	@PersistenceContext(unitName  = "GestionRecVF")
	private EntityManager em;
	
	@Override
	public Utilisateur authentifier(String login, String pwd) {
		Query q=em.createQuery("SELECT u FROM Utilisateur u WHERE u.email=:login and u.password=:pwd");
		q.setParameter("login", login);
		q.setParameter("pwd", pwd);
		List<Utilisateur> l=q.getResultList();
		if(l.isEmpty())
		{
			return null;
		}
		else 
		{
			return l.get(0);
		}
	}

	@Override
	public boolean existeEmail(String login) {
		Query q=em.createQuery("select u from Utilisateur u where u.email = :login ");
		q.setParameter("login", login);
		List<Utilisateur> liste=q.getResultList();
		if(liste.isEmpty())
		{
			return false;
		}
		else 
		{
			return true;
		}
	}

	@Override
	public void sauvegarderUtilisateur(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Override
	public List<Etudiant> listerEtudiants() {
		
		Query q=em.createQuery("select u from Utilisateur u where type_utilisateur=ETUD");
		return q.getResultList();
	}
	
	
	@Override
	public Etudiant recupererEtudiant(String email) {
		Query q=em.createQuery("select u from Utilisateur u where u.email = :login ");
		q.setParameter("login", email);
		Etudiant e=(Etudiant)q.getResultList();
		return e;
		
	}
	@Override
	public void changerActif(int id) {
		Utilisateur u=em.find(Utilisateur.class,id);
		if(u.isActif()==true)
		{
			u.setActif(false);
		}
		else {
			u.setActif(true);
		}
	}
/*
	@Override
	public void ajouterEtudiant(Integer id, String nom, String prenom, String mail, String password, boolean actif) {
		// TODO Auto-generated method stub
		Etudiant u =new Etudiant();
		u.setActif(actif);
		u.setEmail(mail);
		u.setId(id);
		u.setPassword(password);
		u.setNom(prenom);
		u.setPrenom(prenom);
		em.merge(u);
	}*/
/*
	@Override
	public void ajouterAdmin(Integer id, String mail, String password, boolean actif) {
		Administrateur u =new Administrateur();
		u.setActif(actif);
		u.setEmail(mail);
		u.setPassword(password);
		u.setId(id);
		em.merge(u);
	}*/

}
