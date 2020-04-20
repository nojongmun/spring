<%@page import="com.ict.edu.Service"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	   WebApplicationContext context =
	   	  WebApplicationContextUtils.getWebApplicationContext(application);
	
	    Service ser = (Service) context.getBean("ser");
	    String msg =  ser.biz();
	    pageContext.setAttribute("msg", msg);
	%>
	<h2> ${msg} </h2>
</body>
</html>