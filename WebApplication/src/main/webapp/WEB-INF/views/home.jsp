<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
		<link rel="stylesheet" href="resources/home.css">
	</head>
	
	<body>
	
		<jsp:include page="navBar.jsp"></jsp:include>
		
		<div class="d-flex justify-content-center text-center">
			<div class="p-3 mb-5 ">
				<c:if test = "${message != null}">
	    			<div class="alert alert-danger" role="alert">
	  					<h3 class="text-center"> ${message} </h3>
					</div>
	    		</c:if>
			</div>
		</div>
		
		
		
	</body>
	
</html>