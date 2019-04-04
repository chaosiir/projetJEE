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
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="margin-top: 1%; margin-bottom: 1%">Users</h1>

<table style="margin-top: 1%;width: 100% " class="table-striped table-bordered">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>question</th>
        <th>Modify Rights</th>

        <th></th>
    </tr>
    <%
        if(users!=null)
            for (User user : users) {
    %>
    <tr>
        <td><%=user.getID()%></td>
        <td><%=user.getLogin()%></td>
        <td><%=user.getQuestion()%></td>
        <td>
            <form method="post" action="?userID=<%=user.getID()%>">
            <select class="form-control form-control-sm" name="rights" onchange="this.form.submit()">
                <%
                    for(User.Rights right : User.Rights.values()){
                        if(user.getRights()==right){
                            out.println("<option selected=selected value=\""+right+"\">"+right+"</option>\n");
                        }else{
                            out.println("<option value=\""+right+"\">"+right+"</option>\n");


                        }
                    }
                %>

            </select> </form>
        </td>

    <%
            }
    %>
</table>


</body>

</html>