<%@page import="com.ict.db.DAO"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.ict.db.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	request.setCharacterEncoding("utf-8");
	VO vo = new VO();
	vo.setIdx(request.getParameter("idx"));
    vo.setId(request.getParameter("id"));
    vo.setPw(request.getParameter("pw"));
    vo.setName(request.getParameter("name"));
    vo.setAge(request.getParameter("age"));
    vo.setAddr(request.getParameter("addr"));
    
    // DB처리를 위해서  DAO 호출
    //  WebApplicationContext context =
    //	WebApplicationContextUtils.getWebApplicationContext(application);
    //  DAO dao = (DAO)context.getBean("dao");
    
    DAO dao = (DAO)session.getAttribute("dao");
    
    int result = dao.getWrite(vo);
    pageContext.setAttribute("result", result);
    %>
    <c:choose>
    	<c:when test="${result>0}">
    		<script>
				alert("삽입성공");
				location.href = "list.jsp";
    		</script>
    	</c:when>
    	<c:otherwise>
    		<script>
				alert("삽입실패");
				history.go(-1);
    		</script>
    	</c:otherwise>
    </c:choose>

    
    
    
    
    
    
    
    
    