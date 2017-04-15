<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<html>
	<head>
		<title><spring:message code="itemMenu.title" /></title>
	</head>
	<body>
		<form:form method="POST" action="search.html">
			<div align="center" class="body">
				<h2><spring:message code="itemMenu.title" /></h2>
				商品名検索<input type="text" name="itemName" /><input type="submit" value="検索" /><a href="create.html">商品登録</a>
				<table border="1">
					<tr class="header">
						<th align="center" width="80">商品ID</th>
						<th align="center" width="320">商品名</th>
						<th align="center" width="100">価格</th>
						<th align="center" width="80">編集</th>
						<th align="center" width="80">削除</th>
					</tr>
					<c:forEach items="${itemList}" var="item">
						<tr class="record">
							<td align="center">${item.itemId}</td>
							<td align="left">${item.itemName}</td>
							<td align="right"><f:formatNumber type="CURRENCY" currencySymbol="" value="${item.price}" minFractionDigits="0" />円</td>
							<td align="center">
								<a href="<c:url value="edit.html">
											<c:param name="itemId" value="${item.itemId}"></c:param>
										</c:url>">商品編集
								</a>
							</td>
							<td align="center">
								<a href="<c:url value="confirm.html">
											<c:param name="itemId" value="${item.itemId}"></c:param>
										</c:url>">商品削除
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form:form>
	</body>
</html>