<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/button.css">
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/navbar.css">
    <title>Document</title>
    <script>
        function sendFile() {
            let formData = new FormData();
            let files = ($('#file'))[0]['files'];
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost:8080/files/' + response;
                    $('#photo').append('<img src = "' + fileUrl + '"/>');
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>
</head>
<body>
<ul class="main">
    <li class="lis"><a class="active" href="/profile">Профиль</a></li>
    <li class="lis"><a href="/files/upload">Загрузить файлы</a></li>
</ul>
<br>
<br>
<br>
<div>
    <input type="file" multiple='multiple' id="file" name="file" placeholder="Имя файла..."/>
    <button onclick="sendFile()" class="button1">
        Загрузить файл
    </button>
    <input type="hidden" id="file_hidden">
    <div class="filename"></div>
</div>
<div id="photo">
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
