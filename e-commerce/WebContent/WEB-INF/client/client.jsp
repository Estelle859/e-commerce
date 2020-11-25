<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <c:import url="/WEB-INF/shared/bs.jsp"></c:import> --%>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/a6c393237d.js"></script>
<title>Client Page</title>
</head>
<body>



<!-- 	<header> -->
<%-- 		<c:import url="/WEB-INF/shared/header.jsp"></c:import> --%>
<!-- 	</header> -->

<nav class="navbar navbar-inverse">
<%-- 		<c:import url="/WEB-INF/shared/navcli.jsp"></c:import> --%>

  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Easy Shop</a>
    </div>
  
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="produit">Products</a></li>
         <li><a href="connexion">Services</a></li>
      <li><a href="contact">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
<!--       <li><a href="panier"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li> -->
<!--         <li class="nav-item px-3 text-uppercase mb-0 position-relative d-lg-flex"> -->
<!--         <div id="cart" class="d-none"> -->

<!--         </div> -->
        <a href="panier" action="" class="cart position-relative d-inline-flex" aria-label="View your shopping cart">
          <i class="fas fa fa-shopping-cart fa-lg"></i>
          <span class="cart-basket d-flex align-items-center justify-content-center">
            ${ panier.size }
          </span>
        </a>

<!--       <button id="sidenav-open-btn" class="menu-hamburger position-absolute pointer p-0"> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--       </button> -->
    </ul>
  </div>
	</nav>
	<main>
		<div class="container">
			<h2>Consulter des Articles :</h2>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Designation</th>
						<th>PrixUnitaire</th>
						<th>Quanté en stock</th>
						<th>Ajouter au Panier</th>				
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ produits }" var="element">
						<tr>
							<td>${element.designation}</td>
							<td>${element.prixUnitaire}</td>
							<td>${element.quantiteStock}</td>						
                            <img  width="50" src="images/tag.jpg" alt="" />  							 
							<td><a href="article?id=${element.id}"><i class="fas fa-cart-plus"></i></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
<!-- 		<footer> -->
<%-- 		<c:import url="/WEB-INF/shared/footer.jsp"></c:import> --%>
<!-- 	</footer> -->
</body>
</html>