<%--
  Created by IntelliJ IDEA.
  User: Colin
  Date: 07/03/2019
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Please register</h1>
    <form action="/register" method="post">
        Fisrt name:<br>
        <input type="text" name="fisrtname"><br>
        Last name:<br>
        <input type="text" name="lastname"><br>
        Email address:<br>
        <input type="email" name="email"><br>
        Password:<br>
        <input type="password" name="pwd1"><br>
        Confirm password:<br>
        <input type="password" name="pwd2"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
