<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="com.projetJEE.Student.Student" %>
<%
    Student student = (Student) request.getAttribute("student");
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
<form action="" method="post" class="form">
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
    <button class="btn btn-sm btn-danger" type="submit" name="modify" value="">validate</button>
</form>
</table>
</body>
</html>