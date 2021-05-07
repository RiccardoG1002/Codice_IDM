<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Search Synonyms</title>
		<link rel="stylesheet" href="resources/search.css">
		<link rel="stylesheet" href="resources/stars.css">
		
	</head>
	
	<body>
		
		<jsp:include page="navBar.jsp"></jsp:include>
		<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
		
		<!-- 
		<div id="stars">
			<div id="stars2">
				<div id="stars3">
				</div>
			</div>
		</div>
		
		
		 -->
		<div class="container">
		<div class="d-flex justify-content-center text-center">
					<div class="p-3 mb-5 ">

		<c:if test = "${message != null}">
			<div id="noCountryAlert" class="alert alert-danger alert-dismissible text-center" role="alert">
				<a href="/synonyms" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>${ message }</strong>
			</div>
		</c:if>
		</div>
		</div>
		
				
				<div class="row justify-content-center">
					<div  class="col-sm-3 searchContainer justify-content-center">
						<img class="searchLogo" name="logo" src="resources/img/logo_idm7.png" height="100" alt="logo">
						<form class="form-inline" action="${baseURL}/synonyms" method="GET">
								  		
					  		<input name="find" type="text" class="searchInput" placeholder="Country" aria-label="Recipient's username" aria-describedby="Search">
					 	 	<button class="btn btn-info searchBtn" type="submit" id="button-addon2"><i class="bi bi-search"></i></button>
						</form>
					</div>
				</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>