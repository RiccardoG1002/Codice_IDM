<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Statistics</title>
  		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
		
	</head>
	
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light static-top mb-3 shadow">
			<a class="navbar-brand" href="/ProgettoDecHit/">Home</a>
			
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="search">CheckString</a>
					</li>
					
					<li>
						<a class="nav-link" href="approve">Approve</a>
					</li>
					
					<li>
						<a class="nav-link" href="statistics">Statistics</a>
					</li>
					
					<li>
						<a class="nav-link" href="startLogin">Login</a>
					</li>
					
					<li>
						<a class="nav-link" href="logout">Logout</a>
					</li>
					
					
					
				</ul>
			</div>
		</nav>
		
		<div class="ml-5 mt-5">
			<table style="width:60%">
				<tr>
					<th>Algorithm</th>
					<th>#Success</th>
				</tr>
				
				<c:forEach items="${list}" var="item">
				
					<tr>
						<td>${item.algoritmo}</td>
						<td>${item.num}</td>
					</tr>
				
				</c:forEach>
			</table>
		</div>
	</body>
</html>