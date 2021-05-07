<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.corso.checkstring.beans.Country" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Synonyms Results</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<link rel="stylesheet" href="resources/search.css">
		<link rel="stylesheet" href="resources/searchResults.css">
		<link rel="stylesheet" href="resources/approve.css">
		<link rel="stylesheet" href="resources/table.css">
		
	</head>
	<body>

		<jsp:include page="navBar.jsp"></jsp:include>
		
		
		<div ng-app="myApp" ng-controller="customersCtrl"> 
			
			<input id="codice" type="hidden"  value="${ country.code }">
			
			<div class="container" style="width:20%;" >
				<img src="{{myData.flag}}" class="image">
				<div class="overlay">
					<div class="text">
						<h2>${ country.name }</h2>
					</div>
				</div>		
			</div>
			
			<br>
			
			<div class="d-flex justify-content-center text-center">
				<div class="shadow p-3 mb-5 bg-body rounded">
					<table id="table" class="table-wrapper-scroll-y my-custom-scrollbar">
						<tr>
							<c:if test = "${country != null}">
						    	<th>Synonyms of ${country.name }</th>
						    </c:if>  
						</tr>
						<c:forEach items="${synonyms}" var="pattern">
							<tr>
							<td>${pattern.userPattern}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
				
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
	
		
	</body>
</html>