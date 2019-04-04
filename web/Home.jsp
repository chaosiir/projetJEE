
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Home</title>
</head>
<body>
    <jsp:include page="navbar.jsp"></jsp:include>
    <div style="width: 60%; margin: auto">
        <h1 style="margin-top: 10%">Accueil</h1>
        <a class="btn btn-primary" href="./Students" style="alignment: left">Liste des etudiants</a>
        <a class="btn btn-primary" href="./Users" style="alignment: left">Liste des utilisateurs</a>
        <a class="btn btn-primary" href="./Groups" style="alignment: center">Liste des Groups</a>
        <a class="btn btn-primary" href="./update" >Update Your account </a>
    </div>
</body>
</html>

