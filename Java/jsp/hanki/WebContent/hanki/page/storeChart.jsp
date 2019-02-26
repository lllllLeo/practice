
<%@page import="net.admin.db.AdminSalesBean"%>
<%@page import="net.admin.action.AdminSalesAction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);
      <%List<AdminSalesBean> chlist = (List<AdminSalesBean>)session.getAttribute("chartlist");
     	
      %>
      function drawVisualization() {
        // Some raw data (not necessarily accurate)
        var data = google.visualization.arrayToDataTable([
         ['Daily', '<%=request.getSession().getAttribute("store_name")%>' ],
         <%int i=0;
         for(i = 0; i<chlist.size();i++){ %>
         ['<%=chlist.get(i).getSaldate() %>', <%=chlist.get(i).getSales()%>],
         
         <%}%>
         
        <%--  <%int i = 0;
         while(chlist.isEmpty() != false){ %>
         ['<%=chlist.get(i).getSaldate() %>',  <%= chlist.get(i).getSales()%> ],
         <% i++;}%>
         ['<%=chlist.get(i).getSaldate() %>',  <%= chlist.get(i).getSales()%> ]
        --%>
      ]);

    var options = {
      title : 'Daily Statistics',
      vAxis: {title: 'Won'},
      hAxis: {title: 'Day'},
      animation: { //차트가 뿌려질때 실행될 애니메이션 효과
          startup: true,
          duration: 1000,
          easing: 'linear' },
      seriesType: 'bars',
      //series: {5: {type: 'line'}}
    };

    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Store Registration</title>
<link rel="stylesheet" type="text/css" href="../img_up/shop_pds/ehompy0118/src_css_fram/pc.skin.chart.css" />
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
   <h1><a href="./admin.ad" target="_self"><img src="../img_up/shop_pds/ehompy0118/farm/logo15196106291.jpg" alt="로고"></a></h1>

   <a href="#" id="farmToggleSearch" class="toggle_183743_ toggleSearch_183743_">토글 검색</a>
   <a href="#" id="farmToggleGnb" class="toggle_183743_ toggleGnb_183743_">토글 상단로그인</a>
   <a href="#" id="farmToggleLnb" class="toggle_183743_ toggleLnb_183743_">토글 네비게이션</a>
</div>


<body>

<center>
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
   <h1>매장 매출 </h1>   </div>
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
   <h1>Store management</h1>
   <!-- 1 Depth -->
   <ul class="dep1">
            <li>
            <a href="./adminsales.ad" target="_self">Input Sales</a>
                     </li>       
                     <li>
            <a href="./adminsaleslist.ad" target="_self">Sale List</a>
                     </li> 
                     <li class="on">
            <a href="./storeChart.ad" target="_self">Daily Statistics</a>
                     </li>   
                                       </ul>
                     </div>
                     </div>
                     </div>
                     </div>
   <!-- // 1 Depth -->
</div>
<div class="img_ratio_58223_">
   <div id="chart_div" style="width: 790px; height: 500px;"></div>
   </div>
  
   </center>
</body>
</html>