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
    <style type="text/css">
        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        input[type=number] {
            -moz-appearance:textfield; /* Firefox */
        }
        h2 {
            margin:1%;
            margin-top:2%;
        }
    </style>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body style="padding: 1%">
<h1 style="margin:1%">Modify group</h1>
<form action="" method="post">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <button class="btn btn-sm btn-primary" type="submit" name="addstudent"  >Add a Student</button>
        </div>
        <input  class="form-control" name="studentid"  placeholder="Student ID" >
    </div>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <button class="btn btn-sm btn-primary" type="submit" name="addgroup" >Add a Group</button>
        </div>
        <input  class="form-control" type="number" name="groupid"  placeholder="Group ID" >
    </div>
    <h2>Metadata</h2>
    <div >
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    ID
                </span>
            </div>
            <input  class="form-control"  disabled="disabled" value="<%=group.getID()%>" >
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    Name
                </span>
            </div>
            <input  class="form-control"  id="Name" name="Name"  value="<%=group.getName()%>" >
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    Owner
                </span>
            </div>
            <input  class="form-control"   disabled="disabled" value="<%=group.getOwner().getLogin()%>" >
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">
                    Date
                </span>
            </div>
            <input  class="form-control" disabled="disabled" value="<%=group.getCreationDate()%>" >
        </div>
    </div>
<h2>Students</h2>
<table style="margin-top: 1%;width: 100% " class="table-striped table-bordered">
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
        <th>  <button class="btn btn-sm btn-danger" type="submit" name="removes" value="<%=student.getID()%>">Remove</button></th>
    </tr>
    <%
        }
    %>
</table style="margin-top: 1%;width: 100% " class="table-striped table-bordered">
    <h2>Inherited Students</h2>
    <table style="margin-top: 1%;width: 100% " class="table-striped table-bordered">
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
<table style="margin-top: 1%;width: 100% " class="table-striped table-bordered">
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
        <th>  <button class="btn btn-sm btn-success" type="submit" name="include" value="<%=student.getID()%>">Include</button></th>
    </tr>
    <%
        }
    %>
</table>
<h2>Children</h2>
<table style="margin-top: 1%;width: 100% " class="table-striped table-bordered">
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
    <button style="margin:1%; margin-left: 2%" class="btn btn-danger" type="submit" name="validate" value="validate">validate</button>
</form>
</table>
</body>
</html>