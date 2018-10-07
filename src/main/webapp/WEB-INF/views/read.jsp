<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
	<head>
	<title>: : : : : Y U J U N : : : : :</title>
	
	<!-- jQuery -->
	<script src="/resources/js/jquery.min.js"></script>
	
	<script>
	$(function() {
		$('#delete').on('click', function(){
		alert();
			$.ajax({
				url : "board/delete/${board_num}",
				type : "post",
			}).done(function(responseData){
				var data = responseData;
				
				if(data.indexOf('success') != -1){
					alert('삭제성공');					
					location.replace('/board');
				}else if(data.indexOf('error') != -1){
					alert();
				}
			})
		})
	});
	</script>
	</head>
	<body>
	<table border="1">
		<tr>
			<td>글 번호</td>
			<td>${dto.board_num}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${dto.board_title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.board_writer}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${dto.board_content}</td>
		</tr>
		<tr>
			<td>날짜</td>
			<td><fmt:formatDate value="${dto.board_date}" pattern="yyyy-MM-dd kk:mm"></fmt:formatDate></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${dto.board_viewcount}</td>
		</tr>
	</table>
	<a href="/board/update/${board_num}">수정</a>
<%-- 	<a href="/board/delete/${board_num}">삭제</a> --%>
	<a href="javascript:void(0);" id="delete">삭제</a>
	<a href="/board">목록</a>
	</body>
</html>

