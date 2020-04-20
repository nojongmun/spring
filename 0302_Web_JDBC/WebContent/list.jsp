<%@page import="com.ict.db.VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ict.db.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%
     ArrayList<VO> list = DAO.getInstance().getList();
     pageContext.setAttribute("list", list);
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
</style>
</head>
<body>
	<div>
		<h1> 전체 정보 보기 </h1>
		<table>
			<thead>
				<tr>
					<th>번호</th><th>아이디</th><th>이름</th><th>나이</th><th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="k" items="${list}">
					<tr>
						<td>${k.idx}</td>
						<td>${k.id }</td>
						<td>${k.name }</td>
						<td>${k.age }</td>
						<td>${k.addr }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>