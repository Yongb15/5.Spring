<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//각각의 칸에 입력되지 않았을 때 경고 하고 못넘어가게 하기
	//mapping : insert
	//메서드명 : insert
	//데이터베이스에 추가하고
	//visit_list로 돌아오기 "redirect:visit_list"
	function send(f){
		let name = f.name.value;
		let content = f.content.value;
		let pwd = f.pwd.value
		
		if(name == ''){
			alert("이름을 입력하세요")
			return;
		}
		
		if(content == ''){
			alert('내용을 입력하세요')
			return;
		}
		if(pwd == ''){
			alert('비밀번호를 입력하세요')
			return;
		}
		
		f.action = "insert"
		f.method = "post"
		f.submit();
		
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>::새글 작성하기::</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name" style="width:250px;"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="50" name="content" style="resize:none;"></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="등록하기" onclick="send(this.form)">
				<input type="button" value="목록으로"	onclick="location.href='visit_list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>