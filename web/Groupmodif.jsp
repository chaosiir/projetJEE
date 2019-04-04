<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.projetJEE.Student.Student" %>
<%@ page import="com.projetJEE.Group.Group" %>
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
<h1>Group</h1>
<form action="" method="post">
<button class="btn btn-sm btn-primary" type="submit" name="addstudent"  >Add a Student</button>
    <input  class="form-control-plaintext" name="studentid"  placeholder="Student ID" >
<button class="btn btn-sm btn-primary" type="submit" name="addgroup" >Add a Group</button>
    <input  class="form-control-plaintext" type="number" name="groupid"  placeholder="Group ID" >

<input  class="form-control-plaintext"  disabled="disabled" value="ID                <%=group.getID()%>" >
    <label for="Name" >Name         </label>
    <input  class="form-control-plaintext"  id="Name" name="Name"  value="<%=group.getName()%>" >
<input  class="form-control-plaintext"   disabled="disabled" value="Owner                <%=group.getOwner().getLogin()%>" >
<input  class="form-control-plaintext" disabled="disabled" value="Date                <%=group.getCreationDate()%>" >
<h2>Students</h2>
<table class="table-bordered">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Firstname</th>
        <th></th>
    </tr>
    <%
        for(Student student:group.getInheritedStudents()){
    %>
    <tr>
        <th>
            <input  class="form-control-plaintext"  disabled="disabled" value="<%=student.getID()%>" >
        </th>
        <th> <input  class="form-control-plaintext"  disabled="disabled" value="<%=student.getLastname()%>" ></th>
        <th><input  class="form-control-plaintext"  disabled="disabled" value="<%=student.getFirstname()%>" ></th>
        <th>  <button class="btn btn-sm btn-danger" type="submit" name="removes" value="<%=student.getID()%>">Exclude</button></th>
    </tr>
    <%
        }
    %>
</table>
<h2>Excluded Students</h2>
<table class="table-bordered">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Firstname</th>
        <th></th>
    </tr>
    <%

        for(Student student:group.getExclusions()){
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
<h2>Children</h2>
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
        <th><input  class="form-control-plaintext"  disabled="disabled" value="<%=child.getOwner().getLogin()%>" ></th>
        <th><input  class="form-control-plaintext"  disabled="disabled" value="<%=child.getCreationDate()%>" ></th>
        <th>  <button class="btn btn-sm btn-danger" type="submit" name="removeg" value="<%=child.getID()%>">Remove</button></th>
    </tr>
    <%
        }
    %>
</table>
    <button class="btn btn-sm btn-danger" type="submit" name="validate" value="validate">validate</button>
</form>
</table>
</body>
</html>