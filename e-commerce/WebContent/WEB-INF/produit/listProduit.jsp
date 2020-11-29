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
<title>My Product Page</title>
</head>
<body>
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
	<div class="container">
		<c:if test="${ !fn:contains(operation, 'Ajouter') }">
			
		</c:if>
		<c:if test="${ !fn:contains(operation, 'Supprimer') }">
		<form method="POST" action="${ action }">
	
		
				<div class="form-group row">
					<label for="designation" class="col-sm-2 col-form-label">Designation</label>
					<div class="col-sm-10">
						<input type="designation" class="form-control" id="designation"
							placeholder="Designation du Produit">
					</div>
				</div>
				<div class="form-group row">
					<label for="prixUnitaire" class="col-sm-2 col-form-label">Prix
						Unitaire</label>
					<div class="col-sm-10">
						<input type=type= "number" class="form-control" id="prixUnitaire"
							placeholder="Prix Unitaire">
					</div>
				</div>
				<div class="form-group row">
					<label for="quantiteStock" class="col-sm-2 col-form-label">Quantite
						En Stock</label>
					<div class="col-sm-10">
						<input type=type= "number" class="form-control" id="quantiteStock"
							placeholder="Quantite En Stock">
					</div>
				</div>
				<div class="form-group row">
					<label for="urlImage" class="col-sm-2 col-form-label">url
						d'Image</label>
					<div class="col-sm-10">
						<input type="urlImage" class="form-control" id="urlImage"
							placeholder="url d'Image">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-10 offset-sm-2">
						<label for="selectionne">ProduitSelectionne</label> <input
							type="number" id="selectionne" name="selectionne" min="0" max="1">
					</div>
				</div>
			
			<div class="form-group row">
				<div class="col-sm-10 offset-sm-2">
					<button type="submit" class="btn btn-primary">${operation }</button>
				</div>
			</div>
		</form>
		</c:if>
	</div>
</body>
</html>