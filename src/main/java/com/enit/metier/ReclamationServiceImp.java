package com.enit.metier;

import java.util.List;
import com.enit.entities.Etudiant;
import com.enit.entities.Reclamation;
import com.enit.entities.TypeReclamation;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name="RO")
public class ReclamationServiceImp implements ReclamationServiceLocal, ReclamationServiceRemote {
	@PersistenceContext(unitName = "GestionRecVF")
	private EntityManager em;
	
	@Override
	public void ajouterReclamation(Reclamation reclamation) {
		em.persist(reclamation);
	}

	@Override
	public void ajouterTypeReclamation(TypeReclamation typeReclamation) {
		em.persist(typeReclamation);
	}

	@Override
	public List<Reclamation> listerReclamations() {
		Query q=em.createQuery("select r from Reclamation r");
		return q.getResultList();
	}

	@Override
	public List<TypeReclamation> listerTypeReclamations() {
		Query q=em.createQuery("select tr from TypeReclamation tr");
		return q.getResultList();
	}

	@Override
	public boolean existeTypeReclalamtion(String type) {
		Query q=em.createQuery("select tr from TypeReclamation tr where tr.TYPE=:typeReclamation");
		q.setParameter("typeReclamation", type);
		if (q==null)
		{return false;}
		else {return true;}
	}

	@Override
	public TypeReclamation chercherTypeReclamationParType(String type) {
		Query q=em.createQuery("select tr from TypeReclamation tr where tr.TYPE=:typeReclamation");
		q.setParameter("typeReclamation", type);
		return (TypeReclamation) q.getSingleResult();
	}

	@Override
	public List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant) {
		Query q=em.createQuery("select r from Reclamation r where E_ID= :idEtudiant");
		q.setParameter("idEtudiant", etudiant.getId());
		return q.getResultList();
	}

}
