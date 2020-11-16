<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/a6c393237d.js"></script>     

	<title>Home Page</title>
</head>	
	 <body>
	 	<header>		
			<c:import url="/WEB-INF/shared/header.jsp"></c:import>			
		</header>
		<nav>
			<c:import url="/WEB-INF/shared/nav.jsp"></c:import>
		</nav>
		<main>
			 <section>   
	            <h1>Liste des Produits :</h1>
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
		</main>
		<footer>
		<c:import url="WEB-INF/connexion/login.jsp"></c:import>
		<c:import url="WEB-INF/shared/footer.jsp"></c:import>		
		</footer>  
			   
	   </body>
</html>