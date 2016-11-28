<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<h1>登録情報一覧</h1>

	<html:form action="delete.do" method="post">
		<table border =1>
			<tr>
				<th>ID</th>
				<th>名前</th>
				<th>削除</th>
			</tr>
			<%
				List<UserModel> list =(List<UserModel>)request.getAttribute("ListFormInfo");
				for(int i = 0; i < list.size(); i++) {
					UserModel listform = list.get(i);
			%>

				<tr>
					<td><%= listform.getId() %></td>
					<td><%= listform.getName() %></td>
					<td>
						<html:hidden property="id" value="<%= String.valueOf(listform.getId()) %>" />
						<html:submit property="submit" value="削除" />
					</td>
				</tr>

			<%
				}
			%>

		</table>
	</html:form>

	<p><a href="index.jsp">TOPへ戻る</a></p>

</body>