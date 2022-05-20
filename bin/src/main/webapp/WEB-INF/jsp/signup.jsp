<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.form-control{
		width: 500px;
		margin-bottom: 20px;
	}
	#signUpSection{
		padding: 100px;
	}
	
	#twitterLogo{
	width: 260px;
	}
</style>
</head>
<body>

		<div id="signUpSection" class="container">
		<h2>Welcome to Twitter!</h2>
		<img id="twitterLogo" class="rounded-circle" src="https://static01.nyt.com/images/2014/08/10/magazine/10wmt/10wmt-superJumbo-v4.jpg" />
		<form class="form-group" action="signup" method="POST">
			<input type="text" class="form-control" placeholder="Enter username" id="txtUsername" name="txtUsername"/>
			<input type="text" class="form-control" placeholder="Enter password" id="txtPassword" name="txtPassword"/>
			<input type="text" class="form-control" placeholder="Confirm Password" id="txtConfirmPassword" name="txtConfirmPassword"/>
			<input type="text" class="form-control" placeholder="Enter First Name" id="txtFirstName" name="txtFirstName"/>
			<input type="text" class="form-control" placeholder="Enter Last Name" id="txtLastName" name="txtLastName"/>
			<input type="date" class="form-control" placeholder="Enter Date of Birth" id="txtDOB" name="txtDOB"/>
			<button type="submit" class="btn btn-primary">Create Account</button>
		</form>
		</div>
</body>
</html>