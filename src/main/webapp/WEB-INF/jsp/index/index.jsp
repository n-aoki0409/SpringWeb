<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>商品一覧画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>商品一覧画面</h2>
			<table border="1">
				<tr class="header">
					<th align="center" width="80">商品ID</th>
					<th align="center" width="320">商品名</th>
					<th align="center" width="100">価格</th>
				</tr>
				<c:forEach items="${itemList}" var="item">
					<tr class="record">
						<td align="center">${item.itemId}</td>
						<td align="left"><a href="../detail/detail.html?itemId=${item.itemId}">${item.itemName}</a></td>
						<td align="right">${item.price}円</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>