
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >--%>
    <%--<link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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

