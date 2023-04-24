<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interface Admin</title>
</head>
<body>
<input type="submit" name="logout" value="logout" class=""/>
 <h1>Liste des Etudiants</h1>
<table border="1" cellpadding="0" cellspacing="0"
      style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
    <tr bgcolor="">
        <td >ID</td>
        <td >Nom etudiant</td>
        <td >Prenom etudiant</td>
        <td >Email</td>
        <td >Statut</td>
        <td >Reclamations</td>
    </tr>
    
        
    <c:forEach items="${listeEtudiant }" var="etudiant">
      <tr>
        <td>${etudiant.id }</td>
        <td>${etudiant.prenom }</td>
        <td>${etudiant.nom }</td>
        <td>${etudiant.email}</td>
        <td>${etudiant.actif }</td>
        <td><button type="submit" name="action" value="changeStatus">Activer/Desactiver</button></td>
        
    </c:forEach>
    </table>
    
    <c:forEach items="${listeEtudiant }" var="etudiant">
   <h3>${etudiant.prenom } ${etudiant.nom } </h3> 
     <table border="1">
      <c:forEach items="${etudiant.reclamations }" var="rec">
      <tr>
        <td>${rec.id }</td>
        <td>${rec.description }</td>
        <td>${rec.titre}</td>
        <td>${rec.typeReclamation.type }</td>
         </c:forEach>
</table>
</c:forEach>
</body>
</html>