<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create post</title>
    <link rel="stylesheet" href="/css/navbar.css">
    <link rel="stylesheet" href="/css/button.css">
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>
<ul class="main">
    <li class="lis"><a class="active" href="/profile">Профиль</a></li>
    <li class="lis"><a href="/files/upload">Загрузить файлы</a></li>
</ul>
<br>
<br>
<br>
<form action="/paper/create" method="post">
    <input type="text" name="title" placeholder="Введите название поста">
    <input type="text" name="description" placeholder="Введите контент поста">
    <input class="button1" type="submit" name="Отправить">
</form>
<script type="text/javascript">
    let backgrounds = [
        "url(/images/background_1.jpg) top center no-repeat",
        "url(/images/background_2.jpg) top center no-repeat",
        "url(/images/background_3.jpg) top center no-repeat",
        "url(/images/background_4.jpg) top center no-repeat",
        "url(/images/background_5.jpg) top center no-repeat",
        "url(/images/background_6.jpg) top center no-repeat",
        "url(/images/background_7.jpg) top center no-repeat",
    ];
    document.body.style.background = backgrounds[Math.floor(Math.random() * backgrounds.length)];
</script>
</body>
</html>