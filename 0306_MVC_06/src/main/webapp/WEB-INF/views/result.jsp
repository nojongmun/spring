<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 결과 보기  </h2>
	<h2> 결과 : ${s1} ${op} ${s2} = ${result}</h2>
	<h2> 결과 : ${cPage}</h2>
	<h2>
	  	<c:forEach var="k" items="${hobby}">
	  	<li>${k} &nbsp;&nbsp;</li>
	  	</c:forEach>
	</h2>
	<hr>
	<h2> 결과 : ${m.s1} ${m.op} ${m.s2} = ${result}</h2>
	<h2> 결과 : ${m.cPage}</h2>
	<h2>
	  	<c:forEach var="k" items="${m.hobby}">
	  	<li>${k} &nbsp;&nbsp;</li>
	  	</c:forEach>
	</h2>
</body>
</html>