<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User,model.Mutter,java.util.List"%>
<%
	// セッションスコープに保存されたユーザー情報を取得
	User loginUser = (User) session.getAttribute("loginUser");
	// アプリケーションスコープに保存されたつぶやきリストを取得
	@SuppressWarnings("unchecked")
	List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	// リクエストスコープに保存されたエラーメッセージを取得
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>つぶやきアプリ</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="main_field">
		<h1>つぶやきアプリメインページ</h1>
		<p>
			<id class="login_name"><%=loginUser.getName()%></id>
			さん、ログイン中 <a href="/webSample/Logout">ログアウト</a>
		</p>
		<p>ログイン時刻</p>
		<script>
			//時刻データを取得して変数jikanに格納する
			var time = new Date();

			//時・分・秒を取得する
			var hour = time.getHours();
			var minute = time.getMinutes();

			document.write(hour + "時", +minute + "分");
		</script>

		<p>
			<a href="/webSample/Main">更新</a>
		</p>
		<form action="/webSample/Main" method="post">
			<input type="text" name="text" placeholder="つぶやき内容を入力してください。">
			<input type="submit" value="つぶやく">
		</form>
		<%
			if (errorMsg != null) {
		%>
		<p><%=errorMsg%></p>

		<%
			}
		%>
		<%
			for (Mutter mutter : mutterList) {
		%>
		<p><%=mutter.getUserName()%>：<%=mutter.getText()%>
			<input type="button" value="つぶやきを削除" onClick="location.href='/jsp/delete.jsp'">
		</p>
		<%
			}
		%>
	</div>

</body>
</html>