<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<title>Home</title>
	<style>
	body{
		background-image: url("https://images.unsplash.com/photo-1499346030926-9a72daac6c63?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8")
	}
	
	.container{
		padding: 50px;
	}
	#tweet{
		border: 1px solid black;
	}
	
	#profilePic{
		width: 100px;
		height: 100px;
	}
	
	#tweetArea{
		width: 600px;
		height: 80px;
	}
	
	#btnTweet{
		float: right;
		background-color: #4fc3f7;
		border: 1px solid white;
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
	
	</style>
</head>
<body>
	<div class='container'>
		<div class='row'>
			<div id='navigationBar' class='col-2'>
				<ul>
				<li><a href='/Twitter/home'>Home</a></li>
				<li><a href='/Twitter/profile'>Profile</a></li>
				<li><a href='/Twitter/search'>Search for a user</a></li>
				<li><a href='/Twitter/logout'>Logout</a></li>
				</ul>
			</div>
			
		<div id='tweetsSection' class='col-8'>
			<form class="form-group" action="tweet" method="POST">
			<c:set value="${requestScope.profilepic}" var="profilepic" />
			<div class="row">
				<div class="col-2">
					<img class="rounded-circle" id="profilePic" src="${profilepic}"/>
				</div>
				<div class="col-10">
					<textarea class="form-control" placeholder="What's happening?" id="tweetArea" name="tweetBody"></textarea>
				</div>
			</div>
				<button type="submit" id="btnTweet" class="btn btn-primary">TWEET</button>
			</form>
			
			<br><br>
			<c:forEach items="${requestScope.tweetsOnHomePage}" var="tweet">
			<hr class="my-4">
			<div class="jumbotron">
			  <div class=row">
				  <div class="col-2">
				   	<img id="dp" class='rounded-circle' src='${tweet.getUserProfilePic()}' />
				  </div>
				  <div id="tweetsLine" class="col-10">
					  <span>
					  	<span id="userFullName"><c:out value="${tweet.getUserFullName()}" /></span>
					  	<img id="verifiedTick" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/640px-Twitter_Verified_Badge.svg.png" />
					  	<span>@<c:out value="${tweet.getUsername()}" /></span>
					  </span>
					   <p id="tweetBody"><c:out value="${tweet.getTweetBody()}" /></p>
					   <p>
					   	<span class="like">
					   	<c:out value="${tweet.getNumberOfLikes()}" />&nbsp;
					   	<button class="btn btn-link"><img class="favBtn" src="https://www.pikpng.com/pngl/b/166-1669725_heart-emoji-symbol-emoticon-red-twitter-like-icon.png" /></button>
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
