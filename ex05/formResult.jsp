<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//Servletから，Mapを取得する．
LinkedHashMap map = (LinkedHashMap)request.getAttribute("map");
%>
<h1>入力結果</h1>
<ul>
<li>ユーザ名:<%=(String)map.get("input1")%>
<li>パスワード: <%=(String)map.get("input2")%>
<li>フルーツ: 
<%
ArrayList<String> fList = (ArrayList<String>)map.get("fruit");
Iterator<String> fIte = fList.iterator();
while(fIte.hasNext()){
    String fno = fIte.next();
%>
,
<%= fno%>
<%
}
%>
<li>学年: <%= (String)map.get("grade") %>
<li>国: <%= (String)map.get("country") %>
<li>サマリー:  <%
String summary = (String)map.get("summary");
%>
<%= summary%>
</ul>

</body>
</html>