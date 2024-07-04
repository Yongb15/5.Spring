<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//목적지 : modify
	//httpmethod : post
	//ip까지 객체에 추가하여 db에 수정해주기
	function send(f){
		f.action = "modify";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<input type="hidden" name="idx" value="${vo.idx}">
		<table border="1">
			<caption>:::방명록 수정:::</caption>
			<tr>
				<th>작성자</th>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="5" cols="50" name="content" style="resize:none;">${vo.content}</textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${vo.pwd }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="send(this.form)">
					<input type="button" value="취소" onclick="locaion.href='visit_list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>









