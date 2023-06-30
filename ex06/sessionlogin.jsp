<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>テスト</title>
    </head>      
<body>
<h1>オカルトサイト</h1>
ログインしてください

<form action= "./LoginSessionServlet" method="post">
ユーザ名：<input type="text" name="userid" required><br>
パスワード：<input type="password" name="pass"  required><br>
<input type="submit" value="認証">
</form>
</body>
</html>
