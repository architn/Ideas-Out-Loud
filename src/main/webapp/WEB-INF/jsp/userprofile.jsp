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

	.deleteBtn{
		width: 20px;
	}

	.editBtn{
		width: 30px;
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
		white-space:nowrap;
	}

	.nav-link{
		color: #023178;
		white-space:nowrap;
	}

	#numberCount{
		font-size: 200%;
		text-align: center;
		color: #023178;
		text-decoration: none;
		margin-left: 50px;
	}

	#numberCount1{
		font-size: 200%;
		text-align: center;
		color: #023178;
		text-decoration: none;
		margin-left: 50px;
	}

	#numberCount2{
		font-size: 200%;
		text-align: center;
		color: #023178;
		text-decoration: none;
		margin-left: 50px;
	}

	.headline{
		font-size: 120%;
		text-align: center;
		font-weight: bold;
	}

</style>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>	<title>User Profile</title></head>
<body>
	<div class="container">
	<c:set value="${sessionScope.user}" var="user" />
	<div class="row">
		<div class="col-2">
			<nav class="nav flex-column">
		 		<a class="nav-link" href='/Twitter/home'>HOME</a>
				<a class="nav-link" href='/Twitter/profile'>PROFILE</a>
				<a class="nav-link" href='/Twitter/search'>SEARCH USERS</a>
				<a class="nav-link" href='/Twitter/logout'>LOGOUT</a>
			</nav>

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
								<button id="numberCount2" type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModalLong">
									<c:out value="${user.getNumberOfTweets()}" />
								</button>
							</div>
							<div class="col-4">
							<br><br>
								<p class="headline">FOLLOWERS</p>
								<p class="numberCount">
									<!-- Button trigger modal -->
									<button id="numberCount" type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModalLong">
										<c:out value="${user.getNumberOfFollowers()}" />
									</button>
								</p>
									<!-- Modal -->
								<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												hello
											</div>
										</div>
									</div>
								</div>

							</div>
							<div class="col-4">
							<br><br>
								<p class="headline">FOLLOWING</p>
								<button id="numberCount1" type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModalLong">
									<c:out value="${user.getNumberOfFollowing()}" />
								</button>
							</div>
						</div>
					</div>
			</div>
			<p id="userFullName"><c:out value="${user.getFirstName()}" />&nbsp;<c:out value="${user.getLastName()}" />
				<c:if test="${user.isUserVerified() == true}">
					<img id="verifiedTick" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/640px-Twitter_Verified_Badge.svg.png" />
				</c:if>
			</p>
					@<span  id="username"><c:out value="${user.getUsername()}" />
					<span id="bio"><c:out value="${user.getBio()}"/></span>
			</span>

			<c:forEach items="${requestScope.tweets}" var="tweet">
			<hr>
		  		<div>
		  			<div class="row">
		  				<div class="col-2">
		  					<img id="dp" class='rounded-circle' src='${user.getProfilepic()}' />
		  			</div>
		  			<div class="col-10">
		  			<span>
					  	<span id="userFullName">
                <c:out value="${user.getFirstName()}" />&nbsp;<c:out value="${user.getLastName()}" />
					  	</span>
						<c:if test="${user.isUserVerified() == true}">
							<img id="verifiedTick" src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/640px-Twitter_Verified_Badge.svg.png" />
						</c:if>
						<span>@<c:out value="${user.getUsername()}" /></span>
					  </span>
					  <c:if test="${tweet.isHasTweetBeenEdited() == true}">
							 <p>Edited</p>
					  </c:if>
					   <p id="tweetBody"><c:out value="${tweet.getTweetBody()}" /></p>
					   <p>
					   	<span class="like">
					   	<a href="/Twitter/editTweet?id=${tweet.getTweetID()}">
					   	<img class="editBtn" src="https://cdn-icons-png.flaticon.com/512/84/84380.png" />
					   	</a>
							<span class="delete">
							   <a class="btn btn-link" href="/Twitter/deleteTweet?id=${tweet.getTweetID()}">
					   				<img class="deleteBtn" src="https://cdn5.vectorstock.com/i/1000x1000/09/39/trash-can-flat-red-color-icon-vector-6080939.jpg" />
					   			</a>
						   </span>
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
