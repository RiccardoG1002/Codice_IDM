<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
    
<head>
	<title>IDM Academy</title>
	<link rel="stylesheet" href="resources/indexStyle.css" type="text/css" media="screen">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>
<%
	int porta = request.getLocalPort();
	String path = request.getContextPath();
%>
<body>

	<jsp:include page="navBar.jsp"></jsp:include>

	<c:if test = "${message != null}">
    	<div class="alert alert-danger" role="alert">
  			<h3 class="text-center"> ${message} </h3>
		</div>
    </c:if>


	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<a href="http://localhost:<%out.print(porta); out.print(path);%>/">
						 	<img src="resources/img/idm-logo.png" class="brand_logo" alt="Logo"> 
						</a>
					</div>
				</div>
				
				<div class="d-flex justify-content-center form_container">
					<form action="http://localhost:<%out.print(porta); out.print(path);%>/signUpCreate" method="POST">
						
						<h3 class="mb-4">Create new account</h3>
						
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="username" class="form-control input_user" value="" placeholder="username">
						</div>
						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text" style="height: 80px;"><i class="fas fa-key"></i></span>
							</div>
							<div>
								<div class="mb-1">
									<input type="password" name="password" class="form-control input_pass" value="" placeholder="password">
								</div>
								
								<div class="mb-1">
									<input type="password" name="confirm_password" class="form-control input_pass" value="" placeholder="confirm password">
								</div>
							</div>
						</div>
						
						<div class="d-flex justify-content-center mt-3 login_container">
				 			<button type="submit" class="btn login_btn">Create</button>
				   		</div>
				   		
					</form>
				</div>
		
				
			</div>
		</div>
	</div>
</body>
</html>