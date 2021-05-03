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
	
		<link rel="stylesheet" href="resources/table.css">
	</head>
	
	<body>
	    <img class="immBack" id="search" src="resources/img/search-background.jpg"/>
		<jsp:include page="navBar.jsp"></jsp:include>
		
		<div class="d-flex justify-content-center text-center" style="margin-top: 5%;">
			<div class="bg-light shadow p-3 mb-5 bg-body rounded">
				<table id="table">
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
		</div>
	</body>
</html>