<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
		
	    text-align:center;
	    padding:4px 10px;
	    background-color: #F6F6F6;
	}
	
th {
		width:120px;
	    text-align:center;
	    padding:4px 10px;
	    background-color: #B2CCFF;
	}
table{ width: 700px; 
		margin: 0 auto;	}
h2{text-align: center;}
</style>
<script type="text/javascript">
	function list_go(f) {
		f.action="list.do";
		f.submit();
	}
	function ans_write(f) {
		f.action="ans_write.do";
		f.submit();
	}
	function update_go(f) {
		f.action="update_go.do";
		f.submit();
	}
	function delete_go(f) {
		f.action="delete_go.do";
		f.submit();
	}
</script>
</head>
<body>
	<h2> Board 상세보기 </h2>
	<form method="post">
	<table>
		<tbody>
			<tr>
				<th bgcolor="#B2EBF4">작성자</th>
				<td>${vo.writer} </td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">제목</th>
				<td> ${vo.title }</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">작성일</th>
				<td>${vo.regdate} </td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">첨부파일</th>
				<td>
					<c:choose>
						<c:when test="${empty vo.file_name}">
							<b> 첨부파일 없음 </b>
						</c:when>
						<c:otherwise>
							<img  src="<c:url value='resources/upload/${vo.file_name}'/>" width="150px"><br>
							<a href="download.do?file_name=${vo.file_name}"> ${vo.file_name}</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th bgcolor="#B2EBF4">내용</th>
				<td style="text-align: left; padding-left:50px;"><pre>${vo.content}</pre></td>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
			     <td colspan="2">
			        <input type="button" value="목록" onclick="list_go(this.form)" />
			        <input type="button" value="답글" onclick="ans_write(this.form)" />
			        <input type="button" value="수정" onclick="update_go(this.form)" />
			        <input type="button" value="삭제" onclick="delete_go(this.form)" />
			     	<input type="hidden" value="${cPage}" name="cPage" />
			     </td>
			</tr>
		</tfoot>
	</table>
	</form>
</body>
</html>