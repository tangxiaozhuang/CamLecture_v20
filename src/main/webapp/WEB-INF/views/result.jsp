<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script>

        function onClick(e){
            var id=e.getAttribute("data-id");
            var name=e.getAttribute("data-name");
            alert("Id: "+id+" ; Name: "+name);
        }
    </script>
</head>
<body>
<div class="title" data-id="1" data-name="Microsoft">Click Me</div>
<div id="add" data-id="2" data-name="Google" onclick="onClick(this)">Click Me</div>
</body>
</html>