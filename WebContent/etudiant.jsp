<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interface Etudiant</title>
</head>
<body>
 <h1>Mes Réclamations</h1>
 <table border="1" cellpadding="0" cellspacing="0"
      style="border-collapse: collapse" bordercolor="#111111"
      width="62%" id="AutoNumber1">
    <tr bgcolor="">
        <td >Titre de la Réclamation</td>
        <td >Type de la Réclamation</td>
        <td >Description de la Réclamation</td>
    </tr>
    
    
<c:forEach var="r" items="${mesReclamations}" >
  <tr>
      <td ><c:out value="${c.titre}"/></td>
      <td ><c:out value="${c.typeReclamation.type}"/></td>
      <td ><c:out value="${c.description}"/></td>
  </tr>
</c:forEach> 
</table>

<h3>Ajouter une Réclamation?</h3>
					<form method="post" action="" class="">
					<label for="email">Email</label>
					<input class="" type="email" name="email" placeholder="Your Email Please" required >
					
					<label for="titre">Titre</label>
					<input class="" type="text" name="titre" placeholder="Titre" required>
					
					<label for="type">Type</label>
                    <input type="text" placeholder="Type de reclamation" name="type" required>
    
					<label for="description">Description</label>
					<input class="" type="text" name="description" placeholder="Description" required>
					
                    <input type="submit" name="ajouterRec" value="ajouter Réclamation" class=""/>
				</form>
				
</body>
</html>