<div class="container">
	<h2>Consulter des Articles :</h2>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Designation</th>
				<th>PrixUnitaire</th>
				<th>Quanté en stock</th>
				<th>Ajouter au Panier</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ produits }" var="element">
				<tr>
					<td>${element.designation}</td>
					<td>${element.prixUnitaire}</td>
					<td>${element.quantiteStock}</td>
					<img width="50" src="images/tag.jpg" alt="" />
					<td><a href="article?id=${element.id}"><i
							class="fas fa-cart-plus"></i></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>