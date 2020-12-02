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
	<h1>**Edit Article  Form**</h1>
	<div >
		<h2>Do you want to modify ${ligne.quantiteSelectionne} ?</h2>
		<form action="panier" method="POST" >
			<fieldset>
			
					<input type="hidden" name="action" value="update" /> 				
					<input type="hidden" id="id" name="id" value="${ligne.id}" /> 					
					
					<label for="quantiteSelectionne">Quantite Selectionne : </label> 
					<input type="text" name="quantiteSelection" value="${ligne.quantiteSelectionne}" id="quantiteSelection" />		
					
					
					<input type="submit" name="submit" value="Modifier" id="submit" />
					<a	href="panier">Cancel</a>					
					
			</fieldset>
		</form>
	</div>
</body>
</html>