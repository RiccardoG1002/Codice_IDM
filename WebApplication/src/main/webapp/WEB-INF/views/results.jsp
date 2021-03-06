<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.corso.checkstring.beans.Country" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Results</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<link rel="stylesheet" href="resources/search.css">
		<link rel="stylesheet" href="resources/searchResults.css">
		<link rel="stylesheet" href="resources/approve.css">
	</head>
	<body>

		<jsp:include page="navBar.jsp"></jsp:include>
		
		<c:if test = "${message != null}">
				<div class="d-flex justify-content-center text-center">
					<div class="p-3 mb-5 ">
						<div id="noCountryAlert" class="alert alert-secondary alert-dismissible text-center" role="alert">
							<a href="/search" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>${ message }</strong>
						</div>
					</div>
				</div>
				
		</c:if>
		
		<!-- ANGULAR -->
		<div ng-app="myApp" ng-controller="customersCtrl" style="overflow:hidden"> 
			
			<input id="codice" type="hidden"  value="${ country.code }">
			
			<div class="container" style="width:20%;" >
				<img src="{{myData.flag}}" class="image">
				<div class="overlay">
					<div class="text">
						<h2>${ country.name }</h2>
					</div>
				</div>		
			</div>
			
			<!-- visualizza nazione -->
			<br>
			<div class="d-flex justify-content-center text-center">
			<div class="bg-light shadow p-3 mb-5 bg-body rounded">
				<table class="table">
						
					  	<tr ng-show="myData">
					    	<td> <strong>Name:</strong> {{ myData.name }} </td>
					    </tr>
					    
					    <tr ng-show="myData">
					   		<td> <strong>Code:</strong> {{ myData.alpha2Code }}</td>
					    </tr>
					    
					    <tr ng-show="myData">
					    	<td> <strong>Capital:</strong> {{ myData.capital }}</td>
					    </tr>
					    
					    <tr ng-show="myData">
					    	<td> <strong>Population:</strong> {{ myData.population }}</td>
					    </tr>
					    
					    <tr ng-show="myData">
					    	<td> <strong>Native name:</strong> {{ myData.nativeName }}</td>
					    </tr>
					    
					    <tr ng-show="myData">
					    	<td> <strong>Region:</strong> {{ myData.region }}<td>
					    </tr>
					    
					    <tr ng-show="myData">
					    	<td> <strong>Calling code:</strong> {{ myData.callingCodes }}</td>
					    </tr>
					    
					    <tr ng-show="myData">
					    	<td> <strong>Currency:</strong> {{ myData.currencies[0].name }}</td>
					    </tr>
					  
					</table>
				</div>
			</div>
		</div>
			
		<script>
		var app = angular.module('myApp', []);
		
		app.controller('customersCtrl', function($scope, $http) {
			//console.log("https://restcountries.eu/rest/v2/alpha/" + $scope.codice );
			var c = document.getElementById("codice").value;
		  $http.get("https://restcountries.eu/rest/v2/alpha/" + c).then(function (response) {
		      $scope.myData = response.data;
		  });
		});
		
	</script>

		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>