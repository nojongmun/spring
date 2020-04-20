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
	function sendData(f) {
		for (var i = 0; i < f.elements.length; i++) {
			if ( f.elements[i].value == "") {
				if (i == 3)
					continue;
				alert(f.elements[i].name + "를 입력하세요");
				f.elements[i].focus();
				return;//수행 중단
			}
		}
		if("${vo.pwd}" == f.pwd.value){
			f.action ="update_ok.do";
			f.submit();
		}else{
			alert("비밀번호 틀림\다시 입력해 주세요");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
	function list_go(f) {
		f.action="list.do";
		f.submit();
	}
</script>
</head>
<body>
	<h2> Board 글 수정 </h2>	
	<form  method="post" enctype="multipart/form-data">
		<table width="700">
		<tbody>
			<tr>
				<th>작성자</th>
				<td align="left"><input type="text" name="writer" value="${vo.writer }"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td align="left"> <input type="text" name="title" value="${vo.title }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="left"><textarea rows="10" cols="60" name="content">${vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<c:choose>
					<c:when test="${empty vo.file_name}">
						<td> 
							<h3> 첨부파일없음</h3>
							<input type="file" name="file" />
						</td>
					</c:when>
					<c:otherwise>
						<td>
							<input type="file" name="file" /> ${vo.file_name}
						</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td align="left"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정하기" onclick="sendData(this.form)" /> 
					<input type="button" value="목록" onclick="list_go(this.form)" />
					<input type="hidden" name="cPage" value="${cPage}" />
					<input type="hidden" name="idx" value="${vo.idx}" />
					<input type="reset" value="취소" />
				</td>
			</tr>
            </tbody>
		</table>
	</form>
</body>
</html>