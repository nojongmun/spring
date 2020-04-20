<%@page import="com.ict.db.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
    String idx = request.getParameter("idx");
    
    DAO dao = (DAO)session.getAttribute("dao");
    int result = dao.getDelete(idx); 
    if(result>0){
       response.sendRedirect("list.jsp");
    }else{ %>
       <script>
         alert("삭제 실패");
         history.go(-1);     
       </script>
   <%}%>    
