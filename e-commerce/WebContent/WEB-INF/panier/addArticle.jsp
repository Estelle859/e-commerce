
<h3>Vouler ajouter une nouvelle article ?</h3>

<form action="addLignePanier" method="POST">
	<label for="id">Identifiant : </label><input type="number" name="id"
		id="id"><br> <label for="nom">Designation : </label><input
		type="text" name="designation" id="designation"><br> <label
		for=quantite">QuantiteSelectionne : </label> <input type="number"
		name="quantite" id="quantite"><br>
	<button>Ajouter au panier</button>
</form>







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