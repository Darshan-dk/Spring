<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Landing Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
		<script type="text/javascript">
function forgotPasswordValidate(){
	
	var email = document.getElementById("email").value
	
	var regex=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	
	if(email ==null||email==""){
		document.getElementById("err_email").innerHTML="Email field can't be blank"
		return false;
	}
	if(!(email ==null||email=="")){
		document.getElementById("err_email").innerHTML=""
		
	}if(!(email.match(regex))){
		document.getElementById("err_email").innerHTML="Email is not valid"
		return false;
	}
	if((email.match(regex))){
		document.getElementById("err_email").innerHTML=""
	}
	
	}
</script>

</head>
<style>

.bag-img{
	background-image: url("forgot.jpg");
	height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
 
}
body, html {
  height: 100%;
}


</style>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">E-Commerce</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="white" class="bi bi-house" viewBox="0 0 16 16">
  <path fill-rule="evenodd"
						d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
  <path fill-rule="evenodd"
						d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z" />
</svg>
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href="LandingPage.jsp">Home <span class="sr-only">(current)</span></a>
					</li>
				</ul>

				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="white" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd"
						d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" />
  <path fill-rule="evenodd"
						d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
</svg>
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href="LoginPage.jsp">Login <span class="sr-only">(current)</span></a>
					</li>
				</ul>
			</form>
		</div>

	</nav>
	<form action="forgot.do" class="bag-img" method="post" onclick="return forgotPasswordValidate()">
	<span style="color: white" > ${message}</span>	
		<div>
		<div class="row justify-content-center">
			<label for="inputEmail3" class="col-sm-1 mt-5 col-form-label text-light">Email</label>
			<div class="col-sm-4 mt-5">
				<input type="email" class="form-control" id="email"
					name="email" placeholder="Email">
					 <span id="err_email" style=" color: red"></span> 
			</div>
			
			
		</div>
		</div>
		

		<div class="row justify-content-center">
			<div class="col-sm-5 mt-2 	">
<!-- 				<button type="submit" class="btn btn-primary">Reset</button>
 -->				<input type="submit" class="btn btn-primary" value="reset" />
				
			</div>
		</div>


	</form>
	 <div class="card-footer text-muted footer-dark bg-dark  ">@
		copyright X-Workz-2021</div> 
	<!-- <div  class="footer">
		<p class="text-light">@copyright X-workz 2021</p>
	</div> -->


</body>

</html>