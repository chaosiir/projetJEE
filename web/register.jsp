<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <title > Login</title>
    <link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">
    <script src='https://www.google.com/recaptcha/api.js'></script>

</head>
<body class="text-center">
<form class="form-signin">
    <h1 align="center">Register</h1>
    <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <label  for="inputID" class="sr-only">ID</label>
    <input type="text" id="inputID" class="form-control" placeholder="ID" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
    <label for="inputPassword2" class="sr-only">Password</label>
    <input type="password" id="inputPassword2" class="form-control" placeholder="Password" required="">
    <label  for="inputQ" class="sr-only">Question</label>
    <input type="text" id="inputQ" class="form-control" placeholder="Question" required="" autofocus="">
    <label for="answer" class="sr-only">Answer</label>
    <input type="password" id="answer" class="form-control" placeholder="Answer" required="">

    <div class="g-recaptcha" data-sitekey="6LfG8pYUAAAAAHATcp2pnnJ69F-_C2D5bSYVmMob" aria-required="true" ></div><br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
</form>
</body>
<script src="https://www.google.com/recaptcha/api.js?render=reCAPTCHA_site_key"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>

<script src="https://www.google.com/recaptcha/api.js?render=reCAPTCHA_site_key"></script>



</html>

