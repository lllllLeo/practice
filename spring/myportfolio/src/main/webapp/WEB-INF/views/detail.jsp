<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="/resources/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/resources/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/resources/css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="/resources/css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="/resources/css/style.css">

	<!-- Modernizr JS -->
	<script src="/resources/js/modernizr-2.6.2.min.js"></script>
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
					<li class="colorlib-active"><a href="/work">Work</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="/services">Services</a></li>
					<li><a href="/blog">Blog</a></li>
					<li><a href="/contact">Contact</a></li>
					<li><a href="/board?page=1">Board</a></li>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<p><small><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --> </span> <span>Demo Images: <a href="http://nothingtochance.co/" target="_blank">nothingtochance.co</a></span></small></p>
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

		<div id="colorlib-main">

			<div class="colorlib-work">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3">
							<span class="heading-meta">Portfolio</span>
							<h2 class="colorlib-heading animate-box" data-animate-effect="fadeInLeft">#${work_number}</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-8 image-content">
							<img class="img-responsive" src="/resources/images/${workdto.work_image1}" alt="HTML5 Bootstrap Template by colorlib.com">
							<img class="img-responsive" src="/resources/images/${workdto.work_image2}" alt="HTML5 Bootstrap Template by colorlib.com">
							<img class="img-responsive" src="/resources/images/${workdto.work_image3}" alt="HTML5 Bootstrap Template by colorlib.com">
							<img class="img-responsive" src="/resources/images/${workdto.work_image4}" alt="HTML5 Bootstrap Template by colorlib.com">
						</div>
						<div class="col-md-4 sticky-parent">
							<div id="sticky_item">
								<div class="project-desc">
									<h2>${workdto.work_title}</h2>
									<span>${workdto.work_used}</span>
<!-- 									<span><a href="#">Logo</a>, <a href="#">Brading</a></span> -->
									<p>${workdto.work_description}</p>
									<p class="icon">
										<span><a href="#"><i class="icon-share3"></i></a></span>
										<span><i class="icon-eye"></i>${workdto.work_viewcount}</a></span>
										<%-- <span><a href="#"><i class="icon-heart"></i>${workdto.work_like}</a></span> --%>
									</p>
									<p><a href="#" class="btn btn-primary">Live Preview</a> or <a href="#" class="btn-download">Download</a></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="get-in-touch" class="colorlib-bg-color">
				<div class="colorlib-narrow-content">
					<div class="row">
						<div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">
							<h2>Get in Touch!</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-md-pull-3 animate-box" data-animate-effect="fadeInLeft">
							<p class="colorlib-lead">Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
							<p><a href="#" class="btn btn-primary btn-learn">Contact me!</a></p>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="/resources/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="/resources/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="/resources/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="/resources/js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="/resources/js/jquery.flexslider-min.js"></script>
	<!-- Sticky Kit -->
	<script src="/resources/js/sticky-kit.min.js"></script>
	
	
	<!-- MAIN JS -->
	<script src="/resources/js/main.js"></script>

	<!-- Logout -->
	<script>
		$(document).ready(function() {
			$("#logout").unbind("click").click(function(e) {
				e.preventDefault();
				logout();
			});
		});

		function logout() {
			if (window.confirm("로그아웃 하시겠습니까?")) {
				window.location.href = "/logout";
			}
		}
	</script>
	</body>
</html>

