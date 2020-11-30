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
<!-- 	<div class="container"> -->
<!-- 	<h2>Page d'authentification</h2> -->

<!-- 	<form action="connexion" method="POST"> -->
<!-- 		<div class="form-group"> -->
<!-- 			<label class="bg-primary text-white" for="nom">Nom d'utilisateur</label>  -->
<!-- 			<input type=text id=email name=email> -->
<!-- 		</div> -->
<!-- 		 <div class="form-group"> -->
<!-- 			<label class="bg-primary text-white" for="prenom">Mot de passe</label>  -->
<!-- 			<input type=password id=password name=password> -->
<!-- 		</div> -->
<!-- 		<button class="btn btn-primary">Se connecter</button> -->
<!-- 	</form> -->
<div class="container">
  <h2>Login</h2>
  <form action="connexion" method="POST">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
	
</body>
</html>

