<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$( "#date" ).datepicker();
		$( "#re_date" ).datepicker();
		
		$("#btn1").click(function(){
			var date = $("#date").val();
			var content = $("#content").val();
			
			$("#result").append(date+"<br>");
			$("#result").append(content+"<br>");
			$("#result").append("--------<br>");
		});
	});
	
	function send_go(f) {
		f.action="reservation.do";
		f.submit();
	}
</script>
</head>
<body>
	<!-- 결과를 아래에 보는 방법  -->
	<p>Date: <input type="text" id="date"></p>
	<p>
	    content : <br>
	    <textarea rows="5" cols="100" id="content"></textarea>  
	</p>
	<button id="btn1"> 아래에 결과 보내기 </button>
	<hr>
	<h2> 결과 보기  </h2>
	<div id="result"></div>
	<hr>
	
	<!-- 컨트롤러에 정보를 넘겨서 DB처리할 수 있도록 한다. -->
	<form method="post">
		<p>Date: <input type="text" id="re_date" name="re_date"></p>
	<p>
	    content : <br>
	    <textarea rows="5" cols="100" id="re_content" name="re_content"></textarea>  
	</p>
	<input type="button" value="컨트롤러에 정보 보내기" onclick="send_go(this.form)">
	</form>
	<hr>
	<h2> 결과 보기  </h2>
	<div> ${re_date}<br>${re_content}</div>
	<hr>
</body>
</html>










