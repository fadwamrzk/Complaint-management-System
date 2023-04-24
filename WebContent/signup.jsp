<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
					<form method="post" action="" class="">
					<h3>Create Your account</h3>
					<input class="" type="text" name="nom" placeholder="Firstname" required>
					<input class="" type="text" name="prenom" placeholder="Lastname" required>
					<input class="" type="email" name="email" placeholder="Email@gmail.com" required>
					<input class="" type="password" name="password" placeholder="Password" required>
					<input type="submit" name="signin" value="Sign in" class=""/>
					
					<div class="text-center p-t-90">
						<h3>You are a new student here? </h3>
						<a href = "signup">Sign Up</a>
					</div>
					
				</form>
</body>
</html>