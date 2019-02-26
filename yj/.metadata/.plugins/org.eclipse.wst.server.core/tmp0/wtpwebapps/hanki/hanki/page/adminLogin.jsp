<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%if(session.getAttribute("error")!= null){
int er;
er = ((Integer)session.getAttribute("error")).intValue();
if(er==0){
 		/*
 		PrintWriter script = response.getWriter();
 		script.println("<script>");
 	    script.println("alert('test');");
 	    script.println("</script>"); 
        */
       out.println("<script>");
       out.println("alert('아이디와 비밀번호가 일치하지 않습니다.')");
       out.println("</script>");
       request.getSession().invalidate();
       }
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" type="text/css" href="../img_up/shop_pds/ehompy0118/src_css_fram/pc.skin.sub.css" />
<style>
.button {
border:5x;    /*---테두리 정의---*/
background-Color:#fffff;   /*--백그라운드 정의---*/
font:20px 고딕;      /*--폰트 정의---*/
font-weight:bold;   /*--폰트 굵기---*/
color:#111111;    /*--폰트 색깔---*/
width:130px;height:60px;  /*--버튼 크기---*/
}
</style>
</head>
<div class="logo_183743_">
	<h1><a href="./adminLogin.jsp" target="_self"><img src="../img_up/shop_pds/ehompy0118/farm/logo15196106291.jpg" alt="로고"></a></h1>

	<a href="#" id="farmToggleSearch" class="toggle_183743_ toggleSearch_183743_">토글 검색</a>
	<a href="#" id="farmToggleGnb" class="toggle_183743_ toggleGnb_183743_">토글 상단로그인</a>
	<a href="#" id="farmToggleLnb" class="toggle_183743_ toggleLnb_183743_">토글 네비게이션</a>
</div>


<body>

<center>
<form action="./AdminLoginAction.ad" method="post">
	<div class="container_2">
<!-- ---------------   layout in : 네비게이션 A : 183742  --------------- -->
<div   style='margin-top:30px;margin-bottom:20px;'  ><!-- 네비게이션 A -->

<div id="farmBoxLnb" class="lnb_183742_">
	<!-- 1 Depth -->
						
	<!-- // 1 Depth -->
</div>
</div></div>
<div>
<!-- ---------------  layout : 1칸 레이아웃 : 57710 --------------- -->



<div class="layout_57710_">
	<div>
		<div class="container_1">
<!-- ---------------   layout in : 서브페이지 제목 : 57711  --------------- -->
<div   style='margin-top:135px;margin-bottom:135px;text-align:center;'  ><!-- 서브페이지 제목 -->



<div class="sub_title_57711_">
	<h1>관리자 페이지</h1>	</div>
</div></div>
	</div>
</div>
</div><!-- ---------------  layout : 2칸 레이아웃 : 57341 --------------- -->



<div class="layout_57341_">
	<div>
		<div class="container_1">
<!-- ---------------   layout in : 서브 네비게이션 : 57715  --------------- -->
<div   style='margin-bottom:-40px;margin-left:20px;margin-right:20px;' ><!-- 서브 네비게이션 -->





<div id="snb_57715_" class="snb_57715_">
	<h1>Admin</h1>
	<!-- 1 Depth -->
	<ul class="dep1">
					<li class="on">
				<a href="./adminLogin.jsp" target="_self">Admin Login</a>
							</li>						</ul>
							</div>
							</div>
							</div>
							</div>
	<!-- // 1 Depth -->
</div>
<div class="img_ratio_58223_">
			<table border="0">
			<tr>
			<td align="center"><font size="6px"><b>Admin Login</b></font></td>
			</tr>
			<tr>
			<td colspan="2"><hr></td>
			</tr>
			<tr>
			<td><b>아이디</b></td>
			<td><input type="text" name="id" required></td>
			</tr>
			<tr>
			<td colspan="2"><hr></td>
			</tr>
			<tr>
			<td><b>패스워드</b></td>
			<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
			<td colspan="2"><hr></td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" class="button"  value="로그인"></td>
			</tr>
			</table>
	</div>
	</form>
	</center>
</body>
</html>