<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.projetJEE.User.User" %>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<h1>Users</h1>
<a class="btn btn-sm btn-primary" href="./Home">Retour</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Hashed password</th>
        <th>question</th>
        <th>Hashed Answer</th>
        <th>Rights</th>
        <th></th>
    </tr>
    <%
        if(users!=null)
            for (User user : users) {
    %>
    <tr>
        <td><%=user.getID()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getPwdHash()%></td>
        <td><%=user.getQuestion()%></td>
        <td><%=user.getAnswerHash()%></td>
        <td><%=user.getRights()%></td>
        <td class="btn-group-sm">
            <form action="" method="post">

                <button class="btn btn-sm btn-danger"  type="submit" name="delete" value="<%=user.getID()%>">delete</button>

            </form>

            <form action="./update" method="post">
                <button type="submit" name="userAmodifier" value="<%=user%>">modify</button>

            </form>

        </td>
    </tr>
    <%
            }
    %>
</table>


</body>

</html>