<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//모든 칸에 입력을 받아야 넘어갈 수 있다.(입력안하면 경고창 띄우기)
	//서블릿 : BoardInsertAction
	//mapper id : board_insert
	function send_check(){
		let f = document.f;
		//유효성 검사
		
		f.submit();
	}
</script>
</head>
<body>
	<form name="f" action="insert" method="post">
		<table border="1">
			<caption>:::새 글 쓰기:::</caption>
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




