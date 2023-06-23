<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>        
<body>
<h1>入力ページ</h1>
<!--サーブレットへは，相対パスでOK-->
<form action="./FormServlet" method="GET">
    <!--sizeはボックスの長さで，maxlengthは入力可能文字数-->
    <!--requiredにすると，必須項目となる．-->
テキスト入力：<input type="text" size=20 maxlength="30" name="input1" required><br>
<hr>
パスワード入力：<input type="password" size=20 maxlength="30" name="input2" required><br>
<hr>
チェックボックス：<br>
<input type="checkbox" name="fruit[]" value="1">リンゴ<br>
<input type="checkbox" name="fruit[]" value="2">いちご<br>
<input type="checkbox" name="fruit[]" value="3">メロン<br>
<input type="checkbox" name="fruit[]" value="4">みかん<br>
<hr>
ラジオボタン: <br>
<input type="radio" name="grade" value="1"/>1年<br>
<input type="radio" name="grade" value="2"/>2年<br>
<input type="radio" name="grade" value="3"/>3年<br>
<input type="radio" name="grade" value="4"/>4年<br>
<hr>
プルダウン: <br>
<select name= "country">
    <option value = "1">日本</option>
    <option value = "2">アメリカ</option>
    <option value = "3">中国</option>
    <option value = "4">韓国</option>
  </select>
  <hr>
  テキストエリア: <br>
  <textarea name="summary" rows="4" cols="40">
  </textarea>
<input type="submit" value="送信!">
</form>
</body>
</html>
