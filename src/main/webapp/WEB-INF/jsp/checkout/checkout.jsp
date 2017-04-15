<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>精算画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>精算画面</h2>
			<font color="red"><b>送り先</b></font>
			<table>
				<tr>
					<td>ユーザID:</td>
					<td>${loginUser.userId}</td>
				</tr>
				<tr>
					<td>お名前:</td>
					<td>${loginUser.userName}様</td>
				</tr>
				<tr>
					<td>郵便番号:</td>
					<td>${loginUser.postCode}</td>
				</tr>
				<tr>
					<td>ご住所:</td>
					<td>${loginUser.address}</td>
				</tr>
				<tr>
					<td>E-MAIL:</td>
					<td>${loginUser.email}</td>
				</tr>
			</table>
			<br>
			<br>
			<font color="red"><b>お買い上げ一覧</b></font>
			<table border="1">
				<tr>
					<th width="200">商品名</th>
					<th width="150">価格</th>
					<th width="50">個数</th>
					<th width="150">小計</th>
				</tr>
				<c:forEach items="${itemList}" var="itemSet">
					<tr>
						<td align="left">${itemSet.item.itemName}</td>
						<td align="right">${itemSet.item.price}円</td>
						<td align="right">${itemSet.quantity}個</td>
						<td align="right">${itemSet.quantity * itemSet.item.price}円</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<b>合計金額：${totalAmount}円</b>
			<br>
			<br>
			<form action="../end/end.html">
				<input type="submit" name="btn1" value="確定">
			</form>
			<a href="../index/index.html">■一覧に戻る</a>
			<br>
		</div>
	</body>
</html>