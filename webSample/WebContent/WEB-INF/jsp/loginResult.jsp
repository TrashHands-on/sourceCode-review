<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	// セッションスコープからユーザー情報を取得
	User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class ="login_field">
	<h1>つぶやきアプリログイン</h1>
	<%
		if (loginUser != null) {
	%>
	<p>ログインに成功しました</p>
	<p>ようこそ<id class="login_name"><%= loginUser.getName() %></id>さん</p>
	<a href="/webSample/Main">つぶやき投稿・閲覧へ</a>
	<%
		} else {
	%>
	<p>ログインに失敗しました</p>
	<a href="/webSample/">TOPへ</a>
	<%
		}
	%>
	</div>
</body>
</html>