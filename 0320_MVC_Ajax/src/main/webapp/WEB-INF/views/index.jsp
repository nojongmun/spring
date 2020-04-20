<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{width: 80%}
	table, th, td { border: 1px solid red; text-align: center;}
</style>
<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn1").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "text.do",
				method : "post",
				dataType : "text",
				success : function(data) {
					$("#result").append(data);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		
		$("#btn2").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "xmltest.do",
				method : "post",
				dataType : "xml",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>종류</th><th>가격</th></tr></thead>";
					table += "<tbody>";
					$(data).find("product").each(function() {
						var name = $(this).find("name").text();
						var price = $(this).find("price").text();
						
						table +="<tr><td>"+name+"</td><td>"+price+"</td></tr>";
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		$("#btn3").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "xmltest2.do",
				method : "post",
				dataType : "xml",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>종류</th><th>가격</th></tr></thead>";
					table += "<tbody>";
					$(data).find("product").each(function() {
						var name = $(this).attr("name");
						var price = $(this).attr("price");
						
						table +="<tr><td>"+name+"</td><td>"+price+"</td></tr>";
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		$("#btn4").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "xmltest3.do",
				method : "post",
				dataType : "xml",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>종류</th><th>가격</th></tr></thead>";
					table += "<tbody>";
					$(data).find("product").each(function() {
						var name = $(this).text();// 태그의 텍스트
						var price = $(this).attr("price");     // 속성
						
						table +="<tr><td>"+name+"</td><td>"+price+"</td></tr>";
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		
		$("#btn5").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "htmltest.do",
				method : "post",
				dataType : "text",
				success : function(data) {
					$("#result").append(data);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		
		$("#btn6").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "xmltest4.do",
				method : "post",
				dataType : "xml",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>지역</th><th>온도</th><th>상태</th><th>아이콘</th></tr></thead>";
					table += "<tbody>";
					$(data).find("local").each(function() {
						var local = $(this).text();// 태그의 텍스트
						var ta = $(this).attr("ta");     // 속성
						var desc = $(this).attr("desc");     // 속성
						var icon = $(this).attr("icon");     // 속성
						
						table +="<tr><td>"+local+"</td><td>"+ta+"</td><td>"
							+ desc+"</td>"
						    +"<td><img src='http://www.kma.go.kr/images/icon/NW/NB"+
						    icon + ".png'></td></tr>"
					
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		
		$("#btn7").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "jsontest1.do",
				method : "post",
				dataType : "json",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>음료수 종류</th><th>가격</th></tr></thead>";
					table += "<tbody>";
					$.each(data,function(k,v){
						table += "<tr>";
						var name = v["name"];
						var price = v["price"];
						table += "<td>"+name+"</td><td>"+price+"</td>";
						table += "</tr>";
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		$("#btn8").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "jsontest2.do",
				method : "post",
				dataType : "json",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>도서관이름</th><th>주소</th><th>전화번호</th></tr></thead>";
					table += "<tbody>";
					$.each(data,function(k,v){
						var k = v['row'];
						$.each(k,function(k,v){
							table += "<tr>";
							table += "<td>"+v["LBRRY_NAME"]+"</td>" ;
							table += "<td>"+v["ADRES"]+"</td>" ;
							table += "<td>"+v["TEL_NO"]+"</td>" ;
							table += "</tr>";
						});
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		$("#btn9").click(function() {
			$("#result").empty(); // 초기화
			$.ajax({
				url: "jsontest3.do",
				method : "post",
				dataType : "json",
				success : function(data) {
					var table = "<table>";
					table += "<thead><tr><th>판매처 이름</th><th>판매처 주소</th></tr></thead>";
					table += "<tbody>";
					$.each(data,function(k,v){
						var k2 = data['storeInfos'];
						$.each(k2,function(k,v){
							table += "<tr>";
							table += "<td>"+v["addr"]+"</td>" ;
							table += "<td>"+v["name"]+"</td>" ;
							table += "</tr>";
						});
					});
					table +="</tbody></table>";
					$("#result").append(table);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
	});
</script>
</head>
<body>
	<h1> Ajax 예제 </h1>
	<hr />
	<button id="btn1"> 텍스트 </button>
	<button id="btn2"> XML </button>
	<button id="btn3"> XML_Attr </button>
	<button id="btn4"> XML_final </button>
	<button id="btn5"> 외부 XML_html </button>
	<button id="btn6"> 외부 XML </button>
	<button id="btn7"> json </button>
	<button id="btn8"> 외부_json </button>
	<button id="btn9"> 외부_json </button>
	<br>
	<hr>
	<br>
	<div id="result"></div>
</body>
</html>