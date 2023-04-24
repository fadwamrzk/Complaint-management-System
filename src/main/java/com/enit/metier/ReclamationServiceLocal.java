package com.enit.metier;

import jakarta.ejb.Local;
import com.enit.entities.Reclamation;
import com.enit.entities.TypeReclamation;
import java.util.List;

import com.enit.entities.Etudiant;


@Local
public interface ReclamationServiceLocal {
	void ajouterReclamation(Reclamation reclamation);
	void ajouterTypeReclamation(TypeReclamation typeReclamation);
	List<Reclamation> listerReclamations();
	List<TypeReclamation> listerTypeReclamations();
	boolean existeTypeReclalamtion(String type);
	TypeReclamation chercherTypeReclamationParType(String type);
	List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);
}
