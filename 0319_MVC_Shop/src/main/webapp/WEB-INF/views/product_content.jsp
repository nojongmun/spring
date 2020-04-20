<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	margin: 10px auto;
	width: 600px;
	border-collapse: collapse;
	font-size: 8pt;
	border-color: navy;
}

table, th, td {
	border: 1px solid black;
}
</style>
<script type="text/javascript">
function add_cart() {
	if(${login=='ok'}){
		location.href="addcart.do?idx=${vo.idx}&id=${mvo.id}";
	}else{
		alert("로그인하세요");
		location.href="login.do";
	}
}

function view_cart() {
	if(${login=='ok'}){
		location.href="viewcart.do?id=${mvo.id}";
	}else{
		alert("로그인하세요");
		location.href="login.do";
	}
}
</script>
</head>
<body>
	<jsp:include page="top.jsp" />
	<table>
		<tr>
			<td width="40%">제품Category</td>
			<td width="60%"> ${vo.category}</td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%">${vo.p_num }</td>
		</tr>
		<tr>
			<td width="40%">제품이름</td>
			<td width="60%">${vo.p_name}</td>
		</tr>
		<tr>
			<td width="40%">제품판매사</td>
			<td width="60%">${vo.p_company}</td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%">시중가 : <fmt:formatNumber value="${vo.p_price}" pattern="#,##0" />원
				<font color="red">(할인가: <fmt:formatNumber value="${vo.p_saleprice}" pattern="#,##0" />원)</font></td>
		</tr>
		<tr>
			<td width="40%">제품설명</td>
			<td width="60%">${vo.p_content}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<img src="resources/images/${vo.p_image_l}" width="450px"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			   <button onclick="add_cart()">장바구니에 담기</button>
			   <button onclick="view_cart()">장바구니에 보기</button>
			</td>
		</tr>
	</table>
</body>
</html>