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
	<h2>Gestion de Produits</h2>
	<h3>
		Operation:
		<c:out value="${ operation }"></c:out>
	</h3>
	<section>
		<table>
			<td><a href="produit?id=${produit.id}&action=add"> <i
					class="fa fa-plus-square"></i>
					<tr>
						<th>Designation</th>
						<th>PrixUnitaire</th>
						<th>Categorie</th>
						<th></th>
						<th></th>
					</tr> <c:forEach items="${ produits }" var="element">
						<tr>
							<td>${element.designation}</td>
							<td>${element.prixUnitaire}</td>
							<td>${element.categorie}</td>
							<td><a href="produit?id=${element.id}&action=remove"> <i
									class="fa fa-minus-square"></i></td>
							<td><a href="produit?id=${element.id}&action=edit"> <i
									class="fas fa-edit"></i></td>

						</tr>
					</c:forEach>
		</table>
</body>
</html>