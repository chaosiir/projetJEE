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
<form class="form-signin" method="post" action="">
    <h1 align="center">Login</h1>
    <h1 class="h3 mb-3 font-weight-normal">Please Log in</h1>
    <label  for="inputID" class="sr-only">ID</label>
    <input type="text" id="inputID" name="inputID" class="form-control" placeholder="login" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Password" required="">

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" name="remembermer" value="remember-me"> Remember me
        </label>
    </div>
    <div class="g-recaptcha" data-sitekey="6LfG8pYUAAAAAHATcp2pnnJ69F-_C2D5bSYVmMob" aria-required="true" ></div><br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
    <a href="./mdp" target="_blank">Forgot your password?</a>
    <br>



    <a href="./register" >Register </a><br>


</form>
</body>

<script src="https://www.google.com/recaptcha/api.js?render=reCAPTCHA_site_key"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>

<script src="https://www.google.com/recaptcha/api.js?render=reCAPTCHA_site_key"></script>



</html>

