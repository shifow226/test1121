<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%@ page import="java.sql.*,javax.sql.*,javax.naming.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page import="java.util.List, sample.model.UserModel" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<h1>更新フォーム</h1>

	<html:form action="update.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><%= request.getParameter("id") %></td>
			</tr>
			<tr>
				<th>名前</th>
				<td><html:text property="name" /></td>
			</tr>
			<tr>
				<th>E-mail</th>
				<td><html:text property="email" /></td>
			</tr>
			<tr>
				<th>備考</th>
				<td><html:text property="remarks" /></td>
			</tr>
		</table>
		<html:submit property="submit" value="更新" />
	</html:form>

	<p><a href="index.jsp">TOPへ戻る</a></p>

</body>
</html>