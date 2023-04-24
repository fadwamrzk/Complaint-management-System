package com.enit.controller;


import java.io.IOException;
import com.enit.metier.*;
import com.enit.entities.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(name="cs",urlPatterns= {"/signup","/First.do"})
public class EnitServlet extends HttpServlet {
	ServletContext context ;
	@EJB private AuthentificationServiceLocal metAuthentifaction;
	@EJB private ReclamationServiceLocal metReclamation;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	context=request.getSession().getServletContext();
		String chemin = request.getServletPath();
		String action = request.getParameter("action");
		if (action!=null){
		
		if (action.equals("logout")) {
			HttpSession session = request.getSession();
			request.getRequestDispatcher("First.jsp").forward(request, response);
			
		}
		
		if (action.equals("changeStatus")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			Etudiant e=(Etudiant)metAuthentifaction.authentifier(email, password);
			metAuthentifaction.changerActif(e.getId());
			
			metAuthentifaction.sauvegarderUtilisateur(e);
			context.setAttribute("listeEtudiant",metAuthentifaction.listerEtudiants());
		
			request.getRequestDispatcher("etudiant.jsp").forward(request, response);
			
		}
		
		}
		if (chemin.equals("/signup")) {
			request.getRequestDispatcher("Signup.jsp").forward(request,response);

		}
		else if (chemin.equals("/First.do") ) {
			request.getRequestDispatcher("First.jsp").forward(request,response);

		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action=request.getParameter("action"); 
		if (action.equals("Sign Up")){
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			boolean result =metAuthentifaction.existeEmail(email);
			
			if(result==true)
			{
				Etudiant e = new Etudiant(email,password,true,nom,prenom);	
				metAuthentifaction.sauvegarderUtilisateur(e);		
				HttpSession session = request.getSession();
				request.getRequestDispatcher("etudiant.jsp").forward(request, response);
			}
			else{
				HttpSession session = request.getSession();
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		
		else if (action.equals("Sign In")){
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			Utilisateur user = metAuthentifaction.authentifier(email, password);
			
			if(user !=null){
				if(user.getClass() == Etudiant.class){
				    Etudiant etu=(Etudiant)user;
					session.setAttribute("mesReclamations", metReclamation.listerReclamationParEtudiant(etu));
					request.getRequestDispatcher("etudiant.jsp").forward(request,response);
					

				}
				
				else if(user.getClass() == Administrateur.class){
					session.setAttribute("listeEtudiant", metAuthentifaction.listerEtudiants());
					request.getRequestDispatcher("admin.jsp").forward(request,response);
				}
			}
			
			else{
				request.getRequestDispatcher("First.jsp").forward(request,response);
			}
		}
		
		else if (action.equals("enrigistrer réclamation")){
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			Etudiant etu=metAuthentifaction.recupererEtudiant(email);
			String type = request.getParameter("type");
			String titre = request.getParameter("titre");
			String description = request.getParameter("description");
			
			if(metReclamation.existeTypeReclalamtion(type)) {
				TypeReclamation typ = metReclamation.chercherTypeReclamationParType(type);
				
				Reclamation rec= new Reclamation(etu,titre, description, typ);
				metReclamation.ajouterReclamation(rec);
							}
			else {
				TypeReclamation typ = new TypeReclamation(type);
				metReclamation.ajouterTypeReclamation(typ);
				
				Reclamation rec= new Reclamation(etu,titre, description, typ);
				metReclamation.ajouterReclamation(rec);
			}
			request.getRequestDispatcher("etudiant.jsp").forward(request,response);
			
			}
		
		
		
		
	}
}
