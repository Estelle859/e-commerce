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
		<h2>Do you want to modify ${requestScope.produit.designation} ?</h2>
		<form action="produit" method="POST" >
			<fieldset>
			
					<input type="hidden" name="action" value="edit" /> 				
					<input type="hidden" id="id" name="id" value="${requestScope.produit.id}" /> 
					<label 	for="designation">Designation : </label> 
					<input type="text" name="designation" 	value="${requestScope.produit.designation}" id="designation" />
				    <label for="categorie">Category :</label> 
					<select name="categorie" id="categorie">
						<c:forEach items="${requestScope.categories}" var="categorie">
							<option value="${categorie.idCate}">${categorie.nomCategorie}</option>
						</c:forEach>
					</select> 						
					<label for="prixUnitaire">Prix Unitaire : </label>					
					<input type="text" name="prixUnitaire" value="${requestScope.produit.prixUnitaire}" id="prixUnitaire" /> 
					
					<label for="quantite">Quantite : </label> 
					<input type="text" name="quantite" value="${requestScope.produit.quantite}" id="quantite" />		
					<label for="urlImage">Url Image :</label>
					<textarea name="urlImage" rows="8" cols="40" class="editbody all-rounded">${requestScope.produit.urlImage}</textarea>
					<input type="hidden" name="urlImage" value="${requestScope.produit.urlImage}" id="urlImage" class="editid hidden" />
					<input type="submit" name="submit" value="${operation }" id="submit" />
					<a	href="produit">Cancel</a>					
					
			</fieldset>
		</form>
	</div>
</body>
</html>