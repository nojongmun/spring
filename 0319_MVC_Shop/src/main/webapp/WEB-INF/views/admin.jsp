<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style type="text/css">
	table {
		margin: 10px auto;
		width: 600px;
		border-collapse: collapse;
		font-size: 12pt;
		border-color: navy;
	}
	
	table, th, td {
		border: 1px solid black;
		text-align: center;
	}
	h2{text-align: center;}
</style>
<script type="text/javascript">
	function add_product(f) {
		f.action="addproduct.do";
		f.submit();
	}
</script>
</head>
<body>
	<c:if test="${empty admin}">
		<script type="text/javascript">
			alert("관리자만 상품을 등록 할 수 있습니다.")
			location.href="login.do";
		</script>
	</c:if>
	<h2> 상품 등록 페이지 </h2>
	<form method="post" enctype="multipart/form-data">
		<table>
			<tbody>
				<tr >
					<th width="30%">분류</th>
					<td> 
						<input type="radio" name="category" value="com001" > 컴퓨터 
						<input type="radio" name="category" value="ele002" > 가전제품
						<input type="radio" name="category" value="sp003" > 스포츠
					</td>
				</tr>
				<tr>
					<th> 제품번호 </th>
					<td> <input type="text" name="p_num"></td>
				</tr>
				<tr>
					<th> 제품명 </th>
					<td> <input type="text" name="p_name"></td>
				</tr>
				<tr>
					<th> 판매사 </th>
					<td> <input type="text" name="p_company"></td>
				</tr>
				<tr>
					<th> 제품가격 </th>
					<td> <input type="text" name="p_price"></td>
				</tr>
				<tr>
					<th> 할인가 </th>
					<td> <input type="text" name="p_saleprice"></td>
				</tr>
				<tr>
					<th> 제품이미지S </th>
					<td> <input type="file" name="s_file"></td>
				</tr>
				<tr>
					<th> 제품이미지L </th>
					<td> <input type="file" name="l_file"></td>
				</tr>
				<tr>
					<th colspan="2"> 상품내용 </th>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="10" cols="100" name="p_content"></textarea> </td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="상품등록" onclick="add_product(this.form)">
					</td>
				</tr>
			</tfoot>
		</table>
	</form> 
</body>
</html>