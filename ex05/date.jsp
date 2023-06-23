<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="ja-JP">
<head>   
    <title>テスト</title>
</head>
<body>
    <%
        //まずはタイムゾーンを指定する．
        //date_default_timezone_set("Asia/Tokyo");
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd E HH:mm:ss");
        //現在の日付の画面出力
        out.println("yyyy/MM/dd HH:mm:ssの場合:"+df.format(date) + "<br>");
        

        //指定した日時のフォーマット
        //$str_date = "2013/01/01 02:30:34";
        //echo $str_date . "-> TimeStamp:". strtotime($str_date) . "<br/>";
        //echo $str_date . "->Date:" . date("Y/m/d:H:i:s", strtotime($str_date)) . "<br/>"; 
        String str_date ="2013/01/01 02:30:34";
        Date date2 = new Date(str_date);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
        //現在の日付の画面出力
        out.println("2013/01/01 02:30:34の場合"+df2.format(date2));
    %>
</body>
</html>