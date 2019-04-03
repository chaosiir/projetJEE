<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.projetJEE.Student.Student" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body  onload="JavaScript:timedRefresh(120000);"> <!-- the page is refreshed automatically every 5 minutes-->
<h1>Students</h1>
<a class="btn btn-sm btn-primary" href="./new">insert student</a>
<button onclick="rafraichir_Ewok()" class="btn btn-sm btn-primary" type="submit" name="reload page">reload page</button>
<!-- button if we want to refresh page before automatic refresh-->

<table border="1">
    <tr>
        <th>ID</th>
        <th>Gender</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Brithday</th>
        <th>Bac</th>
        <th>BacYear</th>
        <th>BacGrade</th>
        <th>Degree</th>
        <th>DegreeYear</th>
        <th>DegreeCity</th>
        <th>RegistrationYear</th>
        <th>EmailPro</th>
        <th>EmailPer</th>
        <th></th>
    </tr>
    <%
        if(students!=null)
            for (Student student : students) {
    %>
    <tr>
        <td><%=student.getID()%></td>
        <td><%=student.getGender()%></td>
        <td><%=student.getFirstname()%></td>
        <td><%=student.getLastname()%></td>
        <td><%=student.getBirthday()%></td>
        <td><%=student.getBac()%></td>
        <td><%=student.getBacGrade()%></td>
        <td><%=student.getBacYear()%></td>
        <td><%=student.getDegree()%></td>
        <td><%=student.getDegreeYear()%></td>
        <td><%=student.getDegreeCity()%></td>
        <td><%=student.getRegistrationYear()%></td>
        <td><%=student.getEmailPro()%></td>
        <td><%=student.getEmailPer()%></td>
        <td class="btn-group-sm">
            <form action="" method="post">
                <button class="btn btn-sm btn-primary" type="submit" name="modify" value="<%=student.getID()%>">modify</button>
                <button class="btn btn-sm btn-danger" type="submit" name="delete" value="<%=student.getID()%>">delete</button>
            </form>
        </td>
    </tr>
    <%
            }
    %>
</table>

</body>
<script type="text/JavaScript">
    <!--
    function timedRefresh(timeoutPeriod) {
        setTimeout("location.reload(true);",timeoutPeriod);
    }
    //   -->
</script>
<script type="text/JavaScript">
    <!--
    function rafraichir_Ewok() {
        location.reload();
    }
    //   -->
</script>

</html>