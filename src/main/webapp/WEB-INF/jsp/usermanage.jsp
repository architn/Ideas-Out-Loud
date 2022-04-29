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
        #displayPicture{
            width: 100px;
        }
        #manageText{
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-3">
            <ul>
                <li><a href="/Twitter/manageTweets">Manage Tweets</a></li>
                <li><a href="/Twitter/manageUsers">Manage Users</a></li>
                <li><a href='/Twitter/logout'>Logout</a></li>
            </ul>
        </div>
        <div class="col-7">
            <table class="table table-striped">
                <th scope="col">User</th>
                <th scope="col">Name</th>
                <th scope="col">Date of Birth</th>
                <th scope="col">Account Status</th>
                <th scope="col">Manage</th>
                <th></th>

                    <c:forEach items="${requestScope.allUsers}" var="user">
                <tr>
                    <td>.
                        <img id="displayPicture" src="${user.getProfilepic()}" class="rounded-circle" />
                    </td>
                    <td>
                        <c:out value="${user.getFirstName()}" />
                        &nbsp;
                        <c:out value="${user.getLastName()}" />
                    </td>
                    <td>
                        <c:out value="${user.getDateOfBirth()}" />
                    </td>
                    <td>
                        <c:if test="${user.isAccountSuspended() == true}">
                        Suspended
                        </c:if>
                        <c:if test="${user.isAccountSuspended() == false}">
                            Active
                        </c:if>
                    </td>
                    <td>
                        <button class="btn btn-info">
                            <a href="/Twitter/userActions?username=${user.getUsername()}">
                                <span id="manageText">Manage</span>
                            </a>
                        </button>
                    </td>
                </tr>
                    </c:forEach>

            </table>

        </div>
    </div>
</div>
</body>
</html>