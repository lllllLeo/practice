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
	<script>
	$(function(){
		$("#sendmailto").on("click", function(){
			console.log('호준')
/* 			var body= $("#name").val()+$("#phone").val()+$("#message").val(); */
			var subject = "이름 : "+$("#name").val()+" / "+"연락처 : "+$("#phone").val()
			var body= "내용 : "+$("#message").val();
			location.href="mailto:kwb103@gmail.com?subject="+subject+"&body="+body;
		})
	})
	</script>
	</head>
	<body>
	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary"
			class="border js-fullheight">
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
			<h1 id="colorlib-logo">
				<a href="/"><span>Yu</span><span>Jun</span></a>
			</h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/work">Work</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="/services">Services</a></li>
					<li><a href="/blog">Blog</a></li>
					<li class="colorlib-active"><a href="/contact">Contact</a></li>
					<li><a href="/board?page=1">Board</a></li>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<p>
					<small>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;<script>document.write(new Date().getFullYear());</script>
						All rights reserved | This template is made with <i
						class="icon-heart" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a> <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</span> <span>Demo Images: <a href="http://nothingtochance.co/"
							target="_blank">nothingtochance.co</a></span>
					</small>
				</p>
				<ul>
					<li><a href="#"><i class="icon-facebook2"></i></a></li>
					<li><a href="#"><i class="icon-twitter2"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin2"></i></a></li>
				</ul>
				<c:choose>
					<c:when test="${null ne session}">
						<p style="margin-bottom: 0">
							<a href="#" id="logout">logout</a>
						</p>
					</c:when>
					<c:otherwise>
						<p style="margin-bottom: 0">
							<a href="/login">login</a>
						</p>
					</c:otherwise>
				</c:choose>
			</div>

		</aside>

		<div id="colorlib-main">

			<div class="colorlib-contact">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<span class="heading-meta">Read</span>
							<h2 class="colorlib-heading animate-box"
								data-animate-effect="fadeInLeft">Get in Touch</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 col-md-push-6">
							<div class="colorlib-feature colorlib-feature-sm animate-box"
								data-animate-effect="fadeInLeft">
								<div class="colorlib-icon">
									<i class="icon-globe-outline"></i>
								</div>
								<div class="colorlib-text">
									<p>
										<a href="#">andwithyj@gmail.com</a>
									</p>
								</div>
							</div>

							<div class="colorlib-feature colorlib-feature-sm animate-box"
								data-animate-effect="fadeInLeft">
								<div class="colorlib-icon">
									<i class="icon-map"></i>
								</div>
								<div class="colorlib-text">
									<p>YuJun World</p>
								</div>
							</div>

							<div class="colorlib-feature colorlib-feature-sm animate-box"
								data-animate-effect="fadeInLeft">
								<div class="colorlib-icon">
									<i class="icon-phone"></i>
								</div>
								<div class="colorlib-text">
									<p>
										<a href="tel://">+82 010 2926 ----</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-7 col-md-pull-5">
							<div class="row">
								<div class="col-md-10 col-md-offset-1 col-md-pull-1 animate-box"
									data-animate-effect="fadeInLeft">
									<form action="mailto:kwb103@gmail.com" enctype="text/plain"
										name="mailtogo">
										<div class="form-group">
											<input type="text" class="form-control" name="name" id="name"
												placeholder="Name">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" name="email"
												id="email" placeholder="Email">
										</div>
										<div class="form-group">
											<input type="text" class="form-control" name="phone"
												id="phone" placeholder="Phone">
										</div>
										<div class="form-group">
											<textarea name="message" id="message" cols="30" rows="7"
												class="form-control" placeholder="Message"></textarea>
										</div>
										<div class="form-group">
											<input type="button" id="sendmailto" name="sendmailto"
												class="btn btn-primary btn-send-message"
												value="Send Message">
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
					<div id="map" style="width: 500px; height: 400px;"></div>
					<!-- 다음 지도 API -->
					<script type="text/javascript"
						src="//dapi.kakao.com/v2/maps/sdk.js?appkey=31fba0106b8bbef9d66bc6ff1a7295ad"></script>
					<script>
						var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
						var options = { //지도를 생성할 때 필요한 기본 옵션
							center : new daum.maps.LatLng(35.26712648061961,
									129.07900865286373), //지도의 중심좌표.
							level : 3
						//지도의 레벨(확대, 축소 정도)
						};

						var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
					</script>
				</div>
			</div>
		</div>
	</div>



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

