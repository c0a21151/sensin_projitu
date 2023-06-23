<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイトル</title>
</head>
<body>
<%-- JSPのコード部 --%>
<% 
    //Servletで設定したパラメータの値を取得する．
    String val = (String)request.getAttribute("greeting");
    out.println("<p>JSPでの書き出し</p>"); 
%>
<%= val %>

</body>
</html>