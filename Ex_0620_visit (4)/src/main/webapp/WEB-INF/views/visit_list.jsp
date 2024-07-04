<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- webapp폴더 까지의 경로 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/visit.css">
<script type="text/javascript">
	//비밀번호를 입력하지 않았을 때 넘어가지 못하게 하기
	//목적지는 delete
	//파라미터는 idx, pwd
	//fetch api를 통해서 전달하고 삭제하기
	//삭제실패 또는 삭제 성공 알림창으로 출력하기
	function del(f){
		let pwd = f.pwd.value;
		if(pwd == ''){
			alert("비밀번호를 입력하세요")
			return
		}
		
		if(!confirm("삭제하시겠습니까")){
			return;
		}
		
		let url = "delete?idx="+f.idx.value+"&pwd="+pwd;
		
		fetch(url)
		.then(response=>response.json())
		.then(data => {
			if(data.res === 'yes'){
				alert('삭제 성공')
				location.href='visit_list'
			} else{
				alert('삭제 실패');
				return;
			}
		})
	}
	
	function modify(f){
		let ori_pwd = f.ori_pwd.value; //원본비밀번호
		let pwd = f.pwd.value; //입력한 비밀번호
		
		if(ori_pwd != pwd){
			alert("비밀번호 불일치");
			return;
		}
		
		f.action = "modify_form";
		f.method = "post";
		f.submit();
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1>방명록 리스트</h1>
		<input type="button" value="글쓰기" onclick="location.href='insert_form'">
	</div>
	<c:forEach var="vo" items="${list}">
		<div class="visit_box">
			<div class="type_content"><pre>${vo.content}</pre></div>
			<div class="type_name">작성자 : ${vo.name}(${vo.ip})</div>
			<div class="type_regdate">작성일 : ${vo.regdate}</div>
			<div>
				<form>
					<input type="hidden" name="idx" value="${vo.idx}">
					<input type="hidden" name="ori_pwd" value="${vo.pwd}">
					비밀번호 : <input type="password" name="pwd">
					<input type="button" value="수정" onclick="modify(this.form)">
					<input type="button" value="삭제" onclick="del(this.form)">
				</form>
			</div>
		</div>
	</c:forEach>
</body>
</html>





