<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Search</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="resources/search.css">
		
	</head>
	
	<body>

		<div class="imgCover"></div>
		<img class="immBack" id="search" src="resources/img/search-background.jpg"/>
		
		<jsp:include page="navBar.jsp"></jsp:include>
		
		<c:if test = "${message != null}">
			<div id="noCountryAlert" class="alert alert-danger alert-dismissible text-center" role="alert">
				<a href="/search" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>${ message }</strong>
				<c:if test = "${fail != null}">
					<a style="color:#721c24;" href=""  data-toggle="modal" data-target="#changePsw" ><i class="bi bi bi-lock"></i><strong>${ fail } </strong></a>  
					<strong>or</strong>
					<a style="color:#721c24;" href=""  data-toggle="modal" data-target="#signinPage2" ><i class="bi bi-box-arrow-in-left"></i><strong>Log in</strong></a>
				</c:if>
				<c:if test = "${failLogin != null}">
					<a style="color:#721c24;" href=""  data-toggle="modal" data-target="#signupPage2" ><i class="bi bi-box-arrow-in-left"></i><strong>${ failLogin } </strong></a> 
				</c:if>
			</div>
		</c:if>
		
		<c:if test = "${messageSuccessful != null}">
			<div style="text-align:center;"  class="alert alert-success" role="alert">
				<a href="/search" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>${ messageSuccessful }</strong>
			</div>
		</c:if>
		
		<div  class="col-md-4 offset-md-4">
		<img name="world" src="resources/img/Globe.png" height="200" alt="world" style="padding:5%; margin-top: 20%">
			<form class="form-inline" action="http://localhost:8080/WebApplication/results" method="GET">
		  		<input name="find" type="text" class="searchForm" placeholder="Country" aria-label="Recipient's username" aria-describedby="Search">
		 	 	<button class="btn btn-info searchBtn" type="submit" id="button-addon2"><i class="bi bi-search"></i></button>
			</form>
		</div>
		
	</body>
</html>