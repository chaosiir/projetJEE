<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.projetJEE.Student.Student" %>
<%@ page import="java.sql.Date" %>
<%

    Student student = (Student) request.getAttribute("student");
    if(student==null){
        student = new Student("", "", "", "", new Date(0), "", 2000,
                "", "", 2000, "", 2000, "", "");
    }
    Date birthday = new Date(student.getBirthday().getTime());
    String[][] attributes={
            // id,              display,        type=text autre=truc ,         value
            {"ID",              "",             "type=\"text\" hidden", student.getID()},
            {"gender",          "gender",       "type=\"text\" maxlength=1", student.getGender()},
            {"firstname",       "firstname",   "type=\"text\"",    student.getFirstname()},
            {"lastname",        "lastname",    "type=\"text\"",    student.getLastname()},
            {"birthday",        "birthday",     "type=\"date\"",    birthday+""},
            {"bac",             "bac",          "type=\"text\"",    student.getBac()},
            {"bacYear",         "bac year",     "type=\"number\"",  student.getBacYear()+""},
            {"bacGrade",        "bac grade",    "type=\"text\"",    student.getBacGrade()},
            {"degree",          "degree",       "type=\"text\"",    student.getDegree()},
            {"degreeYear",      "degree year",  "type=\"number\"",  student.getDegreeYear()+""},
            {"degreeCity",      "degree city",  "type=\"text\"",    student.getDegreeCity()},
            {"registrationYear", "registration year", "type=\"number\"", student.getRegistrationYear()+""},
            {"emailPro",        "email pro",    "type=\"text\"",    student.getEmailPro()},
            {"emailPer",        "email perso",  "type=\"text\"",    student.getEmailPer()},
    };
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body class="text-center">
<h1>Students</h1>
<form action="" method="post" class="form col-md-4 offset-4 text-right">
    <%
        for(String[] field : attributes){
            String id = field[0];
            String display = field[1];
            String attr = field[2];
            String value = field[3];
    %>
    <div class="form-group row">
        <label for="<%=id%>" class="col-form-label col-6"><%=display%></label>
        <div class="col-6">
            <input <%=attr%> class="form-control" id="<%=id%>" name="<%=id%>" value="<%=value%>" >
        </div>
    </div>
    <%
        }
    %>
    <!--
    <label for="gender">gender</label>              <input class="form-control" type="text" id="gender" name="gender" maxlength="1">
    <label for="firstname">firstname</label>        <input class="form-control" type="text" id="firstname" name="firstname">
    <label for="lastname">lastname</label>          <input class="form-control" type="text" id="lastname" name="lastname">
    <label for="birthday">birthday</label>          <input class="form-control" type="date" id="birthday" name="birthday">
    <label for="bac">bac</label>                    <input class="form-control" type="text" id="bac" name="bac">
    <label for="bacYear">bacYear</label>            <input class="form-control" type="number" id="bacYear" name="bacYear">
    <label for="bacGrade">bacGrade</label>          <input class="form-control" type="text" id="bacGrade" name="bacGrade">
    <label for="degree">degree</label>              <input class="form-control" type="text" id="degree" name="degree">
    <label for="degreeYear">degreeYear</label>      <input class="form-control" type="number" id="degreeYear" name="degreeYear">
    <label for="degreeCity">degreeCity</label>      <input class="form-control" type="text" id="degreeCity" name="degreeCity">
    <label for="regitrationYear">regitrationYear</label><input class="form-control" type="text" id="regitrationYear" name="regitrationYear">
    <label for="emailPro">emailPro</label>          <input class="form-control" type="text" id="emailPro" name="emailPro">
    <label for="emailPer">emailPer</label>          <input class="form-control" type="text" id="emailPer" name="emailPer">
    -->
    <button class="btn btn-sm btn-danger" type="submit" name="validate" value="validate">validate</button>
</form>
</table>
</body>
</html>