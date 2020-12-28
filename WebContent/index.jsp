<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h4>Spring login page</h4>
	<h4>
		<span style="color: red"></span> ${errmessage} 
	</h4>
	<form action="login.do" method="post">
		<pre>
User Name:<input type="text" name="userName">
Password:<input type="password" name="password">
<input type="submit" value="Login">


</pre>

	</form>
	<form action="product.jsp">
		<input type="submit" value="Add" />
	</form>
</body>
</html>