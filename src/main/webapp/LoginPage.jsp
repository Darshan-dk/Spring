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
function loginValidate(){
	
	var email = document.getElementById("email").value
	var password=document.getElementById("password").value
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
	if(password===null||password===""||password.trim().length==0){
		document.getElementById("err_pass").innerHTML="Password can't be null"
			return false;
	}
	if(!(password==null||password=="")){
		document.getElementById("err_pass").innerHTML=""
			
	}
	}
</script>
	
	
</head>

<style>
body, html {
  height: 100%;
}


.bag-img{
	background-image: url("login.jpg");
	height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
 
}

</style>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">E-Commerce</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
       
      </li>
     </ul>
    <form class="form-inline my-2 my-lg-0">
     <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-house" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
  <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
</svg>
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="LandingPage.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
     </ul>
    </form>
  </div>
  
</nav>

<form class="bag-img" action="login.do" method="post" id="form"
		onsubmit="return loginValidate()">
		<span style="color: white"> ${message}</span>
  <div class="row justify-content-center">
    <label for="inputEmail3" class="col-sm-2 mt-5 col-form-label text-light">Email</label>
    <div class="col-sm-4 mt-5">
      <input type="email" class="form-control" id="email" name="email"placeholder="Email">
      <span id="err_email" style=" color: red"></span>
    </div>
  </div>
  <div class="row justify-content-center">
    <label for="inputPassword3" class="col-sm-2  mt-1  col-form-label text-light  ">Password</label>
    <div class="col-sm-4  mt-1">
      <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      <span id="err_pass" style=" color: red"></span>
    </div>
  </div>
 
  
  <div class="row justify-content-center">
    <div class="col-sm-6 mt-2">
				<input type="submit" class="btn btn-primary" value="login" />
				<a href="ForgotPassword.jsp" class="btn btn-info" role="button">Forgot Password</a>
	
      
     </div>
    </div>
    

</form>
 <div class="card-footer text-muted footer-dark bg-dark  ">
   @ copyright X-Workz-2021
  </div> 
  
  <!-- <div  class="footer">
		<p class="text-light">@copyright X-workz 2021</p>
	</div> -->
</body>
 
</html>