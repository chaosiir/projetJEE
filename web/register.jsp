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
        User name :<br>
        <input type="text" name="username" required><br>
        Password :<br>
        <input type="password" name="pwd1" required><br>
        Confirm password :<br>
        <input type="password" name="pwd2" required><br>
        <br>
        Secret question :<br>
        <input type="text" name="question" required><br>
        Answer :<br>
        <input type="text" name="answer" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
