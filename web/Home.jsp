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
    <link rel="stylesheet" href="public/css/bootstrap.min.css">
</head>
<body>
<div style="width: 40%; margin: auto ">
    <h1>Acceuil</h1>
    <button style="alignment: left" href="">liste des etudiants</button>
    <button style="alignment: right">liste des groupes</button>
</div>
</body>
</html>