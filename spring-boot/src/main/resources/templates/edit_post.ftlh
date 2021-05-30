<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/button.css">
    <link rel="stylesheet" href="/css/form.css">
    <title>Редактировать пост</title>
</head>
<body>
<form action="/paper/${paperId}/edit/${userId}" method="post">
    <input type="text" name="title" value="${paper.title}">
    <input type="text" name="description" value="${paper.description}">
    <input type="hidden" name="id" value="${paper.id}">
    <input type="submit" value="Редактировать" class="button1">
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