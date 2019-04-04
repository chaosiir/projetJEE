<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.projetJEE.Student.Student" %>
<%@ page import="com.projetJEE.Group.Group" %>
<%@ page import="java.sql.Date" %>
<%
    int k=0;
    Group group=(Group) session.getAttribute("group");
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
<input  class="form-control-plaintext" id="groupid" name="groupid" disabled="disabled" value="ID                <%=group.getID()%>" >
<input  class="form-control-plaintext" id="groupid" name="groupid" disabled="disabled" value="Name                <%=group.getName()%>" >
<input  class="form-control-plaintext" id="groupid" name="groupid" disabled="disabled" value="Owner                <%=group.getOwner().getLogin()%>" >
<input  class="form-control-plaintext" id="groupid" name="groupid" disabled="disabled" value="Date                <%=group.getCreationDate()%>" >
<table class="table-bordered">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Firstname</th>
        <th></th>
    </tr>
    <%

        for(Student student:group.getStudents()){
    %>
    <tr>
        <th>
            <input  class="form-control-plaintext"  disabled="disabled" value="<%=student.getID()%>" >
        </th>
        <th> <input  class="form-control-plaintext"  disabled="disabled" value="<%=student.getLastname()%>" ></th>
        <th><input  class="form-control-plaintext"  disabled="disabled" value="<%=student.getFirstname()%>" ></th>
    </tr>
    <%
        }
    %>
</table>
<table class="table-bordered">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Owner</th>
        <th>Creation Date</th>
        <th></th>
    </tr>
    <%

        for(Group child:group.getChildren()){
    %>
    <tr>
        <th>
            <input  class="form-control-plaintext"  disabled="disabled" value="<%=child.getID()%>" >
        </th>
        <th> <input  class="form-control-plaintext"  disabled="disabled" value="<%=child.getName()%>" ></th>
        <th><input  class="form-control-plaintext"  disabled="disabled" value="<%=child.getOwner()%>" ></th>
        <th><input  class="form-control-plaintext"  disabled="disabled" value="<%=child.getCreationDate()%>" ></th>

    </tr>
    <%
        }
    %>
</table>

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