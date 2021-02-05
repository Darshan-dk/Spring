<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


<title>User Details</title>
<script type="text/javascript">
function updateValidate(){
	
	var fname = document.getElementById("firstName").value
	var lname=document.getElementById("secondName").value
	
	
	if(fname===null||fname===""||fname.trim.length==2){
		document.getElementById("err_fname").innerHTML="First name can't be null or less than 3 charecter"
			return false;
	}
	if(!(fname==null||fname=="")){
		document.getElementById("err_fname").innerHTML=""
			
	}
	

	if(lname===null||lname===""||lname.trim.length==2){
		document.getElementById("err_fname").innerHTML="second name can't be null or less than 3 charecter"
			return false;
	}
	if(!(lname==null||lname=="")){
		document.getElementById("err_fname").innerHTML=""
			
	}
	}
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">E-Commerce</a> <a class="navbar-brand"
		href="spring-cm-page/Home.jsp">Home</a> </nav>

	<div class="">
		<div class="container ">
		${success}
			${list.firstName}
			<form class="" action="/common-module/update" method="post" onclick="return updateValidate()">
				<input type="hidden" value="${list.email}" name="email">
				<div>First Name: <input type="text" value="${list.firstName}" id="firstName" name="firstName"></div>
				<span id="err_fname" style=" color: red"></span>
				<div>Last Name: <input type="text" value="${list.secondName}" id="secondName" name="secondName">
				</div>
				<span id="err_lname" style=" color: red"></span>
				
				
<input type="submit" class="btn btn-primary" value="update" />


			</form>
		</div>
	</div>

	<nav
		class="navbar fixed-bottom navbar-dark bg-dark justify-content-center">
	<a class="navbar-brand " href="#"><small>&copyCopyright
			good-old-days 2021</small></a> </nav>

</body>
</html>