<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<button id="click">Click</button>
<div>
    <table id="table">
        <tr>
            <th>id</th>
            <th>email</th>
        </tr>
        <#list usersList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
            </tr>
        </#list>
    </table>
</div>
<script>
    $(document).ready(function() {
        $("#click").click(function() {
            $.ajax({
                url: "/get-users",
                method: "GET",
                success: function(data) {
                    console.log(data);
                    data.forEach(function(item, i) {
                        $("#table").append(
                            `` + item.id + ``
                            + item.email + ''
                        )
                    });
                }
            });
        });
    });
</script>
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