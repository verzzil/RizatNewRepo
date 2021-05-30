<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pageable</title>
</head>
<body>

<ul>
    <#if pageable.papers??>
        <#list pageable.papers as paper>
            <li>
                <h1>${paper.title}</h1>
                <p>${paper.description}</p>
            </li>
            <hr>
        </#list>
    </#if>
</ul>

<ul>
    <#if pageable.pageCount??>
        <#list 1..pageable.pageCount as num>
            <li style="display: inline; list-style: none;">
                <#if num == currentPage>
                    <a href="/papers/pageble/${num}" style="font-weight: bold;">${num}</a>
                <#else>
                    <a href="/papers/pageble/${num}">${num}</a>
                </#if>
            </li>
        </#list>
    </#if>
</ul>

</body>
</html>