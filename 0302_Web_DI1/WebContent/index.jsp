<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.ict.edu.HelloImpl"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%--     
	<%
	    //  스트립 트립에서 자바 main 메소드에서 코딩한 내용 그대로 코딩하면서 출력 위치만 
    	// Web 브라우저로 변경해서 사용가능하다.
		ApplicationContext context = 
			new GenericXmlApplicationContext("com/ict/edu/Configuration.xml");

		HelloImpl hello = (HelloImpl)context.getBean("hello");
		out.println("<h2>"+hello.sayHello()+"</h2>");
	%>
	 --%>
	
	<%
	   // 웹 전용 방식
	   // Configuration.xml  = application = 설정정보파일을 뜻한다.
	   // 서블릿 3.0 이상에서는 WEB-INF 안에 applicationContext.xml를 지정하고 있다.
	   // (위치와 이름이 지정되어 있다. (단, web.xml를 이용하면 변경 가능하다.))
	   //  WEB-INF 안에 존재하는 파일들은 일반적으로는 읽을 수 가 없다.
	   // 추가적으로 리스너를 만들어 주어야  applicationContext.xml 읽을 수 있다. 
	   // 참고로 리스너는 프로젝트당 하나면 되고  만드는 방법은 2가지다.
	   // 1. 자바에서 리스너 생성하기,   2. web.xml에서 리스너 생성하기 
	   
	   WebApplicationContext context =
	   	 WebApplicationContextUtils.getWebApplicationContext(application);
	
		HelloImpl hello = (HelloImpl)context.getBean("hello");
	   out.println("<h2>"+hello.sayHello()+"</h2>");
	%>
	
</body>
</html>







