<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<html>
	<head>
		<title>管理者ログイン覧画面</title>
	</head>
	<body>
		<div align="center" class="body">
			<h2>管理者ログイン画面</h2>
			<c:if test="${not empty param.login_error}">
				<font color="red">${SPRING_SECURITY_LAST_EXCEPTION.message}</font>
			</c:if>
			<form action="login" method="post">
				<table>
					<tr height="40px">
						<td>ユーザーID</td>
						<td><input class="userId" type="text" class="text" name="username" size="20"></td>
					</tr>
					<tr height="40px">
						<td>パスワード</td>
						<td><input class="password" type="password" class="text" name="password" size="20"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"></td>
					</tr>
				</table>
				<table>
					<tr>
						<td align="center"><input type="submit" value="ログイン"></td>
					</tr>
				</table>
			</form>
			<br>
		</div>
	</body>
</html>