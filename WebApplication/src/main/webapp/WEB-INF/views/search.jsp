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
		<link rel="stylesheet" href="resources/home.css">
	</head>
	
	<body>
	
		<img alt="" class="immBack" id="search" src="resources/background.png"> 
		
		<jsp:include page="navBar.jsp" />
		
		
		
		<c:if test = "${message != null}">
			<div id="noCountryAlert" class="alert alert-danger alert-dismissible text-center" role="alert">
				<a href="/search" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>${ message }</strong>
			</div>
		</c:if>
		
		<div class="container" style="margin-top: 20%; margin-left: 37%;">
			<form class="form-inline" action="http://localhost:8080/ProgettoDecHit/results" method="GET">
				<input name="find" class="form-control mr-2" type="text" placeholder="Country" aria-label="Search">
				<button class="btn btn-warning" type="submit">Search</button>
			</form>
		</div>
	</body>
</html>