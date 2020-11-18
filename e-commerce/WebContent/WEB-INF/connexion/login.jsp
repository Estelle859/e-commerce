<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Pizza</title>
</head>
<body>
	<div class="container">
	<h2>Page d'authentification</h2>

	<form action="connexion" method="POST">
		<div class="form-group">
			<label class="bg-primary text-white" for="nom">Nom
				d'utilisateur</label> <input type=text id=nom name=nom>
		</div>
		 <div class="form-group">
			<label class="bg-primary text-white" for="prenom">Mot de
				passe</label> <input type=password id=prenom name=prenom>
		</div>
		<button class="btn btn-primary">Se connecter</button>
	</form>
</body>
</html>

