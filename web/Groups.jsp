<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.projetJEE.Group.Group" %>
<%@ page import="com.projetJEE.Student.Student" %>
<%@ page import="com.projetJEE.Group.GroupServiceImpl" %>
<%
    GroupServiceImpl bs=(GroupServiceImpl) request.getAttribute("groupservice");
    List<Group> groups =bs.getAllGroups() ;
    List<Student> students;
    String liststudents="";
    List<Group> children;
    String listchildren="";
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
<a class="btn btn-sm btn-primary" href="./Home">Retour</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Owner</th>
        <th>Creation Date</th>
        <th>Students</th>
        <th>Children</th>
        <th></th>
    </tr>
    <%
        if(groups!=null)
            for (Group group : groups) {
            	group=bs.getGroupByID(group.getID());
            	students=group.getStudents();
            	System.out.println(students.size());
            	for (Student student:students){
            		//TODO changer pour quand on clique sur un groupe
            		liststudents+=student.getFirstname()+" "+student.getLastname()+"<br>";
                }
            	children=group.getChildren();
            	System.out.println(children.size());
                for (Group child:children){
                    listchildren+=child.getName()+"\n";
                }

    %>
    <tr>
        <td><%=group.getID()%></td>
        <td><%=group.getName()%></td>
        <td><%=group.getOwner().getLogin()%></td>
        <td><%=group.getCreationDate()%></td>
        <td><%=liststudents%></td>
        <td><%=listchildren%></td>
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