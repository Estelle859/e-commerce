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
		<c:import url="/WEB-INF/shared/nav.jsp"></c:import>
	</nav>
		<main>
<!-- <div class="container"> -->
<%-- 	<%-- 		<c:if test="${ !fn:contains(operation, 'Ajouter') }"> --%> --%>

<%-- 	<%-- 		</c:if> --%> --%>
<%-- 	<c:if test="${ !fn:contains(operation, 'Supprimer') }"> --%>
<%-- 		<form method="POST" action="${ action }"> --%>

<!-- 			<div class="form-group row"> -->
<!-- 				<label for="designation" class="col-sm-2 col-form-label">Designation</label> -->
<!-- 				<div class="col-sm-10"> -->
<!-- 					<input type="designation" class="form-control" id="designation" -->
<!-- 						placeholder="Designation du Produit"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group row"> -->
<!-- 				<label for="prixUnitaire" class="col-sm-2 col-form-label">Prix Unitaire</label> -->
<!-- 				<div class="col-sm-10"> -->
<!-- 					<input type=type= "text" class="form-control" id="prixUnitaire" placeholder="Prix Unitaire"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group row"> -->
<!-- 				<label for="quantiteStock" class="col-sm-2 col-form-label">Quantite -->
<!-- 					En Stock</label> -->
<!-- 				<div class="col-sm-10"> -->
<!-- 					<input type=type= "text" class="form-control" id="quantiteStock" -->
<!-- 						placeholder="Quantite En Stock"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group row"> -->
<!-- 				<label for="urlImage" class="col-sm-2 col-form-label">url -->
<!-- 					d'Image</label> -->
<!-- 				<div class="col-sm-10"> -->
<!-- 					<input type="urlImage" class="form-control" id="urlImage" -->
<!-- 						placeholder="url d'Image"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group row"> -->
<!-- 				<div class="col-sm-10 offset-sm-2"> -->
<!-- 					<label for="selectionne">ProduitSelectionne</label> <input -->
<!-- 						type="number" id="selectionne" name="selectionne" min="0" max="1"> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<div class="form-group row"> -->
<!-- 				<div class="col-sm-10 offset-sm-2"> -->
<%-- 					<button type="submit" class="btn btn-primary"  >${operation }</button> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</form> -->
<%-- 	</c:if> --%>
<!-- </div> -->
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
			<label  for="prixUnitaire">PrixUnitaire:</label>
			
				<input type="number" name="prixUnitaire" class="form-control" id="prixUnitaire"
					placeholder="Enter prixUnitaire">
			</div>
		 
			<div class="form-group">
			<label  for="quantiteStock">Quantite:</label>
			
				<input type="number" name="quantiteStock" class="form-control" id="quantiteStock"
					placeholder="Enter quantite">
			</div>
			<div class="form-group">
			<label  for="urlImage">Url Image:</label>			
				<input type="text" name="urlImage" class="form-control" id="urlImage"
					placeholder="Enter urlImage">
			<div class="form-group">
					<label for="selectionne">ProduitSelectionne</label> 
					<input type="number" id="selectionne" name="selectionne"
					 placeholder="Enter urlImage"   class="form-control" min="0" max="1"> 
 			</div> 	
		<div>
			<input type="submit" name="submit" value="Ajouter" id="submit" class="btn btn-default" /> 
		</div>
		  
		</form>
	</div>
	</main>
<!-- 	<footer> -->
<%-- 		<c:import url="/WEB-INF/shared/footer.jsp"></c:import>  --%>
<!-- 	</footer> -->
</body>
</html>