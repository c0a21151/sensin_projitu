<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String a = "私の名前は"; %>
<% String b = "工科花子です"; %>
<%--コメント: もちろん複数行でも書ける --%>
<%
StringBuffer buf = new StringBuffer(a);
buf.append(b);
String result = buf.toString();
%>
<p>HTMLコード部です</p>
<% for(int i=0;i<10;i++){ %>
<p>今は<%=i %>回目の出力です</p>
<%} %>
</body>
</html