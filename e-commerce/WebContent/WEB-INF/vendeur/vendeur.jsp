<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/shared/bs.jsp"></c:import>
<title>Page du Vendeur</title>
</head>
<body>
	<header>
		<c:import url="/WEB-INF/shared/header.jsp"></c:import>
	</header>

	<nav class="navbar navbar-inverse navbar-fixed-top">
<!-- 		<p>Ajouter: -->
<!--         <a href="#" class="btn btn-info btn-lg"> -->
<!--           <span class="glyphicon glyphicon-plus"></span> Plus  -->
<!--         </a> -->
<!--       </p>    -->
		<c:import url="/WEB-INF/shared/nav.jsp"></c:import>
	</nav>
	<main>
	<c:import url="/WEB-INF/produit/listProduit.jsp"></c:import>
<!-- 		<h2>Gestion des Produits :</h2> -->
<!-- 		<section> -->
<!-- 			<table> -->
<%-- 				<td><a href="produit?id=${produit.id}&action="${ action }"> --%>
<!-- 						<img src="images/addbut.jpeg" width="50" /></td> -->
<!-- 				<tr> -->
<!-- 					<th>Designation</th> -->
<!-- 					<th>PrixUnitaire</th> -->
<!-- 					<th>Categorie</th> -->
<!-- 					<th></th> -->
<!-- 					<th></th> -->
<!-- 				</tr> -->

<%-- 				<c:forEach items="${ produits }" var="element"> --%>
<!-- 					<tr> -->
<%-- 						<td>${element.designation}</td> --%>
<%-- 						<td>${element.prixUnitaire}</td> --%>
<%-- 						<td>${element.categorie}</td> --%>
<%-- 						<td><a href="produit?id=${produit.id}&action="${ action }"> --%>
<!-- 								<img src="images/delbut.jpeg" width="50" /></td> -->
<%-- 						<td><a href="produit?id=${produit.id}&action="${ action }"> --%>
<!-- 								<img src="images/butMod.jpeg" width="50" /></td> -->
<!-- 					</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</table> -->

<!-- 		</section> -->
	</main>
	<footer>
<%-- 		<c:import url="/WEB-INF/shared/footer.jsp"></c:import> --%>
	</footer>
</body>
</html>