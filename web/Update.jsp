<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <title > Update</title>
    <link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">

</head>
<body class="text-center">
<form class="form-signin" method="post">
    <h1 align="center">Update Data</h1>
    <label  for="inputID" class="sr-only">Choose new ID</label>
    <input type="text" id="inputID" class="form-control" placeholder="Choose new ID" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Choose new password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Choose new Password" required="">
    <label for="inputPassword2" class="sr-only">Confirm </label>
    <input type="password" id="inputPassword2" class="form-control" placeholder="Confirm Password" required="">
    <label  for="inputQ" class="sr-only">Question</label>
    <input type="text" id="inputQ" class="form-control" placeholder="Question" required="" autofocus="">
    <label for="answer" class="sr-only">Answer</label>
    <input type="password" id="answer" class="form-control" placeholder="Answer" required="">

    <div class="g-recaptcha" data-sitekey="6LfG8pYUAAAAAHATcp2pnnJ69F-_C2D5bSYVmMob" aria-required="true" ></div><br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Update</button>
</form>
</body>




</html>
