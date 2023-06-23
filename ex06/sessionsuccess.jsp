<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, pnw.ex06.*"%>
<html>   
    <head>
        <meta charset="UTF-8">
        <title>認証成功</title>
    </head>     
<body>
<h1>認証成功</h1>


<%
//Servletで設定したセッションから取得する．
UserInfoBean bean = (UserInfoBean)session.getAttribute("user");
%>
<%=bean.getUserID()%>さん，こんにちは．
<a href="sessionmain.jsp">進む</a>
<a href="sessionlogin.jsp">戻る</a>
</body>
</html>
