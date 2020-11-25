<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a6c393237d.js"></script>
<script src="./src/bootstrap-input-spinner.js"></script>


<title>Panier View Page</title>
</head>
<body>
<h3>voir mon panier</h3>
	<div id="panier" >
		<c:if test="${panier.size!=0}">
			<table>
				<td>
				<tr>
					<th colspan="1">Article</th>
					<th colspan="2">Designation</th>
					<th colspan="3">PrixUnitaire</th>
					<th colspan="4">Quantité</th>
					<th colspan="5">PrixTotal</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${lignes}" var="article">
					<tr>
						<td colspan="1"><img src=${article.produit.urlImage} width="100" height="100" /></td>
						<td colspan="2">${article.produit.designation}</td>
						<td colspan="3">${article.produit.prixUnitaire}€</td>
						<!-- 					<td><input type="number" value="1" min="0" max="10" step="1" /></td>  -->
						<td colspan="4">${article.quantiteCommande}</td>
						<td colspan="5">${article.quantiteCommande*article.produit.prixUnitaire}</td>
						<%-- 				  	<td><a href="panier?id=${element.produit.id}&action=remove"> <i class="fas fa-trash-alt"></i>	 --%>

					</tr>
				</c:forEach>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td colspan="4">Nombre de articles:</td>
				<td>${panier.size}</td>
				<td colspan="5">Total:</td>
				<td>${panier.total}</td>

				</td>

			</table>
		</c:if>
	</div>
	<div id="produits">
		<c:forEach items="${produits}" var="produit">
			<div class="ficheproduit">
				<table>

					<tr>
						<td colspan="2"><img src="urlImage?id=${produit.id}"
							width="100" height="100" /></td>
					</tr>
					<tr>
						<td>Designation :</td>
						<td>${produit.designation}</td>
					</tr>
					<tr>
						<td>PrixUnitaire :</td>
						<td>${produit.prixUnitaire}</td>
					</tr>
					<tr>
						<td>Quantite Stock :</td>
						<td>${produit.quantiteStock}</td>
					</tr>

					<tr>
						<td colspan="2">
							<form action="panier">
								<input type="hidden" value="${produit.id}" name="id"> <input
									type="text" value="1" name="quantite"> <input
									type="submit" value="Ajouter au Panier">
							</form>
						</td>
					</tr>
				</table>
		</c:forEach>

	</div>
</body>
</html>