<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <c:import url="/WEB-INF/shared/bs.jsp"></c:import>

</head>
<body>

	<jsp:include page="/WEB-INF/shared/header.jsp" />
	<jsp:include page="/WEB-INF/shared/nav.jsp" />
	<section>
		<h1>Decouvrez notre sélection des produits :</h1>
		<table>
			<br>
			<c:forEach items="${ produits }" var="element">
				<tr>
					<td>${element.designation}</td>
					<td>${element.prixUnitaire}</td>
					<td>${element.categorie}</td>
				</tr>
			</c:forEach>

		</table>
	</section>
	<jsp:include page="/WEB-INF/shared/footer.jsp" />
</body>

</html>