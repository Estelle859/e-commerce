<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/shared/bs.jsp"></c:import>
<title>Home Page</title>
</head>
<body>
	<header>
		<c:import url="/WEB-INF/shared/header.jsp"></c:import>
	</header>

	<nav class="navbar navbar-inverse ">
		<c:import url="/WEB-INF/shared/nav.jsp"></c:import>
	</nav>
	<main>
	<div class="container">
 	<div class="row">
    <div class="col-12">
		<table class="table table-image">
		  <thead>
		    <tr>
		      
		      <th scope="col">Image</th>
		      <th scope="col">Article Name</th>
		      <th scope="col">PrixUnitaire</th>		  
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${ produits }" var="element">
		    <tr>
		      <th scope="row">1</th>
		      <td class="w-25">
			      <img src=${element.urlImage} class="img-fluid img-thumbnail" alt="Sheep">
		      </td>		   
		   	  <td>${element.designation}</td>
		      <td>${element.prixUnitaire}</td>
		    </tr>
		    </c:forEach>

	
		
		  </tbody>
		</table>   
    </div>
  </div>
</div>
	</main>

<!-- 	<main> -->
<!-- 		<div class="container"> -->
<!-- 			<h2>Liste des Produits :</h2> -->
<!-- 			<table class="table table-bordered table-hover"> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<!-- 						<th>Numero</th> -->
<!-- 						<th>Designation</th> -->
<!-- 						<th>PrixUnitaire</th> -->
<!-- 						<th>Categorie</th> -->
<!-- 						<th>Quantité</th> -->
<!-- 						<th>UrlImage</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody> -->
<%-- 					<c:forEach items="${ produits }" var="element"> --%>
<!-- 						<tr> -->
<%-- 							<td>${element.id}</td> --%>
<%-- 							<td>${element.designation}</td> --%>
<%-- 							<td>${element.prixUnitaire}</td> --%>
<%-- 							<td>${element.categorie}</td> --%>
<%-- 							<td>${element.quantite}</td> --%>
<%-- 							<td>${element.urlImage}</td> --%>
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<!-- 				</tbody> -->
<!-- 			</table> -->
<!-- 		</div> -->
<!-- 		<!-- 		<div class="container"> --> -->
<!-- 		<!--  		    <p>Search icon on a styled button: --> -->
<!-- 		<!-- 	        	<button type="button" class="btn btn-info"> --> -->
<!-- 		<!-- 	          	<span class="glyphicon glyphicon-search"></span> Search --> -->
<!-- 		<!-- 	        	</button> --> -->
<!-- 		<!--       		</p> --> -->
<!-- 		<!-- 		</div> --> -->
<!-- 		<!-- 			 <section>    --> -->
<!-- 		<!-- 	            <h1>Liste des Produits :</h1> --> -->
<!-- 		<!-- 	                <table>       --> -->
<!-- 		<!-- 	                    <br> --> -->
<%-- 		<%-- 	                    <c:forEach items="${ produits }" var="element">                   --%> --%>
<!-- 		<!-- 	                         <tr> --> -->
<%-- 		<%-- 	                             <td>${element.designation}</td> --%> --%>
<%-- 		<%-- 	                              <td>${element.prixUnitaire}</td> --%> --%>
<%-- 		<%-- 	                              <td>${element.categorie}</td>                                                                       --%> --%>
<!-- 		<!-- 	                         </tr>                                         --> -->
<%-- 		<%-- 	                    </c:forEach>                                         --%> --%>
<!-- 		<!-- 	                </table>        --> -->
<!-- 		<!-- 	        </section> --> -->
<!-- 	</main> -->
<!-- 	<footer> -->
		<c:import url="/WEB-INF/shared/footer.jsp"></c:import>
	</footer>

</body>
</html>