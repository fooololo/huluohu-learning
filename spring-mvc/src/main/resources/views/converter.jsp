<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>Converter</title>
</head>
<body>
    <div id="resp"></div>
    <input type="button" onclick="req();" value="request" />
    <script src="static/js/jquery-2.2.3.min.js"></script>
<script>
    function req() {
        $.ajax({
            url:"converter/start",
            data:"123-xiaoming",
            type:"POST",
            contentType:"application/x-huluohu",
            success:function (data) {
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>