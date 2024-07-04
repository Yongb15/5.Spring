<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//모든 칸에 입력을 받아야 넘어갈 수 있다.(입력안하면 경고창 띄우기)
	//전송방식 :post
	//목적지 : insert
	
	function send_check(){
		let f = document.f; //f라는 이름을 가진 form태그
		let name = f.name.value;
		let subject = f.subject.value;
		let content = f.content.value;
		
		if(subject == ''){
			alert("제목을 입력하세요");
			return;
		}
		
		if(name == ''){
			alert('이름을 입력하세요')
			return;
		}
		
		if(content == ''){
			alert("내용을 입력하세요")
			return;
		}
		
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
					<img src="resources/img/btn_reg.gif" onclick="send_check();">
					<img src="resources/img/btn_back.gif" onclick="location.href='board_list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>




