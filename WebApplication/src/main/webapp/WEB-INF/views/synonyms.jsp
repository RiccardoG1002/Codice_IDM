<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.corso.checkstring.beans.Country" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Search Results</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="resources/home.css">
		<link rel="stylesheet" href="resources/search.css">
		<link rel="stylesheet" href="resources/results.css">
	</head>
	<body>
	
		<nav class="navbar navbar-expand-lg navbar-dark static-top mb-3 shadow colorNavbar">
			<a class="navbar-brand" href="/WebApplication/">Home</a>
			
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="search">CheckString</a>
					</li>
					
					<li>
						<a class="nav-link" href="approve">Approve</a>
					</li>
					
					<li>
						<a class="nav-link" href="startLogin" style="margin-left: 90px;">Login</a>
					</li>
					
					<li>
						<a class="nav-link" href="logout">Logout</a>
					</li>
				</ul>
			</div>
			
			<form class="form-inline" action="http://localhost:8080/WebApplication/synonyms" method="GET">
				<input name="find" class="form-control mr-2" type="text" placeholder="Country" aria-label="Search">
				<button class="btn searchBtn" type="submit">Search Synonyms</button>
			</form>
		</nav>
		
		<div >

			<c:if test = "${first != null}">
		    	<h2>Synonyms of  ${first.country.name} </h2>
		    </c:if>  
	
			<ul>
			<c:forEach items="${synonyms}" var="pattern">
				<li>
					${pattern.userPattern}
				</li>	
			</c:forEach>
			</ul>
		</div>

	</body>
</html>