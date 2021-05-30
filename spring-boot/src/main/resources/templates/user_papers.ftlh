<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/navbar.css">
    <link rel="stylesheet" href="/css/button.css">
    <title>Papers of ${user.fullName}</title>
</head>
<body>
<ul class="main">
    <li class="lis"><a href="/profile">Профиль</a></li>
    <li class="lis"><a href="/paper/create">Написать пост</a></li>
    <li class="lis"><a href="/files/upload">Загрузить файлы</a></li>
    <li class="lis"><a class="active" href="/papers/user/${user.id}">Мои посты</a></li>
</ul>
<br>
<h1>Ваши посты:</h1>
<ul>
    <#if papers??>
        <#list papers as paper>
            <li>
                <h3>${paper.title}</h3>
                <p>${paper.description}</p>
            </li>
            <#if isMyPage??>
                <a href="/paper/${paper.id}/remove/${user.id}" class="button1">Удалить</a>
                <form action="/paper/${paper.id}/edit/${user.id}" method="get">
                    <input type="hidden" name="id" value="${paper.id}">
                    <input type="hidden" name="title" value="${paper.title}">
                    <input type="hidden" name="description" value="${paper.description}">
                    <input type="submit" value="Редактировать" class="button1">
                </form>
            </#if>
            <hr>
        </#list>
    </#if>
</ul>
<script type="text/javascript">
    let backgrounds = [
        "url(/images/background_3.jpg) top center no-repeat",
        "url(/images/background_4.jpg) top center no-repeat",
        "url(/images/background_5.jpg) top center no-repeat",
        "url(/images/background_6.jpg) top center no-repeat",
    ];
    document.body.style.background = backgrounds[Math.floor(Math.random() * backgrounds.length)];
</script>
</body>
</html>