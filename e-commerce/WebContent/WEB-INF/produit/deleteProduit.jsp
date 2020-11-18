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
            <h1>**Delete Product Form **</h1>     
            <h2>Do you want to delete  ${requestScope.produit.designation}</h2>
            <form action="produit" method="POST">
                <input type="hidden" name="action"  value="remove"/>
                <input type="hidden" name="id"  value="${requestScope.produit.id}"/>
                <input type="submit" value="Delete"/>
                <a href="produit">Cancel</a>                 
            </form>             
       </section>

</body>
</html>