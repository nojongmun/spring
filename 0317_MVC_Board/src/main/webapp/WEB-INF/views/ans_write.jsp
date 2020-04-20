<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		f.action ="ans_write_ok.do";
		f.submit();
	}
	function view_go(f) {
		f.action ="view.do?idx=${vo.idx}";
		f.submit();
	}
</script>
</head>
<body>
	<h2> Board 댓글쓰기 </h2>	
	<form  method="post" enctype="multipart/form-data">
		<table width="700">
		<tbody>
			<tr>
				<th>작성자</th>
				<td align="left"><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td align="left"> <input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td align="left"><textarea rows="10" cols="60" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td align="left"><input type="file" name="file"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td align="left"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="button" value="댓글입력" onclick="sendData(this.form)" />
				<input type="button" value="되돌아가기" onclick="view_go(this.form)" />
				<input type="reset" value="취소" />
				<%-- 댓글 처리를 위해서 groups, step, lev를 가지고 가야 한다. --%>
				<input type="hidden" name="groups" value="${vo.groups }">
				<input type="hidden" name="step" value="${vo.step }"> 
				<input type="hidden" name="lev"  value="${vo.lev }"> 
				<input type="hidden" name="cPage" value="${cPage}">  
				</td>
			</tr>
            </tbody>
		</table>
	</form>
</body>
</html>