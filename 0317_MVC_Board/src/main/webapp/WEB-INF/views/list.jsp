<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
	text-align: center;
	padding: 4px 10px;
	background-color: #F6F6F6;
}

th {
	text-align: center;
	padding: 4px 10px;
	background-color: #B2CCFF;
}
table{ width: 700px; 
		margin: 0 auto;	}
h2{text-align: center;}
a{text-decoration: none;}
a:link, a:visited, a:active {color: black;}
</style>
<script type="text/javascript">
	function write_go() {
		location.href="write.do";
	}
</script>
</head>
<body>
	<h2>Board 리스트</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list}">
				<tr>
					<td colspan="5"><h3> 자료가 존재하지 않습니다.</h3> </td>
				</tr>
				</c:when>
				<c:otherwise>
				<c:forEach var="k" items="${list}" varStatus="vs">
					<tr>
						<td>${paging.totalRecord-((paging.nowPage-1)*paging.numPerPage+vs.index)}</td>
						<td style="width: 50%; text-align: left;">
							<c:forEach begin="1" end="${k.step}">
							     &nbsp;&nbsp;[RE]
							</c:forEach>
						<a href="view.do?idx=${k.idx}&cPage=${paging.nowPage}">${k.title}</a>
						</td>
						<td>${k.writer }</td>
						<td>${k.regdate.substring(0,10)}</td>
						<td>${k.hit}</td>
					</tr>
				</c:forEach>	
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<!-- 이전 -->
					<c:choose>
						<c:when test="${paging.beginBlock > paging.pagePerBlock }">
							<a href="list.do?cPage=${paging.beginBlock-paging.pagePerBlock}"> 
								<span style="background:#B2CCFF "><font size="4" >이전으로</font></span>&nbsp;&nbsp;&nbsp;&nbsp;	 
							</a>
						</c:when>
						<c:otherwise>
							<font size="4" style="color: gray;"><b>이전으로</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
					<!-- 페이지번호 -->
					<c:forEach begin="${paging.beginBlock}" end="${paging.endBlock}" step="1" var="k">
						<c:choose>
							<c:when test="${k==paging.nowPage }">
								<font size="4">${k}</font>&nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								<span style="background:#B2CCFF "><a href="list.do?cPage=${k}"><font size="4">${k}</a></font></span>&nbsp;&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<!-- 다음 -->
					<c:choose>
						<c:when test="${paging.endBlock < paging.totalPage }">
							<a href="list.do?cPage=${paging.beginBlock+paging.pagePerBlock}">
								<span style="background:#B2CCFF ">
									<font size="4" >다음으로</font>
								</span>&nbsp;&nbsp;&nbsp;&nbsp;
							</a>
						</c:when>
						<c:otherwise>
							<font size="4" style="color: gray;"><b>다음으로</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<img  src="resources/img/but_write.gif" onclick="write_go()">
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>