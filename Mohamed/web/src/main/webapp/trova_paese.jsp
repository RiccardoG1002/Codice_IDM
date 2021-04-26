<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false" %>    
<%@ page import="com.corso.paesi.*" %>
<%@ page import="com.corso.exceptions.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Paesi</h1>

<%!int contatore=0;
CheckPaese checkPaese = new CheckPaese();
Paese paese = null;
String test = "Test123";

%>


<%
String paeseCercato = request.getParameter("input_paese");


try {
	 paese = checkPaese.getPaeseStandard(paeseCercato);
	 contatore++;
	 request.setAttribute("paese", paese);
%>
<h1> paese: ${ paese.nome } </h1>
	
<!-- <h1> paese:  <%= paese.getNome() %>  </h1>-->
<h3> <%= paese.getCodice() %> </h3> 
<h3>contatore: <%= contatore %> </h3>
		
<% 		
		
} catch (PaeseNotFoundException e) {
	e.printStackTrace();
}
%>

</body>
</html>


