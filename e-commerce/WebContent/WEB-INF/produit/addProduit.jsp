<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/shared/bs.jsp"></c:import>
<title>Ajouter Produit</title>
</head>
<body>
	<div class="container">
		<h2>Form Add Product </h2>
		<form method="POST" action="produit">
			<input type="hidden" name="action" value="add" />
			<div class="form-group">
				<label for="designation">Desination:</label>
				<input type="designation" class="form-control" id="designation" placeholder="Enter designation"
					name="designation">
			</div>
			<div class="form-group">
				<label for="categorie">Categorie:</label>
			
			 	<select name="categorie" id="categorie" class="form-control" >
			 		<c:forEach items="${requestScope.categories}" var="categorie">
						<option value="${categorie.idCate}">${categorie.nomCategorie}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
			<label  for="prixUnitaire">PrixUnitaire:</label>
			
				<input type="text" name="prixUnitaire" class="form-control" id="prixUnitaire"
					placeholder="Enter prixUnitaire">
			</div>
		 
			<div class="form-group">
			<label  for="quantite">Quantite:</label>
			
				<input type="text" name="quantite" class="form-control" id="quantite"
					placeholder="Enter quantite">
			</div>
			<div class="form-group">
			<label  for="urlImage">Url Image:</label>			
				<input type="text" name="urlImage" class="form-control" id="urlImage"
					placeholder="Enter urlImage">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	<div>
		<table class="table table-inverse">
			 <thead>
		 		<tr>
		 			<th>Numero</th>
					<th>Designation</th>
					<th>PrixUnitaire</th>
					<th>Categorie</th>
					<th>Quantité</th>
					<th>UrlImage</th>
				</tr>
			 
			 </thead>
			<tbody>
			   
				<c:forEach items="${ produits }" var="element">
				
					<tr>
						
						<td>${element.designation}</td>
						<td>${element.prixUnitaire}</td>
						<td>${element.categorie}</td>
						<td>${element.quantite}</td>
						<td>${element.urlImage}</td>
						
					</tr>
				</c:forEach>
			</tbody>	
		</table>
	</div>
			
</body>
</html>