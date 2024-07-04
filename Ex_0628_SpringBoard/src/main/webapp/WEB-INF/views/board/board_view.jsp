<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function reply(){
		location.href="reply_form.jsp?idx=${vo.idx}&page=${param.page}";
	}
	//삭제할것인지 confirm()메서드를 통해 확인한다.(아니오 누르면 가만히 있기)
	//원본 비밀번호와 내가 입력한 비밀번호가 일치하는지 확인
	//(일치하지 않으면 비밀번호 불일치라고 경고)
	//서블릿 : BoardDeleteAction
	//매핑 : del
	//파라미터 : idx
	//feth() 를 이용하여 비동기 통신하기(post)
	
	//삭제하려는 게시물의 제목을 "삭제된 글입니다."
	//삭제하려는 게시물의 작성자를 "unknown"으로 수정하기
	//dao에 메서드는 del_update라고 작성한다.
	
	//수정됐으면 "삭제되었습니다"
	//수정안됐으면 "삭제에 실패했습니다."라고 경고 띄우기
	
	function del(){
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		
		let pwd = ${vo.pwd};//원본 비밀번호
		let c_pwd = document.getElementById("c_pwd").value;
		
		if(pwd != c_pwd){
			alert("비밀번호 불일치");
			return;
		}
		
		formBody = "idx=${vo.idx}";
		fetch("del",{
			method : 'post',
			headers : {'Content-Type' : 'application/x-www-form-urlencoded'},
			body : formBody
		})
		.then(response => response.json())
		.then(data =>{
			if(data.param === 'yes'){
				alert('삭제되었습니다.')
				location.href='board_list?page=${param.page}';
			} else {
				alert('삭제 실패')
			}
		})
	}

</script>
</head>
<body>
	<table border="1">
		<caption>:::게시글 상세보기:::</caption>
		<tr>
			<th>제목</th>
			<td>${vo.subject}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.regdate}</td>
		</tr>
		<tr>
			<th>ip</th>
			<td>${vo.ip}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="500px" height="200px"><pre>${vo.content}</pre></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="c_pwd"></td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="resources/img/btn_list.gif" onclick="location.href='board_list?page=${param.page}'">
				<!-- 게시글의 depth가 1보다 작을 때만 보이게 수정하기 -->
				<c:if test="${vo.depth lt 1}">
				<img src="resources/img/btn_reply.gif" onclick="reply()">
				</c:if>
				
				<img src="resources/img/btn_delete.gif" onclick="del()">
			</td>
		</tr>
	</table>
</body>
</html>