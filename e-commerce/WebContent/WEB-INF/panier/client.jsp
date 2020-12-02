<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/shared/bs.jsp"></c:import>
<title>Page du Client</title>
</head>
<body>
	<header>
		<c:import url="/WEB-INF/shared/header.jsp"></c:import>
	</header>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<c:import url="/WEB-INF/shared/nav.jsp"></c:import>
	</nav>
	<main>
		<c:import url="/WEB-INF/panier/consulte.jsp"></c:import>
	</main>
	<footer>
				<c:import url="/WEB-INF/shared/footer.jsp"></c:import>
	</footer>
</body>
</html>