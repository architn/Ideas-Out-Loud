<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login to Twitter</title>
    <style>
        .container{
            padding: 90px;

        }
        #txtUserName{
            width: 400px;
        }

        #txtPassword{
            width: 400px;
        }
        #loginForm{
            padding-left: 80px;
        }
        #twitterLogo{
            width: 150px;
        }
        #loginBtn{
            width: 100px;
        }
        #cardLayout{
            padding-left: 60px;
        }
        .card{
            border: none;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div id="loginForm" class="container">
    <div class="card">
        <div id="cardLayout">
            <img id="twitterLogo" class="rounded-circle" src="https://static01.nyt.com/images/2014/08/10/magazine/10wmt/10wmt-superJumbo-v4.jpg" />
            <br>
            <h3>Twitter, where the world is!</h3>
            <br><br>
            <form action="login" method="POST">
                <div class="form-group">
                    <label for="txtUserName">Email address/Username: </label>
                    <input type="text" class="form-control" name="txtUsername" id="txtUserName" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="txtPassword">Password</label>
                    <input type="password" class="form-control" name="txtPassword" id="txtPassword" placeholder="Password">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Remember Me</label>
                </div>
                <button id="loginBtn" type="submit" class="btn btn-primary">LOGIN</button>
            </form>
            <small id="emailHelp" class="form-text text-muted">Don't have an account? <a href="/Twitter/register">Sign up</a></small>
            <br><br>
        </div>
    </div>
</div>
</body>
</html>