<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Search</title>
		<link rel="stylesheet" href="resources/search.css">
		<link rel="stylesheet" href="resources/stars.css">	
		
	</head>
	
	<body>
	
		<jsp:include page="navBar.jsp"/>
		<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
		
		<div class ="container-fluid">
		
				<!--
				<div id="stars">
					<div id="stars2">
						<div id="stars3"></div>
					</div>
				</div>
				-->
				
				<div class="d-flex justify-content-center">
					<div class="p-3 mb-5 ">
						<c:if test = "${message != null}">
							<div id="noCountryAlert" class="alert alert-danger alert-dismissible text-center" role="alert">
								<a href="/search" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong>${ message }</strong>
								<c:if test = "${fail != null}">
									<a style="color:#721c24;" href=""  data-toggle="modal" data-target="#changePsw" ><i class="bi bi bi-lock"></i><strong>${ fail } </strong></a>  
									<strong>or</strong>
									<a style="color:#721c24;" href=""  data-toggle="modal" data-target="#signinPage2" ><i class="bi bi-box-arrow-in-left"></i><strong>Log in</strong></a>
								</c:if>
								<c:if test = "${failLogin != null}">
									<a style="color:#721c24;" href=""  data-toggle="modal" data-target="#signupPage2" ><i class="bi bi-box-arrow-in-left"></i><strong>${ failLogin } </strong></a> 
								</c:if>
							</div>
						</c:if>
				
						<c:if test = "${messageSuccessful != null}">
							<div style="text-align:center;"  class="alert alert-success" role="alert">
								<a href="/search" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong>${ messageSuccessful }</strong>
							</div>
						</c:if>
					</div>
				</div>
				
				<div class="row justify-content-center">
					<div  class="col-sm-3 searchContainer justify-content-center">
						<img class="searchLogo" name="logo" src="resources/img/logo_idm7.png" height="100" alt="logo">
						<form class="form-inline" action="${baseURL}/results" method="GET">
								  		
					  		<input name="find" type="text" class="searchInput" placeholder="Country" aria-label="Recipient's username" aria-describedby="Search">
					 	 	<button class="btn btn-info searchBtn" type="submit" id="button-addon2"><i class="bi bi-search"></i></button>
						</form>
					</div>
				</div>
		</div>
		
		
			<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>