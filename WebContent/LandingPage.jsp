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

<script>
	console.log("welcome")
	function register() {
		console.log("welcome function")
		var name = document.getElementById("firstName").value
		console.log(name);

		console.log(name.length)
		if (name.length == "") {
			document.getElementById("efirstName").innerHTML = "First name cannot be empty";
			document.getElementById("efirstName").style.color = "red"
			document.getElementById("efirstName").style.fontSize = "15px"
			return false;
		} if(name.length!="") {

			document.getElementById("efirstName").innerHTML = "";
		}

		var lname = document.getElementById("secondName").value

		console.log(lname.length)
		if (lname.length == "") {
			document.getElementById("eLastName").innerHTML = "Last name cannot be empty";
			document.getElementById("eLastName").style.color = "red"
			document.getElementById("eLastName").style.fontSize = "15px"
			return false;
		}if(lname.length!="") {

			document.getElementById("eLastName").innerHTML = "";
		}

		var email = document.getElementById("email").value

		var regexEmail = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
		var email = document.getElementById("email");
		var eremail = document.getElementById("eremail")

		if (regexEmail.test(email.value)) {

		} else {
			eremail.innerHTML = "please enter the valid email"
			document.getElementById("eremail").innerHTML = "Please provide valid email";
			document.getElementById("eremail").style.color = "red"
			document.getElementById("eremail").style.fontSize = "15px"
			return false;

		}if(lname.length!="") {

			document.getElementById("eLastName").innerHTML = "";
		}
		var password = document.getElementById("password").value
		var errorpwd = document.getElementById("epwd")

		if (password.length == "") {
			errorpwd.innerHTML = "Password cannot be empty";
			errorpwd.style.color = "red"
			errorpwd.style.fontSize = "15px"
			return false;
		}if(password.length!="") {

			document.getElementById("epwd").innerHTML = "";
		}
		var rpassword = document.getElementById("repassword").value
		var errorpwd = document.getElementById("erpwd")

		if (password != rpassword) {
			errorpwd.innerHTML = "Password must match";
			errorpwd.style.color = "red"
			errorpwd.style.fontSize = "15px"
			return false;
		}if(rpassword.length!="") {

			document.getElementById("erpwd").innerHTML = "";
		}
	}
</script>
</head>
<style>
body, html {
	height: 100%;
}

.bag-img {
	background-image: url("registration.jpg");
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.form-control small {
	visibility: hidden;
	position: absolute;
	bottom
	=0;
	left
	=0;
}

.form-control.success input {
	border-color: green;
}

.form-control.error input {
	border-color: red;
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
					fill="white" class="bi bi-box-arrow-in-right" viewBox="0 0 16 16">
  <path fill-rule="evenodd"
						d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" />
  <path fill-rule="evenodd"
						d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
</svg>
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0 ">
					<li class="nav-item active">
					<a class="nav-link"
						href="LoginPage.jsp">Login <span class="sr-only">(current)</span></a>


					</li>
				</ul>
			</form>
		</div>

	</nav>
	<form class="bag-img" action="add.do" method="post" id="form"
		onsubmit="return register()">
		<span><h6>
				<span style="color: white"> ${message}</span> <span
					style="color: red"> ${errMessage}</span>
			</h6></span>

		<!-- <div class="form-control sucess"> -->
		<div class="row justify-content-center align-middle ">
			<label for="inputEmail3"
				class="col-sm-2 mt-5  col-form-label text-light ">First Name</label>
			<div class="col-sm-4 mt-5">
				<input type="text" class="form-control" name="firstName"
					id="firstName" placeholder="First Name">
				<div id="efirstName"></div>
			</div>

		</div>

		<div class="row justify-content-center">
			<label for="inputEmail3"
				class="col-sm-2 mt-1 col-form-label text-light">Last Name</label>
			<div class="col-sm-4 mt-1">
				<input type="text" class="form-control" id="secondName"
					placeholder="Last Name" name="secondName">
				<div id=eLastName></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<label for="inputEmail3"
				class="col-sm-2 mt-1 col-form-label text-light">Email</label>
			<div class="col-sm-4 mt-1">
				<input type="email" class="form-control" id="email"
					placeholder="Email" name="email">
				<div id=eremail></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<label for="inputPassword3"
				class="col-sm-2 mt-1 col-form-label text-light">Password</label>
			<div class="col-sm-4 mt-1">
				<input type="password" class="form-control" id="password"
					placeholder="Password" name="password">
				<div id=epwd></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<label for="inputPassword3"
				class="col-sm-2 mt-1 col-form-label text-light">Confirm
				Password</label>
			<div class="col-sm-4 mt-1">
				<input type="password" class="form-control" id="repassword"
					placeholder=" Confirm Password" name="repassword">
				<div id=erpwd></div>

			</div>

		</div>

		<div class="row justify-content-center">
			<div class="col-sm-6 mt-2">

				<input type="submit" class="btn btn-primary" value="Register" />

				<div>
					<!-- 					<button type="button" onclick="register()" name="submit">submit</button>
 -->
				</div>
			</div>
		</div>


	</form>
	<div class="card-footer text-muted footer-dark bg-dark  ">@
		copyright X-Workz-2021</div>
</body>

</html>
