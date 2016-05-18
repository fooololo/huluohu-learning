<%@page
    language="java" contentType="text/html; UTF-8" pageEncoding="utf-8"
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>SSE</title>
</head>
<body>
   <div id="msgFromPush">
        推送：
   </div>

<script src="static/js/jquery-2.2.3.min.js"></script>
<script>
    function deferred() {
        $.get('defer',function (data) {
            console.log(data);
            deferred();
        });
    }
    deferred();
</script>
</body>
</html>