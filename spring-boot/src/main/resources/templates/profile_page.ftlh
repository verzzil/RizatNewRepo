<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/profile_page.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <title>Profile</title>

</head>
<body>
<ul class="main">
    <li class="lis"><a class="active" href="/profile">Профиль</a></li>
    <li class="lis"><a href="/paper/create">Написать пост</a></li>
    <li class="lis"><a href="/files/upload">Загрузить файлы</a></li>
    <li class="lis"><a href="/papers/user/${user.id}">Мои посты</a></li>
</ul>
<div class="text">
    <h1>${user.getFullName()}</h1>

    <#if user.email??>
        Email: ${user.email}<br>
    </#if>
    <#if user.age??>
        Возраст: ${user.age}<br>
    </#if>
    <#if user.phone??>
        Телефон: ${user.phone}<br>
    </#if>
    <#if user.sex??>
        Пол: ${user.sex}<br>
    </#if>
</div>
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