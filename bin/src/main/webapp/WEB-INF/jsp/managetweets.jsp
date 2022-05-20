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
        </div>
    </div>
</div>
</body>
</html>