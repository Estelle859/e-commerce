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
	<h3>Detail de votre Panier :</h3>	
	<div class="container">

		<p></p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Article N°</th>
					<th></th>
					<th>Designation</th>
					<th>PrixUnitaire</th>
					<th>QuantitéSelectionné</th>
					<th>PrixTotal</th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<c:set var="total" value="${0}" />
				<c:forEach items="${articles}" var="article">
					<tr>
						<td>${article.id}</td>
						<td><img src="${article.produit.urlImage}" width="100"
							height="100" /></td>
						<td>${article.produit.designation}</td>
						<td>${article.produit.prixUnitaire}€</td>
						<td><input type="number"
							value=${article.quantiteSelectionne
							} name="quantite"
							min="0" max="10" step="1" /></td>

						<td><c:set var="montant"
								value="${article.quantiteSelectionne*article.produit.prixUnitaire}" />

							<c:out value="${ montant }"></c:out> <c:set var="total"
								value="${ total + montant}" /> <c:set var="nbArticle"
								value="${nbArticle + article.quantiteSelectionne}" /></td>

				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th></th>
					<th></th>
					<th>
					<td>Nbr articles:${size}</td>
					</th>
					<th>
					<td>Total: ${total} €</td>
					</th>
					<th>
					<td><a href="valider?action=valider"
						class="button">VALIDER</a></td>
					</th>
				
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>