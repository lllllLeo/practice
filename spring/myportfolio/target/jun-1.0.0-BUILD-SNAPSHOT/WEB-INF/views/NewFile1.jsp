


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Theory by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<script src="js/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
<title>Hello Code</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/main.css" />



<script type="text/javascript">

$(document).ready(function(){
	if("null"!="null"){
		location.href="error"
	}
}) 


$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
    $("input[name='HCID']").val(userInputId); 
     
    if($("input[name='HCID']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("input[name='HCID']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='HCID']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='HCID']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}




	function logincheck() {

		console.log($("#HCID").val());
		console.log($("#HCpassword").val().replace(" ",""));
		$.ajax({
					url : "/ajax",
					type : "post",
					data : {
						"HCID" : $("#HCID").val(),
						"HCpassword" : $("#HCpassword").val().replace(" ","")
					},
					success : function(responseData) {
						$(this).remove();
						var data = responseData;
						if (data.indexOf('success') != -1) {
							var su = document.loginchecks;
							su.method = "post";
							su.action = "/";
							su.submit();
						} else if (data.indexOf('error') != -1) {
							$("#brt").empty();
							$("#brt")
									.append(
											"<p id='pa' style='text-align:center;'><font size='3' color='#ef3746'> 로그인에 실패했습니다.<br>아이디나 비밀번호를 확인해 주세요.<font></p>");
							for (var i = 0; i < 3; i++) {
								$("#pa").fadeTo('fast', 0.1)
										.fadeTo('fast', 1.0);
							}
							var scmove = $('#main').offset().top;
							$('html, body').animate({
								scrollTop : scmove
							}, 400);

						}
					}
				})
	}

</script>



</head>
<body>

	<!-- Header -->
	<header id="header">
	<div class="inner">
		<a href="/" class="logo">Hello Code<!-- <img src="images/logo1.png" class="img"/> --></a>
		<nav id="nav">  <a
			href="/account_view">join</a> <a href="/real_noticeBoard?page=1">notice</a>
		<a href="/real_freeBoard?page=1">freeBoard</a> <a
			href="/real_questionBoard?page=1">questionBoard</a> <a
			href="/real_hotBoard?page=1&qpage=1">now hot</a>  </nav>
		<a href="#navPanel" class="navPanelToggle"><span
			class="fa fa-bars"></span></a>
	</div>
	</header>
	<!-- Header End -->

	<!-- Banner -->
	<section id="banner">
	<h1>WELCOME to HelloCode</h1>
	<p>A free responsive HTML5 website template by TEMPLATED.</p>
	</section>

	<!-- Main -->
	<section id="main" class="wrapper"> <header
		class="align-center">
	<h2>LOGIN</h2>
	<p>WELCOME !</p>
	</header>

	<form name="loginchecks">
		<div class="inner">

			<div class="row">

				<div class="4u 12u$(medium)">
					<h3></h3>
					<p></p>
				</div>
				<div class="4u 12u$(medium)">
					<div class="12u$">
						<input type="text" name="HCID" id="HCID"
							placeholder="Enter your ID" rows="6"
							onkeydown="if(event.keyCode==13)loginchecks.HCpassword.focus()">
						<br> <input type="password" name="HCpassword" id="HCpassword"
							placeholder="Enter your Password" rows="6"
							onkeydown="javascript:if(event.keyCode==13)logincheck();">
						<br>
						<div id="brt" class="asd"></div>

						<a href="javascript:void(0);" onclick="javascript:logincheck();"
							name="ch" class="button special fit">L O G I N</a>
						<input type="checkbox" id="idSaveCheck" name="idSaveCheck">
                                 <label for="idSaveCheck" >Remeber ID</label>   
					</div>  
					<br>
					
                             
                             
					<center>
					<p>
					<a href="/forgotID">LOST IDENTIFICATION</a></p>
					<p>
						<a href="/forgotpass">LOST PASSWORD</a>
						</p>
						<p>
					</center>
					<center>
						<a href="/account_view">CREATE NEW ACCOUNT</a>
					</center>
					</p>

				</div>
				<div class="4u$ 12u$(medium)">
					<h3></h3>
					<p></p>
				</div>
			</div>
		</div>

	</form>
	</section>





	<!-- Footer -->
	<footer id="footer">
	<div class="inner">
		<div class="flex">
			<div class="copyright">
				&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>.
				Images: <a href="https://unsplash.com">Unsplash</a>.
			</div>
			<ul class="icons">
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-linkedin"><span
						class="label">linkedIn</span></a></li>
				<li><a href="#" class="icon fa-pinterest-p"><span
						class="label">Pinterest</span></a></li>
				<li><a href="#" class="icon fa-vimeo"><span class="label">Vimeo</span></a></li>
			</ul>
		</div>
	</div>
	</footer>

	<!-- Scripts -->

	<script src="js/skel.min.js"></script>
	<script src="js/util.js"></script>
	<script src="js/main.js"></script>

</body>
</html>