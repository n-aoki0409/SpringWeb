<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>ログイン画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>ログイン完了画面</h2>
			ようこそ、${loginUser.userName}さん！
			<br>
			<br>
			<a href="../index/index.html">■一覧に戻る</a><br>
			<a href="../checkout/checkout.html">■精算画面へ進む</a>
		</div>
	</body>
</html>