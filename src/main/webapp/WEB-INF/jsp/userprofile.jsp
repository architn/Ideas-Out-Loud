<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	body{
		background-image: url("https://images.unsplash.com/photo-1499346030926-9a72daac6c63?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8")
	}
	.container{
		padding: 80px;
	}
	
	
	#profilepic{
		width: 150px;
		height: 150px;
	}
	
	#userFullName{
		font-size: 160%;
	}
	
	#username{
		margin-right: 100px;
	}
	
	#dp{
		width: 70px;
		height: 70px;
		float: left;
	}
	#userFullName{
		font-size: 130%
	}
	
	#btnTweet{
		width: 100px;
	}
	
	.favBtn{
		width: 30px;
		float: right;
	}
	
	.editBtn{
		width: 30px;
	}
	
	#tweetsLine{
		margin-left: 100px;
	}
	
	#tweetBody{
		font-size: 120%;
	}
	
	#verifiedTick{
		width: 20px;
	}
	
	.like{
		float: right;
	}
	
	#bio{
		margin-left: 200px;
		font-size: 130%;
		font-style: italic;
		font-weight: bold;
		text-align: center;
	}
	
	.numberCount{
		font-size: 300%;
		text-align: center;
		color: #023178;
	}
	
	.headline{
		font-size: 120%;
		text-align: center;
		font-weight: bold;
	}
	
</style>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<title>User Profile</title></head>
<body>
	<div class="container">
	<c:set value="${sessionScope.user}" var="user" />
	<div class="row">
		<div class="col-2">
		 	<ul>
		 		<li><a href='/Twitter/home'>Home</a></li>
				<li><a href='/Twitter/profile'>Profile</a></li>
				<li><a href='/Twitter/search'>Search for a user</a></li>
				<li><a href='/Twitter/logout'>Logout</a></li>
			</ul>
		</div>
		<div id="headerSection" class="col-8">
		
			<div class="row">
					<div class="col-3">
						<img id="profilepic" class="rounded-circle" src="${user.getProfilepic()}"/>
					</div>
					<div class="col-9">
						<div class="row">
						
							<div class="col-4">
							<br><br>
								<p class="headline">TWEETS</p>
								<p class="numberCount"><c:out value="${user.getNumberOfTweets()}" /></p>
							</div>
							<div class="col-4">
							<br><br>
								<p class="headline">FOLLOWERS</p>
								<p class="numberCount"><c:out value="${user.getNumberOfFollowers()}" /></p>
							</div>
							<div class="col-4">
							<br><br>
								<p class="headline">FOLLOWING</p>
								<p class="numberCount"><c:out value="${user.getNumberOfFollowing()}" /></p>
							</div>
						</div>
					</div>
			</div>
			<p id="userFullName"><c:out value="${user.getFirstName()}" />&nbsp;<c:out value="${user.getLastName()}" />
			  	<img id="verifiedTick" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/640px-Twitter_Verified_Badge.svg.png" />
			
			</p>
			@<span  id="username"><c:out value="${user.getUsername()}" />
			
			<span id="bio"><c:out value="${user.getBio()}"/></span>
			</span>
			
			<c:forEach items="${requestScope.tweets}" var="tweet">
			<hr>
		  		<div class="jumbotron">
		  			<div class="row">
		  				<div class="col-2">
		  					<img id="dp" class='rounded-circle' src='${user.getProfilepic()}' />
		  			</div>
		  			<div class="col-10">
		  			<span>
					  	<span id="userFullName"><c:out value="${user.getFirstName()}" />&nbsp;<c:out value="${user.getLastName()}" />
					  	</span>
					  	<img id="verifiedTick" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/640px-Twitter_Verified_Badge.svg.png" />
					  	<span>@<c:out value="${user.getUsername()}" /></span>
					  </span>
					   <p id="tweetBody"><c:out value="${tweet.getTweetBody()}" /></p>
					   <p>
					   	<span class="like">
					   	<a href="/Twitter/editTweet?id=${tweet.getTweetID()}">
					   	<img class="editBtn" src="https://cdn-icons-png.flaticon.com/512/84/84380.png" />
					   	</a>

					   	</span>
					   </p>
					 <br>
		  			</div>
		  		</div>
		  </div>
		  </c:forEach>
		</div>
	</div>
	
	</div>
		
</body>
</html>