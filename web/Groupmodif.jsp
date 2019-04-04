<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.projetJEE.Student.Student" %>
<%@ page import="com.projetJEE.Group.Group" %>
<%@ page import="java.sql.Date" %>
<%
    int k=0;
    Group group=(Group) request.getAttribute("group");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<h1>Students</h1>
<a class="btn btn-sm btn-primary" href="./Group" methods="Post" >Add a Student</a>
<a class="btn btn-sm btn-primary" href="./Group" methods="Post" >Add a Group</a>
<form action="./Group" method="post" class="form">
    <label for="id" class="col-sm-2 col-form-label">ID</label>
    <div class="col-sm-10">
        <input  class="form-control-plaintext" id="id" name="id" disabled="disabled" value="<%=group.getID()%>" >
    </div>
    <label for="name" class="col-sm-2 col-form-label">ID</label>
    <div class="col-sm-10">
        <input  class="form-control-plaintext" id="name" name="name"  value="<%=group.getName()%>" >
    </div>
    <label for="owner" class="col-sm-2 col-form-label">ID</label>
    <div class="col-sm-10">
        <input  class="form-control-plaintext" id="owner" name="owner" disabled="disabled" value="<%=group.getOwner().getLogin()%>" >
    </div>
    <label for="Date" class="col-sm-2 col-form-label">ID</label>
    <div class="col-sm-10">
        <input  class="form-control-plaintext" id="Date" name="Date" disabled="disabled" value="<%=group.getCreationDate()%>" >
    </div>

    <%

        for(Student student:group.getStudents()){
        	k++;
    %>

    <label for="<%=k%>" class="col-sm-2 col-form-label">Student</label>
    <div class="col-sm-10">
        <input  class="form-control-plaintext" id="<%=k%>" name="<%=k%>" disabled="disabled" value="<%=student.getFirstname()%> <%=student.getLastname()%>" >
    </div>
    <div style="border: 1px">
        <form action="" method="post" style="border: 1px">
            <button class="btn btn-sm btn-danger" type="submit" name="delete" value="<%=student.getID()%>">delete</button>
        </form>
    </div>
    <%
        }
    %>

    <%
        for(Group child:group.getChildren()){
            k++;
    %>

    <label for="<%=k%>" class="col-sm-2 col-form-label">child</label>
    <div class="col-sm-10">
        <input  class="form-control-plaintext" id="<%=k%>" name="<%=k%>" disabled="disabled" value="<%=child.getName()%>" >
    </div>
    <div style="border: 1px">
        <form action="" method="post" style="border: 1px">
            <button class="btn btn-sm btn-danger" type="submit" name="delete" value="<%=child.getID()%>">delete</button>
        </form>
    </div>
    <%
        }
    %>

    <button class="btn btn-sm btn-danger" type="submit" name="validate" value="validate">validate</button>
</form>
</table>
</body>
</html>