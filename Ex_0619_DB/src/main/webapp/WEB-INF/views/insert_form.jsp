<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//action : insert1
	//method : post
	//insert_result.jsp에서 출력하세요
	//이름 : XX
	//나이 : XX
	function send1(f){
		f.action = "insert1";
		f.method = "post";
		f.submit();
	}
	
	function send2(f){
		f.action = "insert2";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>:::개인정보 입력:::</caption>
			<tr>
				<th>이름</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input name="age"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="낱개로 받기" onclick="send1(this.form)">
					<input type="button" value="객체로 받기" onclick="send2(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>