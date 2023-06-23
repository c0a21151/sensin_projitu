<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pnw.ex06.*"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>テスト</title>
    </head>      
<body>
<h1>ログインページ</h1>
<%
UserInfoBean info = (UserInfoBean)session.getAttribute("user");
%>
セッション内の情報: <br>
名前: <%=info.getUserID()%> <br>
パスワード: <%=info.getPassword() %><br>

<a href="./LogoutServlet">ログアウトする</a>
</body>
</html>
