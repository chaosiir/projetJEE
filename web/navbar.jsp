<%--
  Created by IntelliJ IDEA.
  User: Colin
  Date: 04/04/2019
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="./Home">Logo</a>

    <div style="display:flex; flex-grow: 1">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="./Students" style="alignment: left">Liste des etudiants</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./Users" style="alignment: left">Liste des utilisateurs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./Groups" style="alignment: center">Liste des Groups</a>
            </li>
        </ul>
        <!-- Dropdown -->
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    User
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <a class="dropdown-item" href="./update" >Update Your account </a>
                    <a class="dropdown-item" href="./login"></i>Log out</a>
                </div>
            </li>
        </ul>
    </div>

</nav>
</html>
