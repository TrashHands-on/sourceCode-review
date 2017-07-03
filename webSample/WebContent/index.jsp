<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきアプリ</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class ="login_field">
	<h1>ログインフォーム</h1>
	<form action="/webSample/Login" method="post">
		ユーザー名：<input type="text" name="name" required><br>
		パスワード：<input type="password" name="pass" required><br>
		<div class="login_button"><input type="submit"value="ログイン"></div>
	</form>
</div>
</body>
</html>