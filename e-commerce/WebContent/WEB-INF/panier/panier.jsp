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
	<!-- 	<div id="panier" > -->
	<%-- <%-- 		<c:if test="${panier.size!=0}"> --%>
	-
	<!-- 			<table> -->
	<!-- 				<td> -->
	<!-- 				<tr> -->
	<!-- 					<th colspan="1">Article</th> -->
	<!-- 					<th colspan="2">Designation</th> -->
	<!-- 					<th colspan="3">PrixUnitaire</th> -->
	<!-- 					<th colspan="4">QuantitéSelectionné</th> -->
	<!-- 					<th colspan="5">PrixTotal</th> -->
	<!-- 					<th></th> -->
	<!-- 					<th></th> -->
	<!-- 				</tr> -->
	<%-- 					<c:set var="total"	value="${0}"/> --%>
	<%-- 				<c:forEach items="${lignes}" var="article"> --%>
	<%-- 				${article}  --%>
	<!-- 					<tr> -->
	<%-- 					<td>${article.id}</td> --%>
	<%-- 						<td colspan="1"><img src="${article.produit.urlImage}" width="100" height="100" /></td> --%>
	<%-- 						<td colspan="2">${article.produit.designation}</td> --%>
	<%-- 						<td colspan="3">${article.produit.prixUnitaire}€</td>						  --%>
	<!-- 						<td colspan="4"><input type="number" value=${article.quantiteSelectionne} name="quantite" min="0" max="10" step="1" /></td> -->

	<%-- 						<td colspan="5"><c:set var="montant" value="${article.quantiteSelectionne*article.produit.prixUnitaire}"/> --%>

	<%-- 							<c:out value="${ montant }"></c:out> --%>
	<%-- 							<c:set var="total"	value="${ total + montant}"/>						 --%>
	<%-- 							<c:set var="nbArticle"	value="${nbArticle + article.quantiteSelectionne}"/>						 --%>

	<!-- 						</td>	 -->

	<!-- 					  	<td> -->
	<%-- 					  		<a href="deletePanier?id=${article.id}&action=deletePanier"> <i class="fas fa-trash-alt"></i>	 --%>
	<!-- 						</a> -->
	<!-- 						<td> -->
	<%-- 						<td><a href="updatePanier?id=${article.id}&action=updatePanier"> <i --%>
	<!-- 							class="fas fa-edit"></i></td> -->
	<!-- 								<td><a href="consultePanier?action=consultePanier"> <i class="fas fa-redo"></i></td> -->


	<!-- 					</tr> -->
	<%-- 				</c:forEach> --%>
	<!-- 				<tr>	 -->

	<%-- 				<td colspan="4">Nombre de articles:${size} </td><br>			 --%>
	<%--   	 			<td colspan="6">Total: ${total}€</td>  --%>



	<!-- 				</td> -->
	<!-- 				</tr> -->

	<!-- 			</table> -->
	<%-- <%-- 		</c:if> --%>

	<!-- </div> -->
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

						<td><a
							href="deletePanier?id=${article.id}&action=deletePanier"> <i
								class="fas fa-trash-alt"></i></a>
						<td>
						<td><a
							href="updatePanier?id=${article.id}&action=updatePanier"> <i
								class="fas fa-edit"></i></td>
						<!-- 						<td><a href="consultePanier?action=consultePanier"> Continue</i></td> -->

					</tr>
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
					<td><a href="consultePanier?action=consultePanier"
						class="button">CONTINUE SHOPPING</a></td>
					</th>
					<td><a href="commande?action=comande"
						class="button">PASSER COMMANDE</a></td>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>