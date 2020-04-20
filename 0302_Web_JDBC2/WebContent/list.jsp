<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.ict.db.VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ict.db.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%
     WebApplicationContext context =
     	WebApplicationContextUtils.getWebApplicationContext(application);
	 
     DAO dao = (DAO)context.getBean("dao");
     List<VO> list = dao.getList();
     pageContext.setAttribute("list", list);
     session.setAttribute("dao", dao);
     
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 정보 보기</title>
<style type="text/css">
	div{text-align: center; margin: 100px; auto;}
	table{width: 500px; margin: 0 auto; border-collapse: collapse; text-align: center;}
	table, tr, th, td {border: 1px solid blue;} 
	fieldset { width: 300px; margin: 0 auto;}
	h1{text-align: center;}
	a{text-decoration: none;}
</style>
</head>
<body>
	<div>
		<h1> 전체 정보 보기 </h1>
		<p>[<a href="join.jsp"> 인원 추가하기 </a>]</p>
		<table>
			<thead>
				<tr>
					<th>번호</th><th>아이디</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="k" items="${list}">
					<tr>
						<td>${k.idx}</td>
						<td><a href="onelist.jsp?idx=${k.idx}">${k.id }</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>