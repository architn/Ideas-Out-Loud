<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Edit Tweet page</title>
<style>

	.container{
		padding: 80px;
	}
	#tweetArea{
		width: 700px;
		height: 200px;
	}
	#editTweetBtn{
		float: right;
		font-weight: bold;
		background-color: #4fc3f7;
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
			<h4>Edit Tweet</h4>
			<br>
				<form class="form-group" action="editedTweet" method="POST">
				<c:set value="${requestScope.tweet}" var="tw" />
				<c:set value="${sessionScope.user}" var="user" />
					<textarea id="tweetArea" name="tweetBody" class="form-control" >
					${tw.getTweetBody()}
					</textarea>
					<input type="hidden" name="id" value="${tw.getTweetID()}" />
					<br>
					<button id="editTweetBtn" class="btn btn-primary">POST EDITED TWEET</button>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>