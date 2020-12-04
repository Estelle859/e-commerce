<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>**Edit Product Form**</h1>
	<div >
		<h2>Do you want to modify ${produit.designation} ?</h2>
		<form action="produit" method="POST" >
			<fieldset>
			
					<input type="hidden" name="action" value="update" /> 				
					<input type="hidden" id="id" name="id" value="${produit.id}" /> 
					<label 	for="designation">Designation : </label> 
					<input type="text" name="designation" 	value="${produit.designation}" id="designation" />				
					<label for="prixUnitaire">Prix Unitaire : </label>					
					<input type="text" name="prixUnitaire" value="${produit.prixUnitaire}" id="prixUnitaire" /> 					
					<label for="quantite">Quantite : </label> 
					<input type="text" name="quantite" value="${produit.quantiteStock}" id="quantite" />		
					<label for="urlImage">Url Image :</label>
					<textarea name="urlImage" rows="8" cols="40" class="editbody all-rounded">${requestScope.produit.urlImage}</textarea>
					<input type="hidden" name="urlImage" value="${produit.urlImage}" id="urlImage" class="editid hidden" />
					<label for="selection">Selectionne : </label> 
					<input type="text" name="selectionne" value="${produit.selectionne}" id="selectionne" />		
					<input type="submit" name="submit" value="Modifier" id="submit" />
					<a	href="produit">Cancel</a>						
			</fieldset>
		</form>
	</div>
</body>
</html>