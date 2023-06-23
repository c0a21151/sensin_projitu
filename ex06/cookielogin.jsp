<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>テスト</title>
    </head>      
<body>
<h1>ログインページ</h1>
<%
String initPass = "";
Cookie[] cookies = request.getCookies();
int len = cookies.length;
for(int i=0;i<len;i++){
    Cookie c = cookies[i];
    if(c.getName().equals("cpassword")){
        initPass = c.getValue();
        break;
    }
}
%>
<form action= "./LoginCookieServlet" method="post">
ユーザ名：<input type="text" name="userid" required><br>
パスワード：<input type="password" name="pass" value="<%=initPass%>" required><br>
<input type="submit" value="認証">
</form>
</body>
</html>
