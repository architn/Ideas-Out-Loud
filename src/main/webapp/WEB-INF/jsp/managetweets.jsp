<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <title>Administrator View</title>
    <style>
        .container{
            padding: 80px;
        }
        body{
            background-image: url("https://images.unsplash.com/photo-1499346030926-9a72daac6c63?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8")
        }

        .nav-link{
            color: #023178;
            white-space:nowrap;
        }
    </style>
</head>
<body>
<%--	<c:forEach items="${requestScope.tweetsOnHomePage}" var="offensivetweet">--%>
<%--	</c:forEach>--%>
<div class="container">
    <div class="row">
        <div class="col-3">
            <nav class="nav flex-column">
                <a class="nav-link" href="/Twitter/manageTweets">MANAGE TWEETS</a>
                <a class="nav-link" href="/Twitter/manageUsers">MANAGE USERS</a>
                <a class="nav-link" href='/Twitter/logout'>LOGOUT</a>
            </nav>
        </div>
        <div class="col-7">
            <h1>Welcome to Administrator View</h1>
            <table class="table table-striped">
            	<th scope="col">Sr No</th>
            	<th scope="col">Tweet</th>
            	<th scope="col">Username</th>
    	         <th scope="col">Details</th>
            	<th scope="col">Delete</th>
            	<c:forEach items="${requestScope.tweets}" var="tw">
            	<tr>
            	      <th scope="row">1</th>
            		<td><c:out value="${tw.getTweetBody()}" /></td>
            		<td><c:out value="${tw.getUser().getUsername()}" /></td>
            		<td><a class="btn btn-info" href="/Twitter/tweetDetails?id=${tw.getTweetID()}">Details</a></td>
            		<td><a class="btn btn-danger" href="/Twitter/adminDelete?id=${tw.getTweetID()}">Delete</a></td>
            	</tr>
            </c:forEach>
            </table>
            
            
        </div>
    </div>
</div>
</body>
</html>