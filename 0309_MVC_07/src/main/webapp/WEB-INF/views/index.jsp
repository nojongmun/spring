<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function f_up(f) {
		f.action="f_up.do";
		f.submit();
	}
	function f_up2(f) {
		f.action="f_up2.do";
		f.submit();
	}
</script>
</head>
<body>
	<a href="index.do"> 그림 보기 </a>
	<hr>
	<form method="post" enctype="multipart/form-data">
		<p> 올린 사람 : <input type="text" name="name"></p>
		<p> 파일 : <input type="file" name="file_name"></p>
		<p> <input type="button" value="업로드" onclick="f_up(this.form)"></p>
	</form>
	<hr>
	<form method="post" enctype="multipart/form-data">
		<p> 올린 사람 : <input type="text" name="u_name"></p>
		<p> 파일 : <input type="file" name="f_name"></p>
		<p> <input type="button" value="업로드" onclick="f_up2(this.form)"></p>
	</form>
</body>
</html>