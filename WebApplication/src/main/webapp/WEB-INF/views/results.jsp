<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.corso.checkstring.beans.Country" %>
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
			
			<form class="form-inline" action="http://localhost:8080/WebApplication/results" method="GET">
				<input name="find" class="form-control mr-2" type="text" placeholder="Country" aria-label="Search">
				<button class="btn searchBtn" type="submit">Search</button>
			</form>
		</nav>
	
		<h1 class="display-1 text-center text-dark">${ country.name }</h1>
		
		
		
		
		<!-- ANGULAR -->
		<br> <br>
		<div ng-app="myApp" ng-controller="customersCtrl"> 
			
			<input id="codice" type="hidden"  value="${ country.code }">
			
			
			<!-- visualizza nazione -->
			<div class="container">
			
				<div class="text-center">
					<img src="{{myData.flag}}" width=300 >
				</div>
			
				<table class"table" >
					
				  	<tr ng-show="myData">
				    	<td> name: {{ myData.name }} </td>
				    </tr>
				    
				    <tr ng-show="myData">
				   		<td> code: {{ myData.alpha2Code }}</td>
				    </tr>
				    
				    <tr ng-show="myData">
				    	<td>capital: {{ myData.capital }}</td>
				    </tr>
				    
				    <tr ng-show="myData">
				    	<td>population: {{ myData.population }}</td>
				    </tr>
				    
				    <tr ng-show="myData">
				    	<td>native name: {{ myData.nativeName }}</td>
				    </tr>
				    
				    <tr ng-show="myData">
				    	<td>region: {{ myData.region }}<td>
				    </tr>
				    
				    <tr ng-show="myData">
				    <td>calling code: {{ myData.callingCodes }}</td>
				    </tr>
				    
				    <tr ng-show="myData">
				    <td>currency: {{ myData.currencies[0].name }}</td>
				    </tr>
		
				  
				</table>
			</div>
		</div>
	
		<script>
		var app = angular.module('myApp', []);
		
		app.controller('customersCtrl', function($scope, $http) {
			//console.log("https://restcountries.eu/rest/v2/alpha/" + $scope.codice );
			var c = document.getElementById("codice").value;
		  $http.get("https://restcountries.eu/rest/v2/alpha/" + c   ).then(function (response) {
		      $scope.myData = response.data;
		  });
		});
		
	</script>







	</body>
</html>