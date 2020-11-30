
<div class="container">
	<table class="table table-bordered table-hover">
		<thead>
			<td><a href="produit?id=${produit.id}&action=add"> <i
					class="fa fa-plus-square"></i>
					<tr>
						<th>Designation</th>
						<th>PrixUnitaire</th>
						<th>Quanté en stock</th>
					</tr>
		</thead>
		<tbody>
			<c:forEach items="${ produits }" var="element">
				<tr>
					<td>${element.designation}</td>
					<td>${element.prixUnitaire}</td>
					<td>${element.quantiteStock}</td>

					<td><a href="produit?id=${element.id}&action=delete"> <i
							class="fa fa-minus-square"></i></td>
					<td><a href="produit?id=${element.id}&action=update"> <i
							class="fas fa-edit"></i></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	
