<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
	<link rel="shortcut icon" href="/resources/images/favicon.ico">
	<title>: : : : : Y U J U N : : : : :</title>
	<script src="/resources/js/jquery.min.js"></script>
	<script>
	$(function(){
		$("#register").on("click", function(){
			/* 유효성검사 */
			var title = document.getElementById('board_title');
			var writer = document.getElementById('board_writer');
			var content = document.getElementById('board_content');
			console.log(content);
			
			if(title.value == ""){
				alert("제목을 입력해주세요.");
				title.focus(); //입력포커스 설정
				return false;
			}
			if(writer.value == ""){
				alert("작성자를 입력해주세요.");
				writer.focus(); //입력포커스 설정
				return false;
			}
			if(content.value == ""){
				alert("내용을 입력해주세요.");
				content.focus(); //입력포커스 설정
				return false;
			}
			
			if(writer.value.length >= 20){
				alert("20자 이내로 입력하세요.")
				writer.focus();
			}
			
			$.ajax({
				url : "/board/register",
				type : "post",
				data : {
					"board_title" : $("#board_title").val(),
					"board_writer" : $("#board_writer").val(),
					"board_content" : $("#board_content").val()
				}
			}).done(function(responseData){
					location.replace('/board?page=1');
				})
			});
		});
	</script>
	
	</head>
	<body>
	<form>
		<table>
			<tr>
				<td>제목 : <input type="text" id="board_title"></td>
			</tr>
			<tr>
				<td>작성자 :<input type="text" id="board_writer"></td>
			</tr>
			<tr>
				<td>내용 : <textarea id="board_content"></textarea></td>
			</tr>
			
		</table>
			<p id="registerFail"></p>
	</form>
	<a href="javascript:void(0);" id="register">등록</a>
	<a href="javascript:history.go(-1);">취소</a>
	</body>
</html>

