<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>   
    <head>
        <meta charset="UTF-8">
        <title>ログインページ</title>
    </head>     
<body>
<h1>ログインページ</h1>
<!--Point: 学籍番号と名前を入れてください-->
<%
String studentID = "xxxxxxx";
String name = "NNNNNNN";
%>
<!--↑で設定したstudentIDとnameをそれぞれ学籍番号と氏名のxxxxxxxxの
ところにJSPのスクリプト式で出力させてください-->
学籍番号: <%= studentID %> <br>
氏名: <%= name %><br>

<!--Point: pnw内において，ex05にある，KadaiLoginServletへ，POSTでformが送信されるように
してください-->
<form action="./KadaiLoginServlet" method="POST">
<!--ユーザ名のname属性をuser, パスワードのname属性をpassとしてください-->
ユーザ名：<input type="text" name="user" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="認証">
</form>
</body>
</html>
