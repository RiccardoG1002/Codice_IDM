<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Approve</title>
  		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
		
	</head>
	
	<body>
	
		<jsp:include page="navBar.jsp"></jsp:include>
			
		<div class="ml-5 mt-5" >
			<form action="http://localhost:8080/WebApplication/apply" method="POST">
				<table style="width:60%">
					<tr>
						<th>Country searched</th>
						<th>Country found</th>
						<th>Algorithm used</th>
						<th>Approve</th>
					</tr>
					
					<c:forEach items="${ patternList }" var="p">
						<tr>
							<td><c:out value="${ p.userPattern }"/></td>
							<td><c:out value="${ p.country.name }"/></td>
							<td><c:out value="${ p.algorithm }"/></td>
						
							<td><input name="approved" type="checkbox" value="${ p.userPattern }"></td>
						</tr>
					</c:forEach>
				</table>
				
				<button class="btn btn-warning mt-5" type="submit">Confirm</button>
			</form>
		</div>
	</body>
</html>