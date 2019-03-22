<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" >
    <meta charset="UTF-8">
    <title > Login</title>
    <link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">

</head>
<body class="text-center">
<form class="form-signin">
    <h1 align="center">Login</h1>
    <img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please Log in</h1>
    <label  for="inputID" class="sr-only">ID</label>
    <input type="text" id="inputID" class="form-control" placeholder="ID" required="" autofocus="">
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
</form>
</body>
</html>

