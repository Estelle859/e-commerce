<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <c:import url="/WEB-INF/shared/bs.jsp"></c:import> --%>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/a6c393237d.js"></script>
	<script src="InputSpinner.js"></script>
<title>Article Page</title>
</head>
<body>
<!-- 	<header> -->
<%-- 		<c:import url="/WEB-INF/shared/header.jsp"></c:import> --%>
<!-- 	</header> -->

	<nav class="navbar navbar-inverse">
<%-- 		<c:import url="/WEB-INF/shared/navcli.jsp"></c:import> --%>

  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Easy Shop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="produit">Products</a></li>
         <li><a href="connexion">Services</a></li>
      <li><a href="contact">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="panier"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </ul>
  </div>
	</nav>
	<main>
		<div class="container">
		 <h2>Article Selected :</h2>										     	
       	 <div>${article.designation}</div>       	  
         <a href="element?id=${article.id}"> <img  src=${article.urlImage}  
       	 alt="imagearticle"  width="400" height="400">		   
	   	<td> prix : ${article.prixUnitaire}€</td>
	   	<td> quantite : <input type="number" value="1" min="0" max="10" step="1"></td>
	   	<td><a href="panier?id=${article.id}&qte="demo"&action=add"><i class="fas fa-cart-plus"></i></td>
		
		</div>
	</main>
</body>

</body>
</html>