<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<head>
	<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<div ng-app="myApp" ng-controller="customersCtrl"> 
		
		<!-- menu nazioni -->
		<!-- ng-model -> porta i dati al controller -->
		<select name="nazioni" id="nazioniSelezionate" ng-model="codiceSelezionato" ng-change="select()">
		  <option value=""> -- </option>
		  <option ng-repeat="x in myData"> {{ x.capital }} </option>
		</select>
		
		<!-- visualizza nazione -->
		<ul>
		  <li ng-repeat="x in myData">
		    {{ x.name }}
		    <img src="{{x.flag}}" width=50>
		  </li>
		</ul>

		</div>
		
		<script>
		var app = angular.module('myApp', []);
		
		app.controller('customersCtrl', function($scope, $http) {
		  $http.get("https://restcountries.eu/rest/v2/all").then(function (response) {
		      $scope.myData = response.data;
		  });
		});
		
	</script>

	</body>
</html>