<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% if(request.getSession().getAttribute("session") != null){
	response.sendRedirect("/"); %>
<% } %>
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
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="5" />
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
<!-- Login style -->
<link rel="stylesheet" href="/resources/css/login.css">

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
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<script>
/* $(document).ready(function(){ 를 줄여서 $(function(){})로 할 수 있음. 그런데 jQuery를 처음보는 사람이면 알아보기 힘들어서 document.ready처럼 길게 써주는게 좋지만 난 싫어"*/

//$("#SEARCH_KEYWORD").keyup(function(e){if(e.keyCode == 13)  login(); }); 방법1.jQuery로/  뒤에 함수명 적어주면 엔터키를 누르면 login()가 실행됨


/* $("#logincheck").keydown(function(key){
	if(key.keyCode == 13)
		//실행 할 내용
	})
}
 */

	function logincheck(){
		
		/* $("#logincheck").on("click",function logincheck(){ */
		
/* 		var id = document.getElementById('yj_id'); 	
		var password = document.getElementById('yj_password'); */
		
		if($('#yj_id').val() == ""){
			alert('아이디를 입력해주세요.');
			$('#yj_id').focus();
			return false;
		}
		
		if($('#yj_id').val().length < 4 || $('#yj_id').val().length >= 12){
			alert('아이디를 4~12자 이내로 입력하세요.');
			$('#yj_id').value="";
			$('#yj_id').focus();
			return false;
		}
				
		if($('#yj_password').value == ""){
			alert('비밀번호를 입력해주세요.');
			$('#yj_password').focus();
			return false;
		}
		
/* 		if(password.value.length >= 4 && id.value.length <= 15){
		}else{
			alert('비밀번호를 4~15자 이내로 입력하세요.');
			password.value="";
			password.focus();
			return false;
		} */
		if($('#yj_password').val().length < 4 || $('#yj_password').val().length >= 15){
			alert('비밀번호를 4~15자 이내로 입력하세요.');
			$('#yj_password').value="";
			$('#yj_password').focus();
			return false;
		}
		
		$.ajax({
			url : "/login",
			type : "post",
			data : {
				"yj_id" : $("#yj_id").val(),
				"yj_password" : $("#yj_password").val().replace(" ","")
			},
			/* success : function(responseData){
				$(this).remove();  //이게 뭘까 뭘 지우는거지 
				var data = responseData;
				if(data.indexOf('success') != -1){
					location.href = "/";
				}else if (data.indexOf('error') != -1){
					$('#loginfail').empty();
					$('#loginfail').append("<p id = 'pop' style='text-align:center;'>로그인에 실패하였습니다. <br>아이디나 비밀번호를 확인하세요</p>");
				
					for(var i = 0; i < 3; i++){
						$("#pop").fadeTo('fast', 0.1)
								 .fadeTo('fast', 1.0);
					}
					setTimeout(function(){
						$('#loginfail').empty();
					},3000);
				}
			} */
		//	젠킨스 테스트합니다
		//	젠킨스 테스트합니다2
		//	젠킨스 테스트합니다3
		//	젠킨스 테스트합니다4
		}).done(function(responseData){
			$(this).remove();  //이게 뭘까 뭘 지우는거지 
			var data = responseData;
			if(data.indexOf('success') != -1){
/* 				location.href = "/"; */
				location.replace('/');
			}else if (data.indexOf('error') != -1){
				$('#loginfail').empty();
				$('#loginfail').append("<p id = 'pop' style='text-align:center;'>로그인에 실패하였습니다. <br>아이디나 비밀번호를 확인하세요</p>");
			
				for(var i = 0; i < 3; i++){
					$("#pop").fadeTo('fast', 0.1)
							 .fadeTo('fast', 1.0);
				}
				setTimeout(function(){
					$('#loginfail').empty();
				},3000);
			}
		})
	}
/* $(function(){	
}); */
</script>
<style>
.panel-heading a:after{
content : none;
}
</style>

</head>
<body>
	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary"
			class="border js-fullheight">
			<p></p>
			<h1 id="colorlib-logo"><a href="/"><span>Yu</span><span>Jun</span></a></h1>
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/work">Work</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="/services">Services</a></li>
					<li><a href="/blog">Blog</a></li>
					<li><a href="/contact">Contact</a></li>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<p>
					<small>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;<script>
							document.write(new Date().getFullYear());
						</script>
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
			</div>

		</aside>

		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-login">
						<div class="panel-heading">
							<div class="row" >
								<div class="col-xs-12">
									<a href="javascript:void(0);" class="active" id="login-form-link" style="border:2px solid #000; background:#ffffff; color: black">Login</a>
								</div>
							</div>
							<hr>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
<!-- 									<form id="login-form" action="/login" method="post" role="form" style="display: block;"> -->
									<form id="login-form">
										<div class="form-group">
											<input type="text" name="yj_id" id="yj_id" onkeydown="javascript:if(event.keyCode == 13)logincheck();" tabindex="1" class="form-control" placeholder="Username" value="" maxlength="12">
										</div>
										<div class="form-group">
											<input type="password" name="yj_password" id="yj_password" onkeydown="javascript:if(event.keyCode == 13)logincheck();" tabindex="2" class="form-control" placeholder="Password" maxlength="12">
										</div>
										<div class="from-group" id="loginfail"></div>
										<div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember" id="remember"> <label for="remember">
												Remember Me</label>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<!-- <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login"
														value="Log In"> -->
														<a href="javascript:void(0);" tabindex="4" id="logincheck" class="form-control btn btn-login" onclick="javascript:logincheck();" >Log In</a>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-lg-12">
													<div class="text-center">
														<a href="https://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>

