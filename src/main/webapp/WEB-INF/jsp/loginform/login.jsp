<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>ログイン画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>ログイン画面</h2>
			<form:form modelAttribute="user" method="post" action="../loginform/login.html">
				<spring:hasBindErrors name="user">
					<font color="red">
						<c:forEach items="${errors.globalErrors}" var="error">
							<spring:message code="${error.code}" />
						</c:forEach>
					</font>
				</spring:hasBindErrors>
				<table>
					<tr height="40px">
						<td>ユーザーID</td>
						<td>
							<form:input path="userId" cssClass="userId" />
							<font color="red"><form:errors path="userId" /></font>
						</td>
					</tr>
					<tr height="40px">
						<td>パスワード</td>
						<td>
							<form:password path="password" cssClass="password" />
							<font color="red"><form:errors path="password" /></font>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td align="center"><input type="submit" value="ログイン"></td>
						<td align="center"><input type="reset" value="リセット"></td>
					</tr>
				</table>
			</form:form>
		</div>
		<a href="../userentryform/userEntry.html">■新規ユーザ登録</a>
	</body>
</html>