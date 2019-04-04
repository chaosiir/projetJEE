<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <title > Register</title>
    <link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">
    <script type="text/javascript">
        function check() {
            var pwd1 = document.getElementById("inputPassword");
            var pwd2 = document.getElementById("inputPassword2");
            if(pwd1.value.localeCompare(pwd2.value) !== 0) {
                pwd2.setCustomValidity("Repeat password");
            } else {
                pwd2.setCustomValidity("");
            }
        }
    </script>
</head>
<body class="text-center">
<form class="form-signin" method="post">
    <h1 align="center">Register</h1>
    <label  for="inputID" class="sr-only">ID</label>
    <input type="text" id="inputID" name="id" class="form-control" placeholder="Login" required autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password"  name="pwd" id="inputPassword" class="form-control" placeholder="Password" required oninput="check()">
    <label for="inputPassword2" class="sr-only">Password</label>
    <input type="password"  name="pwd2" id="inputPassword2" class="form-control" placeholder="Password" required oninput="check()">
    <label  for="inputQ" class="sr-only">Question</label>
    <input type="text" id="inputQ"  name="Q" class="form-control" placeholder="Question" required autofocus="">
    <label for="answer" class="sr-only">Answer</label>
    <input type="password" id="answer"  name="Answ" class="form-control" placeholder="Answer" required>


    <%--<a href="edit.jsp?answer=${answer}" />--%>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
</form>
</body>




</html>

