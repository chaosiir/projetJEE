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
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="margin-top: 1%; margin-bottom: 1%">Students</h1>
<a style="margin-left: 10px"  class="btn btn-sm btn-primary" href="./Students/new">insert student</a>
<button onclick="rafraichir_Ewok()" class="btn btn-sm btn-primary" type="submit" name="reload page">reload page</button>
<!-- button if we want to refresh page before automatic refresh-->
<%
    Boolean resetButton = (Boolean) request.getAttribute("resetButton");
    if(resetButton!=null){
        resetButton=true;//not used
%>
    <a class="btn btn-sm btn-primary" href="./Students">reset Filter</a>
<%
    }
%>
<form style="margin-top: 1%" action="" method="post">
    <table style="width: 100%" class="table-striped table-bordered">
        <tr>
            <th></th>
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
        </tr>
        <%
            if(students!=null)
                for (Student student : students){
        %>
        <tr>
            <td class="btn-group btn-group-sm">
                <button class="btn btn-sm btn-primary" type="submit" name="modify" value="<%=student.getID()%>">modify</button>
                <button class="btn btn-sm btn-danger" type="submit" name="delete" value="<%=student.getID()%>">delete</button>
                <a class="btn btn-sm btn-secondary" href="./Groups?ID_student=<%=student.getID()%>">groups</a>
            </td>
            <td><%=student.getID()%></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=gender&value=<%=student.getGender()%>"><%=student.getGender()%></a></td>
            <td><%=student.getFirstname()%></td>
            <td><%=student.getLastname()%></td>
            <td><%=student.getBirthday()%></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=bac&value=<%=student.getBac()%>"><%=student.getBac()%></a></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=bacGrade&value=<%=student.getBacGrade()%>"><%=student.getBacGrade()%></a></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=bacYear&value=<%=student.getBacYear()%>"><%=student.getBacYear()%></a></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=degree&value=<%=student.getDegree()%>"><%=student.getDegree()%></a></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=degreeYear&value=<%=student.getDegreeYear()%>"><%=student.getDegreeYear()%></a></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=degreeCity&value=<%=student.getDegreeCity()%>"><%=student.getDegreeCity()%></a></td>
            <td><a class="btn btn-outline-secondary btn-sm btn-block" href="?filter=registrationYear&value=<%=student.getRegistrationYear()%>"><%=student.getRegistrationYear()%></a></td>
            <td><%=student.getEmailPro()%></td>
            <td><%=student.getEmailPer()%></td>
        </tr>
        <%
            }
        %>
    </table>
</form>

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