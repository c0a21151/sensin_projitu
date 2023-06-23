<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<html>   
    <head>
        <meta charset="UTF-8">
        <title>認証成功</title>
    </head>     
<body>
<h1>認証成功</h1>


<%
String userid = (String)request.getAttribute("userid");
%>
<%=userid%>さん，こんにちは．

<a href="01.html">戻る</a>
</body>
</html>
