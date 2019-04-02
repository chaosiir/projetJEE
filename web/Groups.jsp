<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.projetJEE.Group.Group" %>
<%
    List<Group> groups = (List<Group>) request.getAttribute("groups");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Groups</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<h1>Groups</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Owner</th>
        <th>Creation Date</th>
        <th>Students</th>
        <th>Childs</th>
        <th></th>
    </tr>
    <%
        if(groups!=null)
            for (Group group : groups) {
    %>
    <tr>
        <td><%=group.getID()%></td>
        <td><%=group.getName()%></td>
        <td><%=group.getOwner()%></td>
        <td><%=group.getCreationDate()%></td>
        <td><%=group.getStudents()%></td>
        <td><%=group.getChildren()%></td>
        <td class="btn-group-sm">
            <form action="" method="post">
                <button class="btn btn-sm btn-primary" type="submit" name="modify" value="<%=group.getID()%>">modify</button>
                <button class="btn btn-sm btn-danger" type="submit" name="delete" value="<%=group.getID()%>">delete</button>
            </form>
        </td>
    </tr>
    <%
            }
    %>
</table>
</body>
</html>