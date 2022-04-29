<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mark Tweet as Offensive</title>
    <style>
    .container{
        padding: 80px;
    }
    #sendBtn{
        float: right;
    }
    #displayPic{
        width: 100px;
        height: 100px;
    }
    body{
        background-image: url("https://images.unsplash.com/photo-1499346030926-9a72daac6c63?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8")
    }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div id="offensiveTweetForm" class="container">
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
                <div class="col-2">
                    <c:set value="${requestScope.user}" var="us" />
                    <p>
                        <img class="rounded-circle" id="displayPic" src="${us.getProfilepic()}" />
                    <p><c:out value="${us.getFirstName()}" />&nbsp;<c:out value="${us.getLastName()}" /></p>

                </div>
                <div class="col-8">
                    <c:set value="${requestScope.tweet}" var="tw" />
                    <p><c:out value="${tw.getTweetBody()}" /></p>
                </div>

                <form class="form-group" action="offensive" method="POST">

                    <br><br>
                    <p>Is this tweet offensive to you?</p>
                    <br>
                    <label for="reason">Reason: </label>
                    <textarea cols="50" class="form-control" name="reason" id="reason"></textarea>
                    <input type="hidden" name="id" value="${tw.getTweetID()}" />
                    <button type="submit" class="btn btn-primary" id="sendBtn">SEND</button>
                </form>
            </div>
        </div>

    </div>
</body>
</html>