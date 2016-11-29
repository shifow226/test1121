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

	<h1>登録情報詳細</h1>

	<html:form action="show.do" method="post">
		<table>

			<%
				List<UserModel> list =(List<UserModel>)request.getAttribute("ListFormInfo");
				for(int i = 0; i < list.size(); i++) {
					UserModel listform = list.get(i);
			%>
			<tr>
				<th>ID</th>
				<td><%= String.valueOf(listform.getId()) %></td>
			</tr>
			<tr>
				<th>名前</th>
				<td><%= listform.getName() %></td>
			</tr>
			<tr>
				<th>E-mail</th>
				<td><%= listform.getEmail() %></td>
			</tr>
			<tr>
				<th>備考</th>
				<td><%= listform.getRemarks() %></td>
			</tr>

			<%
				}
			%>
		</table>

		<html:form action="update.do" method="post">
			<html:submit property="submit" value="更新" />
		</html:form>


		<html:form action="delete.do" method="post">
			<html:submit property="submit" value="削除" />
		</html:form>


		<a href="list.do">一覧へ戻る</a>
	</html:form>

	<p><a href="index.jsp">TOPへ戻る</a></p>

</body>
</html>