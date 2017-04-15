<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>ユーザ登録完了画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>ユーザ登録完了画面</h2>
			<b><font color="red">ユーザ登録が完了しました。</font></b><br>
			<table>
				<tr height="40px">
					<td>ユーザID</td>
					<td>${user.userId}</td>
				</tr>
				<tr height="40px">
					<td>パスワード</td>
					<td>${user.password}</td>
				</tr>
				<tr height="40px">
					<td>名前</td>
					<td>${user.userName}</td>
				</tr>
				<tr height="40px">
					<td>郵便番号</td>
					<td>${user.postCode}</td>
				</tr>
				<tr height="40px">
					<td>住所</td>
					<td>${user.address}</td>
				</tr>
				<tr height="40px">
					<td>E-MAIL</td>
					<td>${user.email}</td>
				</tr>
				<tr height="40px">
					<td>お仕事</td>
					<td>${user.job}</td>
				</tr>
				<tr height="40px">
					<td>生年月日</td>
					<td><f:formatDate value="${user.birthDay}" pattern="yyyy年MM月dd日" /></td>
				</tr>
			</table>
			<br>
			<a href="../index/index.html">■一覧に戻る</a>
			<br>
			<a href="../checkout/checkout.html">■精算画面へ進む</a>
		</div>
	</body>
</html>