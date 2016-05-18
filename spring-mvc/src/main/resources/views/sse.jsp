<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>SSE</title>
</head>
<body>
   <div id="msgFromPush">

   </div>

<script src="static/js/jquery-2.2.3.min.js"></script>
<script>
    if(!!window.EventSource){
        var source = new EventSource('push');
        s = '';
        source.addEventListener('message',function (e) {
            s += e.data + '<br/>';
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open',function (e) {
            console.log("连接打开");
        });

        source.addEventListener('error',function (e) {
            if(e.readyState == EventSource.CLOSED){
                console.log("连接关闭");
            }else {
                console.log(e.readyState);
            }
        },false);
    }else{
        console.log("你的浏览器不支持SSE");
    }
</script>
</body>
</html>