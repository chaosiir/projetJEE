<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <title > Verification</title>
    <link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">

</head>
<body class="text-center">
<form class="form-signin" method="post" action="./answer" >
    <h1 align="center">Verification</h1>
    <%
        String question= (String) (request.getAttribute("question"));
    %>




    <h1 align="center">Your question is : <%=question%></h1>

    <label for="answer" class="sr-only">Confirm ID</label>
    <input type="password" id="id" name="id" class="form-control" placeholder="Confirm Login" required="">

    <label for="answer" class="sr-only">Answer</label>
    <input type="password" id="answer" name="answer" class="form-control" placeholder="What is the answer to your question ?" required="">

   <script>

   </script>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Verification</button>
    <a class="btn btn-sm btn-primary" href="./mdp">Retour</a>

</form>
</body>




</html>
