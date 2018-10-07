<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
	<title>: : : : : Y U J U N : : : : :</title>
	
	<!-- jQuery -->
	<script src="/resources/js/jquery.min.js"></script>
	
	<script>
	
	$(function(){
		$('#update').on('click',function(){
			var formArray = $('#formdata').serializeArray();
			console.log(formArray);
			$.ajax({
				url : "/board/update/${board_num}",
				type : "post",
				data : formArray
			}).done(function(responseData){
				location.replace('/board');				
			})
		})
	})
	</script>
	</head>
	<body>
	<form id="formdata">
		<table border="1">
			<tr>
				<td>글 번호</td>
				<td>${dto.board_num}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="board_title" name="board_title" value="${dto.board_title}"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${dto.board_writer}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="board_content" name="board_content" value="${dto.board_content}"></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td>${dto.board_date}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${dto.board_viewcount}</td>
			</tr>
		</table>
	</form>
	<a href="javascript:void(0);" id="update">수정하기</a>
	<a href="javascript:history.go(-1);">뒤로가기</a>
	<a href="/board">목록</a>
	</body>
</html>

