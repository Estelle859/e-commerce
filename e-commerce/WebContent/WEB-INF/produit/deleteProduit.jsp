<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <section>               
            <h2>Do you want to delete  ${produit.id}  ${produit.designation} ??</h2>
            <form action="produit" method="POST">
           		<input type="hidden" name="action" value="delete" />               
                <input type="hidden" name="id"  value="${produit.id}"/>
                <input type="submit" value="Delete"/>
                <a href="vendeur">Cancel</a>                 
            </form>             
   </section>
</body>
</html>