<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Kadai16_1_DTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<p>下記の内容で登録します。登録内容はこれでよろしいですか？</p>
	<%
	Kadai16_1_DTO account = (Kadai16_1_DTO)session.getAttribute("input_data");
	%>
	名前：<%=account.getName() %><br>
	年齢：<%=account.getAge() %><br>
	性別：<%=account.getGender() %><br>
	電話番号：<%=account.getNumber() %><br>
	メールアドレス：<%=account.getMail() %><br>
	パスワード：********<br>
	<a href="Kadai16_1_RegisterExecuteServlet">OK</a><br>
	<a href="Kadai16_1_RegisterFormServlet">戻る</a>
</body>
</html>