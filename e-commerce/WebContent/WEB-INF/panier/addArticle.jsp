<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Production</title>
</head>
<body>
	<header>		
		<c:import url="../shared/header.jsp"></c:import>
	</header>
	<main>
		<h3>Article déjà disponibles</h3>
		<ul>
			<c:forEach items="${ lignes }" var="element">
				<li><c:out value="${ element.produit.designation } : ${ element.quantiteSelectionne }"></c:out>
				</li>
			</c:forEach>
		</ul>
		<hr />
		<h3>Préparer une nouvelle pizza ?</h3>

		<form action="addLignePanier" method="POST">
			<label for="id">Identifiant : </label><input type="number" name="id"
				id="id"><br> <label for="nom">Designation : </label><input
				type="text" name="designation" id="designation"><br> 
				<label for=quantite">QuantiteSelectionne : </label>
				<input type="number" name="quantite" id="quantite"><br>
			<button>Ajouter au panier</button>
		</form>

	</main>
</body>
</html>


<!-- 	<div id="produits"> -->
<%-- 		<c:forEach items="${produits}" var="produit"> --%>
<!-- 			<div class="ficheproduit"> -->
<!-- 				<table> -->

<!-- 					<tr> -->
<%-- 						<td colspan="2"><img src="urlImage?id=${produit.id}" --%>
<!-- 							width="100" height="100" /></td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Designation :</td> -->
<%-- 						<td>${produit.designation}</td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>PrixUnitaire :</td> -->
<%-- 						<td>${produit.prixUnitaire}</td> --%>
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>Quantite Stock :</td> -->
<%-- 						<td>${produit.quantiteStock}</td> --%>
<!-- 					</tr> -->

<!-- 					<tr> -->
<!-- 						<td colspan="2"> -->
<!-- 							<form action="panier"> -->
<%-- 								<input type="hidden" value="${produit.id}" name="id"> <input --%>
<!-- 									type="text" value="1" name="quantite"> <input -->
<!-- 									type="submit" value="Ajouter au Panier"> -->
<!-- 							</form> -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<%-- 		</c:forEach> --%>

<!-- 	</div> -->