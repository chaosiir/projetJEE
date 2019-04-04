<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.projetJEE.Group.Group" %>

<%
    List<Group> groups =(List<Group>) request.getAttribute("groups");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Groups</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <% String alert=request.getParameter("alert");
        if (alert!=null){
        	%>
        <script>
            alert(<%=alert%>)
        </script>
    <%
        }
    %>
</head>
<body>
<h1>Groups</h1>
<a class="btn btn-sm btn-primary" href="./Home">Retour</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Owner</th>
        <th>Creation Date</th>
        <th></th>
    </tr>
    <%
        if(groups!=null)
            for (Group group : groups) {

    %>
    <tr>
        <td><%=group.getID()%></td>
        <td><%=group.getName()%></td>
        <td><%=group.getOwner().getLogin()%></td>
        <td><%=group.getCreationDate()%></td>
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
<form action="" method="post" style="margin: 15px" >
    <div class="row">
    <button class="btn btn-sm btn-primary" type="submit" name="add"  PLACEHOLDER="Name" >Add a Group</button>
    <div class="col-2">
        <input  class="form-control-plaintext"  id="Name" name="Name"  PLACEHOLDER="Name" >
    </div>
    </div>
</form>
</body>
</html>