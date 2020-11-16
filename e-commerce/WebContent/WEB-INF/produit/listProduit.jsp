<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Product Page</title>
</head>
     <body>  
     	<h2>Gestion de Produits</h2>
	<h3>
		<c:out value="${ operation }"></c:out> Produit
	</h3>
        <section>            
                <table>
                    <td>
                        <a href="produit?id=${produit.id}&action="${ action }">
                         <img src="images/addbut.jpeg" width="50"/>
                    </td>
                    <tr>
                        <th>Designation</th>
                        <th>PrixUnitaire</th>
                        <th>Categorie</th>                      
                         <th></th>
                         <th></th>
                    </tr>         
                    
                    <c:forEach items="${ produits }" var="element">                  
	                         <tr>
	                             <td>${element.designation}</td>
	                              <td>${element.prixUnitaire}</td>
	                              <td>${element.categorie}</td>  
								  <td>
                                     <a href="produit?id=${produit.id}&action="${ action }">
                                     <img src="images/delbut.jpeg" width="50"/>
                                  </td>     
                                  <td>
                                       <a href="produit?id=${produit.id}&action="${ action }">
                                        <img src="images/butMod.jpeg" width="50"/>
                                  </td>                                                                   
	                         </tr>                                        
	                 </c:forEach>                                                         
                </table>        
         
        </body> 
</html>