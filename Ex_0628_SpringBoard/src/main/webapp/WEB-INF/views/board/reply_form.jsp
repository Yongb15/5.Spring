<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send_check(){
		let f = document.f; //f라는 name을 가진 form태그를 찾는다.
		
		f.submit(); //목적지로 input태그에 적혀있는 내용을 보낸다.
	}
</script>
</head>
<body>
<form name="f" action="reply" method="post">
		<input type="hidden" name="idx" value="${param.idx}">
		<input type="hidden" name="page" value="${param.page}">
		<table border="1">
			<caption>:::답 글 쓰기:::</caption>
			<tr>
				<th>제목</th>
				<td><input name="subject"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="10" cols="50" style="resize:none;"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password"></td>
			</tr>
			<tr>
				<td colspan="2">
					<img src="img/btn_reg.gif" onclick="send_check();">
					<img src="img/btn_back.gif" onclick="location.href='board_list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>