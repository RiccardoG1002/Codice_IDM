<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Approve</title>
  		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"></link>
		<link rel="stylesheet" href="resources/approve.css">
		
	</head>
	
	
	
	<script>
	 	
		function OnSelectCountry(p, sel) {
		  
		    var x = document.createElement("INPUT");
		    x.setAttribute("type", "hidden");
		    x.setAttribute("name", p+"_selected");
		    x.setAttribute("id", p+"_selected");
		    x.setAttribute("value", sel.value);
		    
		    document.getElementById("form_paesi").appendChild(x);
		    
		    // <input name="${ p.userPattern }_selected" type="hidden" id="${ p.userPattern }_selected" value="${country.name}" >
		}
	</script>
	
	
	<body>
	
		<jsp:include page="navBar.jsp"></jsp:include>
			
		<div class="ml-5 mt-5" >
			<form action="http://localhost:8080/WebApplication/apply" method="POST" id="form_paesi" name="form_paesi">
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
							
							<td> 
								<div class="input-group">
									  <select class="custom-select" id="${ p.userPattern }" onchange="OnSelectCountry(&quot;${ p.userPattern }&quot;, this);">
									    <option  selected>${p.country.name}</option>
									    
									    <c:forEach items="${countryList}" var="country"> 
											 <option value="${country.name}">${country.name}</option>
										</c:forEach>
									    
									  </select>
									  
								</div>
							</td>
							
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


