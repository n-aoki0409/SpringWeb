<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>カート確認画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>カート確認画面</h2>
			<div class="cart">
				<table style="font-size: 10pt;">
					<tr>
						<td colspan="2">
							<font color="green">カートには次の商品が入っています。</font>
						</td>
					</tr>
					<c:forEach items="${cart.itemList}" var="itemSet">
						<tr>
							<td>${itemSet.item.itemName}</td>
							<td>${itemSet.quantity}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>
			${message}
			<br>
			<br>
			<a href="../index/index.html">■一覧に戻る</a><br>
			<a href="../checkout/checkout.html">■精算画面へ進む</a>
		</div>
	</body>
</html>