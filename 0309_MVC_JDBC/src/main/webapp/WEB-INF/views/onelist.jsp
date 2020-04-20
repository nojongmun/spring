<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
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
		<h1> 상세보기 </h1>
		<table>
			<thead>
				<tr>
					<th>번호</th><th>아이디</th><th>패스워드</th><th>이름</th><th>나이</th><th>주소</th><th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${onevo.idx}</td>
					<td>${onevo.id }</td>
					<td>${onevo.pw }</td>
					<td>${onevo.name }</td>
					<td>${onevo.age }</td>
					<td>${onevo.addr}</td>
					<td><a href="delete.do?idx=${onevo.idx}"><button> 삭제 </button></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>