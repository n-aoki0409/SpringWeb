<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<html>
	<head>
		<title>ユーザー登録画面</title>
	</head>
	<body>
		<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>
		<div align="center" class="body">
			<h2>ユーザー登録画面</h2>
			<form:form modelAttribute="user" method="post" action="../userentryform/userEntry.html">
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
							<form:input path="userId" maxlength="20" cssClass="userId" /><font color="red">
							<form:errors path="userId" /></font>
						</td>
					</tr>
					<tr height="40px">
						<td>パスワード</td>
						<td>
							<form:password path="password" maxlength="20" cssClass="password" />
							<font color="red"><form:errors path="password" /></font>
						</td>
					</tr>
					<tr height="40px">
						<td>名前</td>
						<td>
							<form:input path="userName" maxlength="20" cssClass="userName" />
							<font color="red"><form:errors path="userName" /></font>
						</td>
					</tr>
					<tr height="40px">
						<td>郵便番号</td>
						<td>
							<form:input path="postCode" maxlength="8" cssClass="postCode" />
							<font color="red"><form:errors path="postCode" /></font>
						</td>
					</tr>
					<tr height="40px">
						<td>住所</td>
						<td>
							<form:input path="address" maxlength="50" cssClass="address" />
							<font color="red"><form:errors path="address" /></font>
						</td>
					</tr>
					<tr height="40px">
						<td>E-MAIL</td>
						<td>
							<form:input path="email" maxlength="50" cssClass="email" /><font color="red">
							<form:errors path="email" /></font></td>
					</tr>
					<tr height="40px">
						<td>お仕事</td>
						<td><form:select path="job" cssClass="jobs">
							<form:option value="社会人" label="社会人" />
							<form:option value="主婦" label="主婦" />
							<form:option value="学生" label="学生" />
							<form:option value="その他" label="その他" />
							</form:select>
						</td>
					</tr>
					<tr height="40px">
						<td>生年月日</td>
						<td>
							<form:input path="birthDay" maxlength="10" cssClass="birthDay" />
							<font color="red"><form:errors path="birthDay" /></font>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td height="40px" align="center"><input type="submit" name="btnSubmit" value="登録"></td>
						<td height="40px" align="center"><input type="reset" name="btnReset" value="リセット"></td>
					</tr>
				</table>
			</form:form>
			<a href="../index/index.html">■一覧に戻る</a>
		</div>
	</body>
</html>