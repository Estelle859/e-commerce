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


<title>Page de Panier</title>
</head>
<body>
	<h2>Mon Panier</h2>
	<table>
		<td><c:forEach items="${ lignes }" var="element">
				<tr>
					<td><img src=${element.produit.urlImage }"/></td>
					<td>${element.produit.designation}</td>
					<td>${element.produit.prixUnitaire}</td>
					<td>${element.quantite}</td>
					<td><input type="number" value="1" min="0" max="10" step="1" /></td>
					
				  	<td>
					<button type="button" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-trash"></span>
					</button>
					</td>
<%-- 					<a href="panier?id=${element.id}&action=remove"> --%>
				</tr>
			</c:forEach>
	</table>
</body>
</html>