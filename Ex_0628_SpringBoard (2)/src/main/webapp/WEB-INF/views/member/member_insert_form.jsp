<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	let b_idCheck = false;

	function check_id(){
		let id = document.getElementById("id").value.trim();
		if(id == ''){
			alert('아이디를 입력하세요')
			return;
		}
		
		//아이디를 입력하지 않았을 때 "아이디를 입력하세요"
		//fetch()를 이용하고
		//mapping : check_id
		//파라미터 : id
		//전송방식은 post
		//중복이 되면 "이미 있는 아이디 입니다."
		//중복이 안되면 "사용 가능한 아이디입니다."
		let formBody = "id="+id
		
		fetch("check_id",{
			method : 'post',//전송방식
			//headers : 내가 전달할 내용의 인코딩타입
			headers : {'Content-Type' : 'application/x-www-form-urlencoded'},
			//파라미터 전달
			body : formBody
		})
		.then(response => response.json())
		.then(data => {
			if(data.res === 'yes'){
				alert('사용가능한 아이디 입니다.')
				b_idCheck = true
				return
			} else {
				alert('이미 사용중인 아이디 입니다.')
				return;
			}
		})
		
		
		
		
	}

</script>
</head>
<body>
	<form>
		<table border="1">
			<caption>:::회원가입:::</caption>
			<tr>
				<th>아이디</th>
				<td>
					<input name="id" id="id">
					<input type="button" value="중복체크" onclick="check_id()">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input name="name">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input name="pwd" type="password">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input name="email">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="가입" onclick="send(this.form)">
					<input type="button" value="취소" onclick="location.href='board_list'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>





