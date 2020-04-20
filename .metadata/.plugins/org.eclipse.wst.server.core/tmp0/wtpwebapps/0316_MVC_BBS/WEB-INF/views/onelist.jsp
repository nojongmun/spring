<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>
<script type="text/javascript">
	function list_go(f) {
		f.action="list.do";
		f.submit();
	}
	function delete_go(f) {
		f.action="delete.do";
		f.submit();
	}
	function update_go(f) {
		f.action="update.do";
		f.submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form method="post">
		<table summary="게시판 ">
			<caption>게시판</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td>${bvo.subject }</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td>${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><pre> ${bvo.content } </pre></td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<td>
						<c:choose>
							<c:when test="${! empty bvo.file_name}">
							   <a href="down.do?file_name=${bvo.file_name}">${bvo.file_name}</a>
							</c:when>
							<c:otherwise>
								<b> 첨부파일 없음 </b>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="button" value="수정" onclick="update_go(this.form)"/>
						<input type="button" value="삭제" onclick="delete_go(this.form)"/>
						<input type="button" value="목록" onclick="list_go(this.form)"/>
						<input type="hidden" name="cPage" value="${cPage}" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<!-- 댓글처리  -->
	<br>
	<hr>
	<br>
	<div style="border: 1px solid blue; width: 60%; margin: 0px auto; padding: 5px 50px;">
		<form method="post" action="c_write.do">
			<p> 이름 : <input type="text" name="writer" size="15"></p>
			<p> 내용 : <br>
			  <textarea rows="4" cols="40" name="content"></textarea>
			</p>  
			<p> 비밀번호 : <input type="password" name="pwd" size="15"></p>
			<input type="hidden" name="b_idx" value="${bvo.b_idx}" >
			<input type="submit" value="댓글 저장" >
		</form>
	</div>
	<br>
	<hr>
	<%-- 댓글출력 --%>
	<div style="display: table; margin: 0px auto;">
		<c:forEach var="k" items="${c_list}">
			<div style="border: 1px solid #cc00cc; width: 400px; margin:20px; padding: 20xp;">
				<form action="c_del.do" method="post">
					<p style="margin: 10px;"> 이름 : ${k.writer } </p>
					<p style="margin: 10px;"> 날짜 : ${k.write_date.substring(0,10) } </p>
					<p style="margin: 10px;"> 내용 : <pre style="margin: 10px;">${k.content }</pre></p>
					<input type="hidden" name="c_idx" value="${k.c_idx}">
					<input type="hidden" name="b_idx" value="${k.b_idx}">
					<input type="submit" value="댓글 삭제">
				</form>
			</div>
			<hr>
		</c:forEach>	
	</div>
</body>
</html>













