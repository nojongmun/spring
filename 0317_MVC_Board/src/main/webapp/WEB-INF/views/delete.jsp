<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  </title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 500px; border-collapse:collapse; margin-top: 100px;}
	table,tr,td{border: 1px solid black; padding: 3px}
</style>
<script type="text/javascript">
	function delete_ok(f) {
		if("${vo.pwd}" == f.pwd.value){
			var chk = confirm("정말 삭제할까요?");
			if(chk){
				f.action="delete_ok.do";
				f.submit();
			}else{
				history.go(-1);
			}
		}else{
			alert("비밀번호가 틀립니다.\n다시입력해주세요");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
	<div align="center">
		<form method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호확인</td>
					<td><input type="password" name="pwd" size ="20"/></td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="button" value="삭제" onclick="delete_ok(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="취소" />
							<input type="hidden" name="cPage" value="${cPage}" >
							<input type="hidden" name="idx" value="${vo.idx}" >
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>