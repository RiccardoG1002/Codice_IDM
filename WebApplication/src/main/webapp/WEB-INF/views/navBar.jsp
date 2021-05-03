<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
  		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
		<link rel="stylesheet" href="resources/home.css">
		
	</head>
	<%
	int porta = request.getLocalPort();
	String path = request.getContextPath();
	%>
	
	<script>
	$(document).on('click', '#launchSignup', function(){
		   $('#signinPage').modal('hide');
		   $('.modal-backdrop').remove();
		   $('#signupPage').modal('show');
		});
	
	 $(document).on('click', '#launchSignin', function(){
	   $('#signupPage').modal('hide');
	   $('.modal-backdrop').remove();
	   $('#signinPage').modal('show');
	});
 	</script>
 	
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark static-top mb-3 shadow colorNavbar">
			<a class="navbar-brand textColorNavbar" href="/WebApplication/"> <img src="resources/img/logo_idm7.png" height="30"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
  			</button>
  			
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<c:if test="${ isAdmin }">
				<ul class="navbar-nav">
					<li><a class="nav-link" href="approve"><i class="bi bi-list-check"></i> Approve</a></li>

					<li><a class="nav-link" href="statistics"><i class="bi bi-graph-up"></i> Statistics</a></li>
			
					<li><a class="nav-link" href="searchSynonyms"><i class="bi bi-card-list"></i> Synonyms</a></li>
					</ul>
				</c:if>
	
				<ul class="navbar-nav ml-auto">
					<c:if test="${!isLogged}">
						<li>
							<a class="nav-link textColorNavbar" href=""  data-toggle="modal" data-target="#signinPage" ><i class="bi bi-box-arrow-in-left"></i> Login</a>
						</li>
					</c:if>
					<c:if test="${isLogged}">
						<li>
							<a class="nav-link textColorNavbar" href="logout"><i class="bi bi-box-arrow-in-right"></i> Logout</a>
						</li>
					</c:if>
					<c:if test="${ isSearching }">
						<form class="form-inline" action="http://localhost:8080/WebApplication/results" method="GET">
							<input name="find" class="form-control mr-2" type="text" placeholder="Country" aria-label="Search">
							<button class="btn searchBtn" type="submit">Search</button>
						</form>
					</c:if>
				</ul>
			</div>
		</nav>
		
		<!--content of signin page-->
		<div class="modal" id="signinPage">
			<div class="modal-dialog">
		    	<div class="modal-content">
		      
			    	<div class="modal-header text-center">
			        	<h3 class="modal-title w-100 dark-grey-text font-weight-bold"> <i class="bi bi-box-arrow-in-left"></i> Log In</h3>
			        	<button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
			      	</div>
		
		      		<div class="modal-body mx-4">
						<form action="http://localhost:<%out.print(porta); out.print(path);%>/login" method="POST" >
							<div class="md-form">
						    	<label>Username:</label>
						       	<input type="text" name="username" class="form-control input_user" value="" placeholder="example123...">
						    </div>
							<br>
						    <div class="md-form">
						    	<label>Password:</label>
						       	<input type="password" name="password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						        <p class="font-small d-flex justify-content-end"> Non ti sei ancora registrato? <a class="nav-link textColorLogin" href="" data-toggle="modal" data-target="#signupPage" id="launchSignup"><i class="bi bi-box-arrow-in-left"></i>Registrati</a></p>
						 	</div>
							<div class="text-center mb-3">
								<button type="submit" class="btn btn-primary btn-block z-depth-1a"><i class="bi bi-box-arrow-in-left"></i> Login</button>
							</div>	
						</form>
		      		</div>
				</div>
			</div> 
		</div>
		
		<!--content of obligatory signin page-->
		<div class="modal" id="signinPage2">
			<div class="modal-dialog">
		    	<div class="modal-content">
		      
			    	<div class="modal-header text-center">
			        	<h3 class="modal-title w-100 dark-grey-text font-weight-bold"> <i class="bi bi-box-arrow-in-left"></i> Log In</h3>
			        	<button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
			      	</div>
		
		      		<div class="modal-body mx-4">
						<form action="http://localhost:<%out.print(porta); out.print(path);%>/login" method="POST" >
							<div class="md-form">
						    	<label>Username:</label>
						       	<input type="text" name="username" class="form-control input_user" value="" placeholder="example123...">
						    </div>
							<br>
						    <div class="md-form">
						    	<label>Password:</label>
						       	<input type="password" name="password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						    </div>
							<div class="text-center mb-3">
								<button type="submit" class="btn btn-primary btn-block z-depth-1a"><i class="bi bi-box-arrow-in-left"></i> Login</button>
							</div>	
						</form>
		      		</div>
				</div>
			</div> 
		</div>
		
		<!--content of signup page-->
		<div class="modal" id="signupPage">
			<div class="modal-dialog">
		    	<div class="modal-content">
		      
			    	<div class="modal-header text-center">
			        	<h3 class="modal-title w-100 dark-grey-text font-weight-bold"> <i class="bi bi-box-arrow-in-left"></i> Sign up</h3>
			        	<button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
			      	</div>
		
		      		<div class="modal-body mx-4">
						<form action="http://localhost:<%out.print(porta); out.print(path);%>/signUpCreate" method="POST" >
							<div class="md-form">
						    	<label>Username:</label>
						       	<input type="text" name="username" class="form-control input_user" value="" placeholder="example123...">
						    </div>
							<br>
						    <div class="md-form">
						    	<label>Password:</label>
						       	<input type="password" name="password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						       	<label>Conferma password:</label>
						       	<input type="password" name="confirm_password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						        <p class="font-small blue-text d-flex justify-content-end">Sei già registrato? <a class="nav-link textColorLogin" data-toggle="modal" data-target="#signinPage" href="" id="launchSignin"><i class="bi bi-box-arrow-in-left"></i>Accedi</a></p>
						 	</div>
							<div class="text-center mb-3">
								<button type="submit" class="btn btn-primary btn-block z-depth-1a"><i class="bi bi-box-arrow-in-left"></i> Registrati</button>
							</div>	
						</form>
		      		</div>
				</div>
			</div> 
		</div>
		
		<!--content of obligatory signup page -->
		<div class="modal" id="signupPage2">
			<div class="modal-dialog">
		    	<div class="modal-content">
		      
			    	<div class="modal-header text-center">
			        	<h3 class="modal-title w-100 dark-grey-text font-weight-bold"> <i class="bi bi-box-arrow-in-left"></i> Sign up</h3>
			        	<button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
			      	</div>
		
		      		<div class="modal-body mx-4">
						<form action="http://localhost:<%out.print(porta); out.print(path);%>/signUpCreate" method="POST" >
							<div class="md-form">
						    	<label>Username:</label>
						       	<input type="text" name="username" class="form-control input_user" value="" placeholder="example123...">
						    </div>
							<br>
						    <div class="md-form">
						    	<label>Password:</label>
						       	<input type="password" name="password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						       	<label>Conferma password:</label>
						       	<input type="password" name="confirm_password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						    </div>
							<div class="text-center mb-3">
								<button type="submit" class="btn btn-primary btn-block z-depth-1a"><i class="bi bi-box-arrow-in-left"></i> Registrati</button>
							</div>	
						</form>
		      		</div>
				</div>
			</div> 
		</div>
		
		
		<!--content of change psw page-->
		<div class="modal" id="changePsw">
			<div class="modal-dialog">
		    	<div class="modal-content">
		      
			    	<div class="modal-header text-center">
			        	<h3 class="modal-title w-100 dark-grey-text font-weight-bold"> <i class="bi bi-lock"></i> Change Password</h3>
			        	<button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
			      	</div>
		
		      		<div class="modal-body mx-4">
						<form action="http://localhost:<%out.print(porta); out.print(path);%>/changePsw" method="POST" >
							<div class="md-form">
						    	<label>Username:</label>
						       	<input type="text" name="username" class="form-control input_user" value="" placeholder="example123...">
						    </div>
							<br>
						    <div class="md-form">
						    	<label>Password:</label>
						       	<input type="password" name="password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						       	<label>Conferma password:</label>
						       	<input type="password" name="confirm_password" class="form-control input_pass" value="" placeholder="*********">
						       	<br>
						    </div>
							<div class="text-center mb-3">
								<button type="submit" class="btn btn-primary btn-block z-depth-1a"><i class="bi bi bi-lock"></i>Cambia password</button>
							</div>	
						</form>
		      		</div>
				</div>
			</div> 
		</div>

	</body>
</html>