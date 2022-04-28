<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Search for a user</title>
<style>
	.container{
		padding: 80px;
	}
	#displaypic{
		width: 150px;
		height: 150px;
	}
	
	#btnFollow{
		margin-left: 10px;
	}
	#fullname{
		margin-left: 10px;
		font-size: 150%;
	}
	
	#username{
		margin-left: 10px;
		text-decoration: none;
	}
	
	
	
</style>
</head>
<body>
	<div class="container">
	
	<div class="row">	
		<div class="col-2">
			<ul>
		 		<li><a href='/Twitter/home'>Home</a></li>
				<li><a href='/Twitter/profile'>Profile</a></li>
				<li><a href='/Twitter/search'>Search for a user</a></li>
				<li><a href='/Twitter/logout'>Logout</a></li>
			</ul>
		</div>
		<div class="col-8">
			<div class="row">
			<c:forEach items="${requestScope.recommendedusers}" var="recusers">
				<div class="col-4">
					<div id="user">
						<img id="displaypic" class="rounded-circle"  src="${recusers.getProfilepic()}"/>
						<br><br>
						<p id="fullname"><c:out value="${recusers.getFirstName()}" />&nbsp;<c:out value="${recusers.getLastName()}" /></p>
						<span id="username"><a href="/Twitter/user?username=${recusers.getUsername()}">@<c:out value="${recusers.getUsername()}" /></a></span>
						<br><br>
						<button id="btnFollow" class="btn btn-primary">FOLLOW</button>
						<br><br>
					</div>
				</div>
				
				</c:forEach>
				
			</div>
		</div>
	</div>
		
	
	</div>
</body>
</html>