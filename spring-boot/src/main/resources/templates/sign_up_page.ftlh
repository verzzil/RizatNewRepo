<!doctype html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/signUp.css">
</head>
<body>
<form method="post" action="/signUp">
    <input name="firstName" type="text"
           placeholder="Enter name">
    <input name="lastName" type="text"
           placeholder="Enter lastname">
    <input name="email" type="text"
           placeholder="Enter your email">
    <input name="phone" type="text"
           placeholder="Enter your phone number">
    <input name="password" type="password"
           placeholder="Enter password">
    <input type="submit" value="Registration">
</form>
<a class="btn btn-outline-warning" href="/signIn">Login</a>
</body>
</html>
