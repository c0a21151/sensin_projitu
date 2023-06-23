<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<html>   
    <head>
        <meta charset="UTF-8">
        <title>認証失敗</title>
    </head>     
<body>
<h1>認証失敗</h1>
<!--Point: 学籍番号と名前を入れてください-->
<%
String studentID = "xxxxxxx";
String name = "NNNNNNN";
%>
<!--↑で設定したstudentIDとnameをそれぞれ学籍番号と氏名のxxxxxxxxの
ところにJSPのスクリプト式で出力させてください-->
学籍番号: <%= studentID %> <br>
氏名: <%= name %><br>
<%
//Point: リクエストから，KadaiLoginServlerで設定したLinkedHashMapを取得するようにコードを書いてください．
LinkedHashMap<String, String> map = (LinkedHashMap<String, String>)request.getAttribute("map");
//Poing: mapにおいて，KadaiLoginServletで設定したkeyによって，メッセージをmsgへ格納させてください．
String msg = map.get("msg");
%>
<!--スクリプト式によって，msgを出力させてください-->
<%=msg%>

<a href="kadailogin.jsp">戻る</a>
</body>
</html>