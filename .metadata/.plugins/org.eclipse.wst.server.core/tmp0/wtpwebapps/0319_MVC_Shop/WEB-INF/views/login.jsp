<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style type="text/css">
	table{
		margin: 10px auto;
		width: 300px;
		border-collapse: collapse;
		font-size: 15pt;
		border-color: navy;
	}
	table, th, td{
		border: 2px solid skyblue;
		text-align: center;
	}
</style>
<script type="text/javascript">
	function login_go(f) {
		f.action="login_ok.do";
		f.submit();
	}
	function join_go(f) {
		f.action="join.do";
		f.submit();
	}
</script>
</head>
<body>
<jsp:include page="top.jsp" />
	<div>
		<form method="post">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h2>LogIn</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" name="pw"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="로그인" onclick="login_go(this.form)" >
							<input type="button" value="회원가입" onclick="join_go(this.form)" >
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>