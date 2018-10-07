<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>: : : : : Y U J U N : : : : :</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="/resources/images/favicon.ico">

	<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath}/resources/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="border js-fullheight">
	<c:choose>
				<c:when test="${null ne session }">
					<p id="colorlib-logo" align="left"
						style="font-size: 8pt; color: gray; margin-bottom: 1em">${session}님
						환영합니다.</p>
				</c:when>
				<c:otherwise>
					<p></p>
				</c:otherwise>
			</c:choose>
			<h1 id="colorlib-logo"><a href="/"><span>Yu</span><span>Jun</span></a></h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/work">Work</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="/services">Services</a></li>
					<li><a href="/blog">Blog</a></li>
					<li><a href="/contact">Contact</a></li>
					<li class="colorlib-active"><a href="/board">Board</a></li>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<p style="color:white;"><small><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank"  style="color:white;">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --> </span> <span>Demo Images: <a href="http://nothingtochance.co/" target="_blank"  style="color:white;">nothingtochance.co</a></span></small></p>
				<ul>
					<li><a href="#"><i class="icon-facebook2"></i></a></li>
					<li><a href="#"><i class="icon-twitter2"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin2"></i></a></li>
				</ul>
				<c:choose>
					<c:when test = "${null ne session}">
						<p style="margin-bottom:0"><a href="#" id="logout">logout</a></p>
					</c:when>
					<c:otherwise>
						<p style="margin-bottom:0"><a href="/login">login</a></p>
					</c:otherwise>
				</c:choose>
			</div>
			
		</aside>
	</div>
	<div style="padding:80px 0px 0px 300px">
		<table border="1">
			<tr>
				<td style="width: 5%; text-align: center">글 번호</td>
				<td style="width: 45%; text-align: center">제목</td>
				<td style="width: 10%; text-align: center">작성자</td>
				<td style="width: 15%; text-align: center">날짜</td>
				<td style="width: 5%; text-align: center">조회수</td>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td style="width: 10%; text-align: center">${list.board_num}</td>
					<td style="width: 40%"><a href="/board/${list.board_num}">${list.board_title}</a></td>
					<td style="width: 10%">${list.board_writer}</td>
					<td style="width: 15%; text-align: center"><fmt:formatDate
							value="${list.board_date}" pattern="yyyy-MM-dd kk:mm" /></td>
					<td style="width: 5%; text-align: center">${list.board_viewcount}</td>

				</tr>
			</c:forEach>
		</table>
		<a href="board/register">[글 등록]</a>
	</div>
</body>
</html>

