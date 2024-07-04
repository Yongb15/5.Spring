<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//아이디랑 비밀번호를 입력하지 않으면
	//넘어가지 않도록 경고
	//fetch() 사용하기
	//파라미터 : id, pw
	//mapping : login
	//전송방식은 post
	//로그인 시도할 때 아이디가 없거나, 비밀번호가 틀렸을 때 
	//"아이디나 비밀번호가 잘못되었습니다."라고 경고
	//로그인 성공시 "로그인 성공"띄우고 메인화면으로 이동하기
	function send(f){
		let id = f.id.value;
		let pwd = f.pwd.value;
		
		if(id == ''){
			alert("아이디를 입력해주세요");
			return;
		}
		
		if(pwd == ''){
			alert("비밀번호를 입력해주세요");
			return;
		}
		
		formBody = "id="+id+"&pwd="+pwd;
		//자바스크립트에 내장되어있는 비동기통신을 위한 메서드
		//get방식으로 비동기통신을 할 때는 url만 전달해도 된다.
		//fetch(url)
		//post방식으로 통신을 할 때는 옵션도 함께 줘야한다.
		//fetch(url, {옵션})
		fetch("login",{
			method : 'post',//전송방식
			//headers : 내가 전달할 내용의 인코딩타입
			headers : {'Content-Type' : 'application/x-www-form-urlencoded'},
			//파라미터 전달
			body : formBody
		})
		.then(response => response.json())
		.then(data =>{
			if(data.param === 'yes'){
				alert('로그인 성공')
				location.href='board_list';
			} else {
				alert('아이디나 비밀번호가 틀렸습니다.')
			}
		})
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>:::로그인:::</caption>
			<tr>
				<th>아이디</th>
				<td><input name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" type="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="로그인" onclick="send(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>