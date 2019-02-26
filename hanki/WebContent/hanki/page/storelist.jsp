<%@page import="net.admin.db.AdminSalesBean"%>
<%@page import="net.admin.db.AdminBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.PrintWriter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%if(session.getAttribute("sucsal")!= null){
int er;
er = ((Integer)session.getAttribute("sucsal")).intValue();
if(er==0){
 		/*
 		PrintWriter script = response.getWriter();
 		script.println("<script>");
 	    script.println("alert('test');");
 	    script.println("</script>"); 
        */
       out.println("<script>");
       out.println("alert('성공적으로 삭제되었습니다!')");
       out.println("</script>");
       }
}
session.removeAttribute("sucsal");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store Registration</title>
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

.button1 {
border:5x;    /*---테두리 정의---*/
background-Color:#fffff;   /*--백그라운드 정의---*/
font:15px 고딕;      /*--폰트 정의---*/
font-weight:bold;   /*--폰트 굵기---*/
color:#111111;    /*--폰트 색깔---*/
width:80px;height:40px;  /*--버튼 크기---*/
}
</style>
</head>
<div class="logo_183743_">
   <h1><a href="./admin.ad" target="_self"><img src="../img_up/shop_pds/ehompy0118/farm/logo15196106291.jpg" alt="로고"></a></h1>

   <a href="#" id="farmToggleSearch" class="toggle_183743_ toggleSearch_183743_">토글 검색</a>
   <a href="#" id="farmToggleGnb" class="toggle_183743_ toggleGnb_183743_">토글 상단로그인</a>
   <a href="#" id="farmToggleLnb" class="toggle_183743_ toggleLnb_183743_">토글 네비게이션</a>
</div>


<body>

<center>
<form action= "./AdminJoinAction.ad"  method="post">
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
   <h1>매장 판매 관리</h1>   </div>
</div></div>
   </div>
</div>
</div><!-- ---------------  layout : 2칸 레이아웃 : 57341 --------------- -->



<div class="layout_57341_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 서브 네비게이션 : 57715  --------------- -->
<div   style='margin-bottom:-80px;margin-left:20px;margin-right:20px;' ><!-- 서브 네비게이션 -->





<div id="snb_57715_" class="snb_57715_">
   <h1>Store management</h1>
   <!-- 1 Depth -->
   <ul class="dep1">
             <li class="off">
            <a href="./adminsales.ad" target="_self">Input Sales</a>
                     </li>       
                     <li class="on">
            <a href="./adminsaleslist.ad" target="_self">Sale List</a>
                     </li>            
                     <li>
            <a href="./adminsDaily.ad" target="_self">Daily statistics</a>
                     </li>            
                                       </ul>
                     </div>
                     </div>
                     </div>
                     </div>
   <!-- // 1 Depth -->
</div>
<div class="img_ratio_58223_">
         <table border="0">
         <tr>
         <td colspan="3" align="center"><font size="6px"><b>
		 Sale List</b></font></td>
         </tr>
         <tr>
		 <td colspan="3"><hr></td>
		 </tr>
        
         <%
    
    List<AdminSalesBean> adsallist = (List<AdminSalesBean>)request.getAttribute("adsallist");
    List<AdminBean> adlist = (List<AdminBean>)request.getAttribute("adlist");
    
   
	
	String ID = (String)session.getAttribute("ID"); //session에 있는 ID를 가져온다.
	try {
	    
	
	   
	        int i=0; //인덱스를 위해 만들어줌.
	        int j=0;
		%>
		<center>
		<table>
		<% if(adsallist.size() == 0){%>
		<tr>
		   <td><font size="5px"><b>판매 정보가 없습니다.</b></font></td>
		   </tr>
		   <tr>
			<td colspan="5"><hr></td>
			</tr>
		<% }else{
		    %>
		
		<% for(i=0; i<adsallist.size(); i++){  %> <!--데이터가 있으면 true 없으면 false...없을때까지 while문이 돈다  -->
				<tr>
		<td align = center ><font size="5px"><b><% out.println(j+1); %></b>&nbsp</font></td>
		<td align = center><font size="5px"><b><%= adsallist.get(i).getSaldate() %>&nbsp</b></font></td>
		<td align = center><font size="5px"><b><%= adsallist.get(i).getSales() %>&nbsp</b>원</font></td>
		<td align = center><font size="5px"><b><%= adsallist.get(i).getStore_name() %>&nbsp</b></font></td>
		<td align="center"><input type="button" class="button1" onClick="location.href='adminsaldelete.ad?sales=<%= adsallist.get(i).getSales()%>&date=<%= adsallist.get(i).getSaldate()%>'"  value="삭제"></td>		
		</tr><!-- 각각의 데이터에 값을 넣어준다.  -->
		<tr>
			<td colspan="5"><hr></td>
			</tr>
		
		<% j++;}
		}
	       %>
	    <tr>
	    <td colspan="5" align="center"><input type="button" class="button" onClick="location.href='admin.ad'"  value="이전"></td>
	    </tr>
		</table>
		<%

	    
	    }catch(Exception e){
        out.println("<h3>데이터 가져오기에 실패하였습니다.</h3>");
        e.printStackTrace();
    }
    %>
         </table>
   </div>
   </form>
   </center>
</body>
</html>