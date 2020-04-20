<%@page import="com.ict.db.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%  request.setCharacterEncoding("utf-8");  %>

<jsp:useBean id="vo" class="com.ict.db.VO" />
<jsp:setProperty property="*" name="vo"/>
<%
    DAO dao = (DAO)session.getAttribute("dao");
	int result = dao.getInsert(vo); 
    pageContext.setAttribute("result", result); 
%>

<c:choose>
	<c:when test="${ result > 0 }">
		<script>
			alert("삽입 성공");
			location.href ="index.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("삽입 실패");
			location.href ="write.jsp";
			/* history.go(-1); */
		</script>
	</c:otherwise>
</c:choose>