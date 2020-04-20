<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");

   String path = request.getParameter("path"); 
   String f_name = request.getParameter("file_name");
   
   // 실제 저장위치
   String r_path = getServletContext().getRealPath("/"+path);
   
   // 다운로드 받을 수 있도록 클라이언트 (웹 브라우저의 문서 타입 변경)
   response.setContentType("application/x-msdownload");
   
   // http헤더 정보를 첨부파일에 존재하는 것으로 변경
   response.setHeader("Content-Disposition", 
		   "attachment; filename="+ URLEncoder.encode(f_name,"utf-8"));
 
  //////////// 실제 바이트 스트림을 이용해서 다운로드 해야 된다. ///////////
  
  // 저장된 폴더에서 해당 파일 선택
  File file = new File(r_path+"/"+new String(f_name.getBytes("utf-8")));
  int b;
  FileInputStream fis = null;
  BufferedInputStream bis = null;
  BufferedOutputStream bos = null;
  try{
	  fis = new FileInputStream(file);
	  bis = new BufferedInputStream(fis);
	  
	  bos = new BufferedOutputStream(response.getOutputStream());
	  while((b=bis.read()) != -1){
		  bos.write(b);
		  bos.flush();
	  }
	  out.clear();
	  out = pageContext.pushBody();
  }catch(Exception e){
	  System.out.println(e);
  }finally{
	  try{
		  bos.close();
		  bis.close();
		  fis.close();
	  }catch(Exception e){
		  System.out.println(e);
    }
  }
%>














