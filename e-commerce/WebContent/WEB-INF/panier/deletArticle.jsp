<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SuppressionLignes</title>
</head>
<body>
	<header>		
		<c:import url="../shared/header.jsp"></c:import>
	</header>
	<main>
	<h3>Nos Articles</h3>
		<ul>
			<c:forEach items="${ lignes }" var="element">
				<li>
					<form action="supprimerLigne" method="POST">
						<input type="hidden" name="id" value="${ element.id }">
						<c:out value="${ element.nom } : ${ element.type }"></c:out>
						<button>supprimer</button>
					</form>
				</li>
			</c:forEach>
		</ul>
	</main>
</body>
</html>