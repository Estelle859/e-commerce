<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<header>
<%-- 	<c:import url="shared/header.jsp"></c:import> --%>
</header>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Easy Shop</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>      
        <li><a href="produit">Products</a></li>
        <li><a href="connexion">Services</a></li>
        <li><a href="contact">Contact</a></li>
        <li><a href="deconnexion">Logout</a></li>
       
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="connexion"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
        <li><a href="panier"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>

<main>
		<article class=container>
			<div
				style="display: flex; flex-wrap: wrap; justify-content: space-between; align-content: space-between">
				<c:forEach items="${ produits }" var="produit">​
					<figure style="width: 46%; height: 45vh;">
					<a href="article?id=${ produit.id }"> <img
							src="${ produit.urlImage }" alt="${ produit.designation }"
							style="width: 100%; height: 90%;">						
							<figcaption style="text-align: center"	class="badge badge-secondary">
								<c:out  value="${ produit.designation }" />
								<c:out  value="${ produit.prixUnitaire }" /> €
							</figcaption>
​
						</a>
					</figure>
				</c:forEach>
			</div>
		</article>
	</main>



<footer class="container-fluid text-center">
  <p>Online Store Copyright</p>  
  <form class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Sign Up</button>
  </form>
</footer>

</body>
</html>
