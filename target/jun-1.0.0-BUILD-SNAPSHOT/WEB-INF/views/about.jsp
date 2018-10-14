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
	
	<!-- Animation -->
	<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="/resources/css/info.css"> -->
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
					<li><a href="/work">Work</a></li>
					<li class="colorlib-active"><a href="/about">About</a></li>
					<li><a href="/services">Services</a></li>
					<li><a href="/blog">Blog</a></li>
					<li><a href="/contact">Contact</a></li>
					<li><a href="/board">Board</a></li>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<%--<p><small><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --> </span> <span>Demo Images: <a href="http://nothingtochance.co/" target="_blank">nothingtochance.co</a></span></small></p>--%>
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
			<div class="colorlib-about">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6">
							<div class="about-img animate-box"
								data-animate-effect="fadeInLeft"
								style="background-image: url(/resources/images/about1.jpg);">
								<div class="about-img-2 animate-box"
									data-animate-effect="fadeInRight"
									style="background-image: url(/resources/images/about2.jpg);"></div>
							</div>
						</div>
						<div class="col-md-6 animate-box" data-animate-effect="fadeInLeft">
							<div class="about-desc">
								<span class="heading-meta">Welcome &amp; Introduce</span>
								<!-- <h1>
									<a href="" class="typewrite" data-period="2000" 
										data-type='[ "Hi, Im VipulM.", "I am Creative.", "I Love Design.", "I Love to Develop." ]'>
										<span class=""></span>
									</a>
								</h1> -->
								<h3>Hola! Me llamo Yu Jun!</h3>
								<p>김 유 준 (KIM YU JUN)</p>
							</div>
							<div class="fancy-collapse-panel">
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="headingOne">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapseOne" aria-expanded="true"
													aria-controls="collapseOne">Why choose me? </a>
											</h4>
										</div>
										<div id="collapseOne" class="panel-collapse collapse in"
											role="tabpanel" aria-labelledby="headingOne">
											<div class="panel-body">
												<div class="row">
													<div class="col-md-6">
														<p>저는 </p>
													</div>
													<div class="col-md-6">
														<p>나는</p>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="headingTwo">
											<h4 class="panel-title">
												<a class="collapsed" data-toggle="collapse"
													data-parent="#accordion" href="#collapseTwo"
													aria-expanded="false" aria-controls="collapseTwo">What
													I do? </a>
											</h4>
										</div>
										<div id="collapseTwo" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingTwo">
											<div class="panel-body">
												<p>
													2012.02 ~ 2019.02 부산외국어대학교 졸업 예정 <br>
													전공 : 스페인어 | 부전공 : 컴퓨터공학과 <br>
												</p>

												<p>
													- 2017.12 ~ 2018.02 비트교육센터 단기과정 수료<br>
													- 2018.03 ~ 2018.08 비트교육센터 고급과정 수료<br>
													- 2018.07 ~ 2018.11 고용노동부 청년취업아카데미(비트교육센터 주관) 진행중
												</p>

												<!-- <ul>
														<li>Separated they live in Bookmarksgrove right</li>
														<li>Separated they live in Bookmarksgrove right</li>
													</ul> -->
											</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="headingThree">
											<h4 class="panel-title">
												<a class="collapsed" data-toggle="collapse"
													data-parent="#accordion" href="#collapseThree"
													aria-expanded="false" aria-controls="collapseThree">My
													Specialties </a>
											</h4>
										</div>
										<div id="collapseThree" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="headingThree">
											<div class="panel-body">
												<div class="row">
													<div class="col-md-6">
														<p style="font-size: 15pt; font-weight: bold; margin-bottom: 0px">
															보유 자격증
														</p>
														<p>
															- 정보처리기사 <br>
															- 리눅스마스터2급 <br>
															- C Programming Master <br>
															- JAVA Programing Master
														</p>
													</div>
													<div class="col-md-12">
														<p>
															JSP, Spring, Oracle, MariaDB, Javascript, jQuery, Ajax, HTML, CSS, Bootstrap, git, aws, ubuntu
														</p>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
													<p style="margin-bottom:0px">블로그 : <a href="https://cmleo.tistory.com">https://cmleo.tistory.com</a></p>
													<p style="margin-bottom:0px">GitHub : <a href="https://github.com/lllllLeo">https://github.com/lllllLeo</a></p>
													<p style="margin-bottom:0px">GitLab : <a href="https://github.com/lllllLeo">https://gitlab.com/kwb103</a></p>
													</div>
												</div>
											</div>
										</div>
									</div>
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
	<!-- info -->
	<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="/resources/js/info.js"></script> -->
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

