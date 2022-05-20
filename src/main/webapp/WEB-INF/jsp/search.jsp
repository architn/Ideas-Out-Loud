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
	body{
		background-image: url("https://images.unsplash.com/photo-1499346030926-9a72daac6c63?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8")
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
	.nav-link{
		color: #023178;
		white-space:nowrap;
	}
	
	#searchedUserPic{
		width: 150px;
		height: 150px;
	}
	
	#searchBar{
		width: 600px;
	}
	
	.searchOutput{
		margin-left: 20px;
	}

</style>
</head>
<body>
	<div class="container">

	<div class="row">
		<div class="col-2">
			<nav class="nav flex-column">
				<a class="nav-link" href='/Twitter/home'>HOME</a>
				<a class="nav-link" href='/Twitter/profile'>PROFILE</a>
				<a class="nav-link" href='/Twitter/search'>SEARCH USERS</a>
				<a class="nav-link" href='/Twitter/logout'>LOGOUT</a>
			</nav>
		</div>
		<div class="col-8">
			<div class="row">
				<form action="search" method="POST" class="form-group">
						<div class="row">
						<div class="col-8">
							<input type="search" id="searchBar" class="form-control" name="searchParameter" placeholder="Search by username or name..." />
						</div>
						<div class="col-4">
							<button type="submit" class="btn btn-primary" >SEARCH</button>
						</div>
						</div>
				</form>
				<br><br><br>
				<c:set value="requestScope.searchedUsers" var="searchResults" />
				<c:if test="${searchResults.length() > 0}">
				<div class="row">
					<c:forEach items="${requestScope.searchedUsers}" var="searchedUsers">
		                <div class="col-4">
		                	<img class="rounded-circle" id="searchedUserPic" src="${searchedUsers.getProfilepic()}"/>
		                	<br>
		                	<p id="fullname" class="searchOutput"><c:out value="${searchedUsers.getFirstName()}" /> <c:out value="${searchedUsers.getLastName()}" /></p>
		                	<p class="searchOutput">@<c:out value="${searchedUsers.getUsername()}" /></p>
		                	<a class="btn btn-primary" href="/Twitter/user?username=${searchedUsers.getUsername()}">GO TO PROFILE</a>
		                </div>
                       		<br><br><br><br><br>
            		</c:forEach>
                	</div>
				</c:if>
				
				<h3>Recommended users to follow:</h3>
			<c:forEach items="${requestScope.recommendedusers}" var="recusers">
				<div class="col-4">
					<div id="user">
						<img id="displaypic" class="rounded-circle"  src="${recusers.getProfilepic()}"/>
						<br><br>
						<p id="fullname"><c:out value="${recusers.getFirstName()}" />&nbsp;<c:out value="${recusers.getLastName()}" /></p>
						<span id="username"><a href="/Twitter/user?username=${recusers.getUsername()}">@<c:out value="${recusers.getUsername()}" /></a></span>
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
