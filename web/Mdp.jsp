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
<form class="form-signin" method="post">
    <h1 align="center">Verification</h1>
    <label  for="inputID" class="sr-only">ID</label>
    <input type="text" id="inputID" name="id" class="form-control" placeholder="login" required autofocus="">

   <!-- <label for="answer" class="sr-only">Answer</label>
    <input type="password" id="answer" name="answer" class="form-control" placeholder="What is the answer to your question ?" required="">-->


    <button class="btn btn-lg btn-primary btn-block" type="submit">Verification</button>
</form>
</body>




</html>

