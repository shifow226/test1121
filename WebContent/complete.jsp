<%@page import="sample.model.CompleteModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,javax.naming.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page import="java.util.List, sample.model.ListModel2" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<html:form action="complete.do" method="post">
	<%
				CompleteModel comp =(CompleteModel)request.getAttribute("CompleteInfo");
			%>

		<h1><%= comp.getCompleteTitle() %></h1>


			<p><%= comp.getCompleteMessage() %></p>

		<p><a href="list.do">一覧へ戻る</a></p>
	</html:form>
</body>
</html>