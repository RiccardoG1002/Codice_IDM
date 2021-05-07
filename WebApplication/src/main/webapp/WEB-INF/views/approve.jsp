<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Approve</title>
  	
		<link rel="stylesheet" href="resources/approve.css">
		<link rel="stylesheet" href="resources/search.css">
		<link rel="stylesheet" href="resources/table.css">
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
		<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
		
		<div class="container">
			<div class="shadow p-3 mb-5 rounded">
				<form action="${baseURL}/apply" method="POST" id="form_paesi" name="form_paesi">
					<table id="table" class="justify-content-center text-center">
						<tr>
							<th>Country searched</th>
							<th>Country found</th>
							<th>Algorithm used</th>
							<th>Approve</th>
							<th>Delete</th>
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
								<td><input name="removed" type="checkbox" value="${ p.userPattern }"></td>
							</tr>
			
						</c:forEach>
					</table>

					
						<br>
						
						
						
						<button class="btn searchBtn justify-content-center float-right" type="submit">Confirm</button>
						
				
					
				</form>
				
				<form action="http://localhost:8080/WebApplication/approve" method="GET" >
					<c:if test="${param.page > 0}">
						<button class="btn justify-content-center" type="submit" name="page" value="${param.page-1}">prev</button>
					</c:if>
					
					<c:if test="${fn:length(patternList) gt 5}">
						<button class="btn justify-content-center" type="submit" name= "page" value="${param.page+1}">next</button>
					</c:if>
					
				</form>
			</div>
				
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>


