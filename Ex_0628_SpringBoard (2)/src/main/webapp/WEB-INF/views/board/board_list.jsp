<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 a{text-decoration: none;}
 table{border-collapse: collapse;}
</style>
</head>
<body>
	<table border="1" width="700">
		<tr>
			<td colspan="5"><img src="resources/img/title_04.gif"></td>
		</tr>
		<tr>
			<td colspan="5" align="right">
			<c:choose>
				<c:when test="${empty id }">
					<input type="button" value="로그인" onclick="location.href='login_form'">
					<input type="button" value="회원가입" onclick="location.href='member_insert_form'">
				</c:when>
				<c:when test="${not empty id}">
					<input type="button" value="로그아웃" onclick="location.href='logout'">
				</c:when>
			</c:choose>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<!--게시판 글 조회하기
		서블릿 : BoardListAction
		mappng : board_list  -->
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.idx}</td>
			<td>
			<c:forEach begin="1" end="${vo.depth}">&nbsp;</c:forEach>
			<c:if test="${vo.depth ne 0 }">ㄴ</c:if>
			<!-- 게시글 제목을 눌렀을 때 내용을 조회하기 
			서블릿 : BoardViewAction
			매핑 : view
			jsp : board_view.jsp-->
			<c:if test="${vo.del_info ne -1 }">
			<a href="view?idx=${vo.idx}&page=${param.page}">
			<font color="black">${vo.subject}</font>
			</a>
			</c:if>
			
			<!-- 삭제한 글은 누를 수 없도록 처리 -->
			<c:if test="${vo.del_info eq -1 }">
			<font color="gray">${vo.subject}</font>
			</c:if>
			</td>
			<td>${vo.name}</td>
			<td>${fn:split(vo.regdate,' ')[0]}</td>
			<td>${vo.readhit}</td>
		</tr>	
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				 ${pageMenu}
			</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<img src="resources/img/btn_reg.gif" onclick="location.href='insert_form'" style="cursor:pointer;">
	</table>
</body>
</html>




