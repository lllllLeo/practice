<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="net.board.db.*" %>
<%
   BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(주)쉐프마인드 맛맛</title>
<meta name="naver-site-verification" content="fdb874a536daa44431e562983af2c160a76457cf"/>
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=2.0, minimum-scale=0.5, width=device-width">
<meta name="subject" content="(주)쉐프마인드 맛맛" />
<meta name="copyright" content="(주)쉐프마인드" />
<meta name="title" content="(주)쉐프마인드 맛맛" />
<meta name="description" content="정말 맛나영!" />
<link rel="canonical" href="http://www.hankikor.com/bbs/g1/278081" />
<meta property="og:title"           content="맛맛"/>
<meta property="og:site_name"       content="(주)쉐프마인드"/>
<meta property="og:type"            content="website"/>
<meta property="og:url"             content="http://www.hankikor.com/bbs/g1/278081"/>
<meta property="og:image"           content="./hanki/thum_img/ehompy0118/og_img/og_logo1519610629.jpg"/>
<meta property="og:description"     content="정말 맛나영!"/>
<meta name="twitter:card"           content="summary">
<meta name="twitter:title"          content="맛맛">
<meta name="twitter:site"           content="(주)쉐프마인드">
<meta name="twitter:creator"        content="hong">
<meta name="twitter:image"          content="./hanki/thum_img/ehompy0118/og_img/og_logo1519610629.jpg">
<meta name="twitter:description"    content="정말 맛나영!">
<link rel="shortcut icon" href="./hanki/img/favicon_null.png" />
<script type="text/javascript" src="./hanki/img_up/_addon/jquery/1.11.3/jquery.min.js"></script>


<link rel="stylesheet" href="./hanki/css/head_basic.css" type="text/css" media="all" />
<link rel="stylesheet" href="./hanki/css/head_logout.css" type="text/css" media="all" />
<script type="text/javascript">var MOBILE_CONN_YN = false;</script>
<script type="text/javascript" src="./hanki/js/all_default.js"></script>
<script type="text/javascript">
var ios_yn = false;
var APP_CONN_YN = false;
var isKitkat = window.navigator.userAgent.search( "AnybuildApp Android 4.4") > -1 ? true : false;
</script>
<script type="text/javascript" src="./hanki/img_up/shop_pds/ehompy0118/etc/navi_category_all.js"></script>
<script type="text/javascript" src="./hanki/img_up/shop_pds/ehompy0118/etc/goods_category_all.js"></script>
<script type="text/javascript" src="./hanki/img_up/shop_pds/ehompy0118/etc/board_list.js"></script>
<script type="text/javascript" src="./hanki/img_up/shop_pds/ehompy0118/etc/site_category_all.js"></script>
<script type="text/javascript" src="./hanki/img_up/shop_pds/ehompy0118/etc/gisa_category_all.js"></script>
<script type="text/javascript" src="./hanki/img_up/shop_pds/ehompy0118/etc/movie_category_all.js"></script>
<script type="text/javascript" src="./hanki/js/all_default2.js"></script>
<script type="text/javascript" src="./hanki/js/google_map.js"></script>
<script type="text/javascript" src="./hanki/js/load_frame.js"></script>
<script type="text/javascript" src="./hanki/js/head_logout.js"></script>
<script type="text/javascript" id='naver_map_js' ></script>
<script type="text/javascript" id='dynamic_js' ></script>

<script type="text/javascript" src="./hanki/img_up/_addon/jquery/1.11.3/jquery.min.js"></script>
<!---->

<link rel="stylesheet" type="text/css" href="./hanki/img_up/_addon/css/reset_1.0.css">

<link rel="stylesheet" type="text/css" href="./hanki/img_up/shop_pds/ehompy0118/src_css_fram/pc.board.g1.css" />
<link rel="stylesheet" type="text/css" href="./hanki/img_up/shop_pds/ehompy0118/src_css_fram/pc.skin.sub.css" />
<script type="text/javascript" src="./hanki/img_up/_addon/_plugin/modernizr/modernizr.custom.media.query.js"></script>

<link rel="stylesheet" type="text/css" href="./hanki/img_up/tmp_img/service/board_tpl/8/pc/css/default_mobile.css" media="all">
<link rel="stylesheet" type="text/css" href="./hanki/img_up/tmp_img/service/board_tpl/8/pc/css/default_tablet.css" media="only all and (min-width:768px)">
<link rel="stylesheet" type="text/css" href="./hanki/img_up/tmp_img/service/board_tpl/8/pc/css/co-basic.css" media="screen">
<!--[if lt IE 9]><link rel="stylesheet" type="text/css" href="/img_up/tmp_img/service/board_tpl/8/pc/css/default_tablet.css" media="all"><![endif]-->
<!--[if IE]><link rel="stylesheet" type="text/css" href="/img_up/tmp_img/service/board_tpl/8/pc/css/ie.css" media="all"><![endif]-->
<!--[if lt IE 8]><link rel="stylesheet" type="text/css" href="/img_up/tmp_img/service/board_tpl/8/pc/css/ie7.css" media="all"><![endif]-->
      <script type="text/javascript">
   
   var ssl_host = "ssl.anybuild.co.kr";
   var mall_id = "ehompy0118";
   var ssl_possible = 'on';   var LAN = "kr";
   var category = "";
   function start_page_set(){
      advertise_tmp.style.behavior='url(#default#HomePage)';
      advertise_tmp.setHomePage('http://www.hankikor.com');
   }
   function bookmark(){
      window.external.AddFavorite('http://www.hankikor.com', "한끼맛있다") ;
   }
   var page_title = "(주)쉐프마인드 맛맛";
   </script>
            <script>
         // AI-LOG 기본 스크립트
         var ai_log_user_key = "";  // 최초접속자 설정 키값 (default:null)
         var ai_log_account_id = "ehompy0118"; // AI-LOG 계정 아이디
         var ai_log_mem_id = ""; // 고객 아이디
         var ai_log_mobile_web_yn = "0"; // 모바일웹 이라면 1, 데스크탑 홈페이지라면 0
         var ai_log_app_conn_yn = "0"; // 하이브리드 앱이라면 1, 아닌경우 0
         var ai_log_page_title = "(주)쉐프마인드 맛맛"; // 페이지 제목
         var ai_log_page_url = "/bbs/g1/278081"; // 페이지 url, 빈값 입력시 브라우져 url 자동 입력 입니다.
         var ai_log_event_mode = ""; // board_reg:게시글 작성, mem_reg:회원가입, sale:매출발생  (default:빈칸)
         var ai_log_event_sale_price = ""; // ai_log_event_mode가 sale 일때  매출 금액
         </script>
                     <script type="text/javascript" id="ai_log_chk_script"></script>
            <script type="text/javascript" id="ai_log_default_script" src="chk101.ai-log.biz/etc/connect_ai_set.js?ver=1"></script>
                     </head>

      <body >
<div  >
<!-- ---------------  layout : 2칸 레이아웃 : 183741 --------------- -->


<div class="layout_183741_ grid_13">
   <div class="container_1">
<!-- ---------------   layout in : 로고 A : 183743  --------------- -->
<div   style='text-align:center;'  ><!-- 로고 A -->



<div class="logo_183743_">
   <h1><a href="./" target="_self"><img src="./hanki/img_up/shop_pds/ehompy0118/farm/logo15196106291.jpg" alt="로고"></a></h1>
   <a href="javascript:alert('스마트폰에서만 전화를 연결할 수 있습니다.');"class="toggle_183743_ tel_183743_">전화걸기</a>
   <a href="#" id="farmToggleSearch" class="toggle_183743_ toggleSearch_183743_">토글 검색</a>
   <a href="#" id="farmToggleGnb" class="toggle_183743_ toggleGnb_183743_">토글 상단로그인</a>
   <a href="#" id="farmToggleLnb" class="toggle_183743_ toggleLnb_183743_">토글 네비게이션</a>
</div>

<script>
jQuery(function($){
   // toggle contents plugin
   $.fn.toggleContents = function($target, $group)
   {
      $(this).on('click', function(){
         $(this).siblings('[id^=farmToggle]').removeClass('on');
         $(this).toggleClass('on');
         $('[id^=farmBox].on').each(function(){
            if($(this).attr('id')!=$target.attr('id')){
               $(this).removeClass('on').removeAttr('style');
            }
         });
         $target.slideToggle(200, function(){
            $target.toggleClass('on').removeAttr('style');
         });

         return false;
      });
   }

   if($('#farmBoxSearch').length){
      $('#farmToggleSearch').addClass('use');
      $('#farmToggleSearch').toggleContents($('#farmBoxSearch'));
   }
   if($('#farmBoxGnb').length){
      $('#farmToggleGnb').addClass('use');
      $('#farmToggleGnb').toggleContents($('#farmBoxGnb'));
   }
   if($('#farmBoxLnb').length){
      $('#farmToggleLnb').addClass('use');
      $('#farmToggleLnb').toggleContents($('#farmBoxLnb'));
   }
});
</script>
</div></div>
   <div class="container_2">
<!-- ---------------   layout in : 네비게이션 A : 183742  --------------- -->
<div   style='margin-top:30px;margin-bottom:20px;'  ><!-- 네비게이션 A -->





<div id="farmBoxLnb" class="lnb_183742_">
   <!-- 1 Depth -->
   <ul class="dep1">
                  <li class=" first has_sub">
         <a href="./hanki/page/sub1_3.yu" target="_self">About</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="./hanki/page/sub1_3.yu" target="_self">한끼맛있다 소개</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub1_4.yu" target="_self">오시는길</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="./hanki/page/sub2_1.yu" target="_self">MENU</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="./hanki/page/sub2_10.yu" target="_self">Diener Set Menu</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub2_2.yu" target="_self">Lunch Set Menu</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub2_1.yu" target="_self">Main Menu</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub2_4.yu" target="_self">Rice Menu</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub2_3.yu" target="_self">Pasta Menu</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub2_5.yu" target="_self">Pizza Menu</a>
               </li>
                                             <li>
                  <a href="./hanki/page/out.yu" target="_self">Salad/Drink Menu</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="./hanki/page/sub2_6.yu" target="_self">Franchise</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="./hanki/page/sub2_6.yu" target="_self">개설절차</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub2_7.yu" target="_self">개설비용</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub22.yu" target="_self">개설수익률</a>
               </li>
                                             <li>
                  <a href="./hanki/myreg/qna.yu" target="_self">1:1고객상담</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="./hanki/page/sub1_7.yu" target="_self">Store</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="./hanki/myboard/cp368638.yu" target="_self">매장찾기</a>
               </li>
                                             <li>
                  <a href="./hanki/page/sub4_1.yu" target="_self">매장둘러보기</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="./hanki/bbs/hh1.yu" target="_self">News/Notice</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="./hanki/bbs/hh1.yu" target="_self">News</a>
               </li>                   <li>
                  <a href="./hanki/bbs/news.yu" target="_self">공지사항</a>
               </li>                  <li class=" on">
               <a href="./hanki/BoardList.bo" target="_self">자유게시판</a>
            </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
         
                  <li class="ast has_sub">
         <a href="./hanki/page/sub3_1.yu" target="_self">Reservation</a>
               <div>         
               <ul class="dep2">                     
                     <li>
                  <a href="./hanki/page/sub3_1.yu" target="_self">예약하기</a>
               </li>
                     <li>
                  <a href="./hanki/page/sub3_2.yu" target="_self">예약확인</a>
               </li>
                           </ul>
            </div>      </li>
         </ul>
   <!-- // 1 Depth -->
</div>
</div></div>
</div>
</div><div  >
<!-- ---------------  layout : 1칸 레이아웃 : 57710 --------------- -->



<div class="layout_57710_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 서브페이지 제목 : 57711  --------------- -->
<div   style='margin-top:135px;margin-bottom:135px;text-align:center;'  ><!-- 서브페이지 제목 -->



<div class="sub_title_57711_">
   <h1>자유게시판</h1>   </div>
</div></div>
   </div>
</div>
</div><!-- ---------------  layout : 2칸 레이아웃 : 57341 --------------- -->



<div class="layout_57341_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 서브 네비게이션 : 57715  --------------- -->
<div   style='margin-bottom:15px;margin-left:20px;margin-right:20px;' ><!-- 서브 네비게이션 -->





<div id="snb_57715_" class="snb_57715_">
   <h1>News/Notice</h1>
   <!-- 1 Depth -->
   <ul class="dep1">
                                       <li>
            <a href="./hanki/bbs/hh1.yu" target="_self">News</a>
                     </li>               <li>
            <a href="./hanki/bbs/news.yu" target="_self">공지사항</a>
                     </li>                <li class="on">
            <a href="./hanki/BoardList.bo" target="_self">자유게시판</a>
                     </li>         
               </ul>
   <!-- // 1 Depth -->
</div>

<script>
jQuery(function($){
   $('#snb_57715_ [role=toggle] > a').on('click', function(){
      var
         $li = $(this).parent()
         ,$lis = $(this).closest('ul').children()
         ,$active = $(this).parent().parent().children('.active')
         ,$on = $(this).parent().parent().children('.on')
      ;
      if ($li.hasClass('active')){
         $li.removeClass('active');
         $li.children('div').slideUp(200);
      }
      else
      {
         $active.children('div').slideUp(200);
         $active.removeClass('active');
         $li.addClass('active');
         $(this).next().slideDown(200);
      }
      $on.removeClass('on').removeClass('active');
      $on.children('div').slideUp(200);
      $on.find('.on').removeClass('on');
      return false;
   });
   $('#snb_57715_ [role=toggle].on').each(function(){
      $(this).children('div').slideDown(200);
   });
});
</script>
</div></div>
      <div class="container_2">
<!-- ---------------   layout in : 마이페이지 상단메뉴 : 57346  --------------- -->
<div   style='text-align:center;'  ><!-- 마에피이지 상단메뉴 -->




<nav class="mypage_nav_57346_">
   </nav>
</div>
<!-- ---------------   layout in : BODY_CONTENT : 57345  --------------- -->
<div   style='margin-top:-5px;margin-bottom:-10px;'  >

<!-- ---------------  layout : 1칸 레이아웃 : 57597 --------------- -->



<div class="layout_57597_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 이미지 (비율형) : 58593  --------------- -->
<div   style='margin-top:5px;text-align:center;'  ><!-- 이미지 (비율형) -->




<div class="img_ratio_58593_">
         <img src="./hanki/thum_img/ehompy0118/farm/2ebfa724534437351a10717dcb6edacb_water__c1_w550_h188.jpg" alt="디너세트">
   </div>
</div></div>
   </div>
</div>

<!-- ---------------    board content : 57600 --------------- -->
<div   style='margin-top:20px;'  >


<div id="scbd" class="scbd co-basic">
   <!-- category and board list -->

   
   
   <!-- // category and board list -->

   <div id="lay_hd" class="lay_hd">
      <div class="hgroup">
         <h1><a href="javascript:goList()">자유게시판</a></h1>
         <ul>
          <!--   <li>
               <a href="#" id="btnToggleSearch">검색<i class="ui-ico search"></i></a>
            </li> -->
            <li>
               <a href="javascript:writeArticle()">글쓰기<i class="ui-ico write"></i></a>
            </li>         </ul>
      </div>
      
      <div id="toggleSearch" class="toggleSearch">
         <fieldset>
            <legend class="blind">게시글 검색</legend>
               <div>
                  <input type="text" name="search_key" id="search_key" maxlength="30" value="" placeholder="검색어">
                  <button class="ui-ico">검색</button>
               </div>
            </fieldset>
      </div>
   </div>

   <div class="det">
      <!-- Head -->
      <div class="hgroup">
         <div class="title">
            <strong><%=board.getBOARD_SUBJECT()%></strong>
         </div>
            <dl>
               <dt>
                  <span><%=board.getBOARD_NAME() %></span><span><%=board.getBOARD_READCOUNT() %></span>
               </dt>
            <dd><span><%=board.getBOARD_DATE() %></span></dd>
            </dl>
         </div>
      <!-- // Head -->

      <!-- url copy -->
      <!-- <div class="copyurl">
         <a href="http://www.hankikor.com/bbs/g1/278081" target="_blank">http://www.hankikor.com/bbs/g1/278081</a>
         <a href="javascript:clip('http://www.hankikor.com/bbs/g1/278081')" class="btn" title="URL COPY">URL COPY</a>
      </div> -->
      <!-- // url copy -->

      <!-- bgm -->
            <!-- // bgm -->
               <!-- contents body -->
         <div id="conbody" class="conbody">
            <%=board.getBOARD_CONTENT() %>
         </div>
         <!-- // contents body -->
      <div class="mid_design"></div>
         <div class="clr">
            <div class="sbtns">
      <a href="javascript:replyArticle()">답글</a>
      <a href="javascript:editArticle()">수정</a>
      <%-- <a href="/BoardDelete.bo?num=<%=board.getBOARD_NUM()%>">삭제</a>            --%>                                     
<!--       <a href="javascript:deleteArticle()">삭제</a>                                                 -->
      <a href="javascript:board_view_print()">출력</a>
            </div>
         </div>
      <!-- SNS share -->
            <!-- // SNS share -->

      <!-- buttons -->
      <div class="btngroup">
         <a href="javascript:goList()" class="ui-btn btn-co1">목록</a>
      </div>      <!-- // buttons -->

      
               <!-- Comment contents -->
         <div class="ui-toggle" rel="open">
            <div class="hd">
               <h1>댓글[0]</h1>
               <p>
                  <span class="open">열기<i class="ui-ico"></i></span>
                  <span class="close">닫기<i class="ui-ico"></i></span>
               </p>
            </div>
            <div class="bd" idx="278081"><iframe name='comment_278081' id='comment_278081' marginheight='0' marginwidth='0' src='./hanki/bbs_shop/comment_list.htm?me_popup=&auto_frame=&board_code=g1&board_code=g1&board_idx=278081' width='100%' height='100px' style='border:0;' border=0 title='댓글 출력용 프레임' scrolling=no allowtransparency='true'></iframe></div>
         </div>
         <!-- // Comment contents -->
         </div>
</div>

</div></div></div>
   </div>
</div>

<%--<tr>
      <td style="font-family:돋음; font-size:12">
         <div align="center">첨부파일</div>
      </td>
      <td style="font-family:돋음; font-size:12">
      <%if(!(board.getBOARD_FILE()==null)){ %>
      <a href="./boardupload/<%=board.getBOARD_FILE()%>">
         <%=board.getBOARD_FILE() %>
      </a>
      <%} %>
      </td>
   </tr>
   
   <tr bgcolor="cccccc">
      <td colspan="2" style="height:1px;"></td>
   </tr>
   <tr><td colspan="2">&nbsp;</td></tr>
   
   <tr align="center" valign="middle">
      <td colspan="5">
         <font size=2>
         <a href="./BoardReplyAction.bo?num=<%=board.getBOARD_NUM() %>">
         [답변]</a>
         
         &nbsp;&nbsp;
         <a href="./BoardModify.bo?num=<%=board.getBOARD_NUM() %>">
         [수정]</a>
         &nbsp;&nbsp;
         <a href="./BoardDelete.bo?num=<%=board.getBOARD_NUM() %>">
         [삭제]</a>
         &nbsp;&nbsp;
         <a href="./BoardList.bo">[목록]</a>&nbsp;&nbsp;
         </font>
      </td>
   </tr> --%>

<!-- ---------------    공백 : 57348 --------------- -->
<!-- 공백 -->



<span class="empty_line_57348_"></span>

<!-- ---------------    아이콘 버튼 : 184702 --------------- -->
<div   style='background-Color:#f3f3f3;'  >
<!-- ---------------  layout : 1칸 레이아웃 : 57719 --------------- -->



<div class="layout_57719_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 하단 메뉴 : 57720  --------------- -->
<div   style='margin-top:5px;margin-bottom:3px;text-align:center;'  ><!-- 하단 메뉴 -->




<nav class="fnb_57720_">
   <ul>
               <li><a href="../shop_info/privacy.htm">개인정보취급방침</a></li>
               <li><a href="../shop_info/agree.htm">이용약관</a></li>
               <li><a href="../page/sub1_3" target="_self">한끼맛있다 소개</a></li>
               <li><a href="../page/sub2_6" target="_self">개설절차</a></li>
               <li><a href="../myboard/cp368638" target="_self">매장찾기</a></li>
               <li><a href="../page/sub1_4" target="_self">오시는길</a></li>
               <li><a href="../page/sub2_1" target="_self">MENU</a></li>
         </ul>
   </nav>
</div></div>
   </div>
</div>
</div><div   style='background-Color:#5f5a58;' >
<!-- ---------------  layout : 1칸 레이아웃 : 58202 --------------- -->



<div class="layout_58202_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 하단 정보 : 58201  --------------- -->
<div   style='margin-top:20px;margin-bottom:20px;margin-left:10px;text-align:center;'  ><!-- 하단 정보 -->



<div class="footer_info_58201_">
   <ul>
      <li>(주)쉐프마인드</li>      <li>대표자: 김성일, 김성수</li>      <li>사업자 등록번호: 585-86-00368 <!--<a href="javascript:popup_window('http://www.ftc.go.kr/info/bizinfo/communicationViewPopup.jsp?wrkr_no=1674800116',750,700)" class="bizinfo">사업자정보확인</a>--></li>      <li>주소: 부산광역시 부산진구 동천로 136, 3층 (전포동)  </li>      <li>TEL. 1899-6731</li>      <li>FAX. 051-803-0423</li>      <li>.</li>
         </ul>
   <ul>
      <li>Copyright(c) (주)쉐프마인드. All Rights Reserved. </li>
 <li><a href="http://www.ehompy.co.kr/" target="_blank"> <font color="#000"><b>Homepage by 이홈피넷 </b></font></a></li>
   </ul>
</div>
</div></div>
   </div>
</div>
</div><!-- ---------------    상단으로 바로가기 버튼 : 57356 --------------- -->
<!-- 상단으로 바로가기 -->




<script>
$(window).on('scroll', function(){
   if ($(this).scrollTop() > 300){
      $('.scroll_top_57356_').addClass('on');
   }else{
      $('.scroll_top_57356_').removeClass('on');
   }
});

jQuery(function($){
   $('.scroll_top_57356_').click(function() {
      $('body,html').animate({
         scrollTop: 0
      }, 800);
      return false;
   });
})

</script>

<div class="scroll_top_57356_">
   <span>상단으로 바로가기</span>
</div>
<script type="text/javascript" src="./hanki/js/all_bottom_script.js"></script>
<script type="text/javascript">
all_page_script('','','','','','','','','0');
</script>
<script type="text/javascript">
var tmp_chk2=0;

function div2_move_chk(){
   if(!tmp_chk2){
      tmp_div2.style.top = tmp_div2.offsetTop-230;
      tmp_chk2 = 1;
   }
}

function no_blog(){
   alert("블러그형은 로그인해야 볼수 있습니다.");
}

function writeArticle(){
   location.href="./hanki/BoardWrite.bo";
   /* location.href="../bbs_shop/write_form.htm?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&mode=write&board_code=g1"; */
   }
function readArticle(idx){

         location.href="../bbs_shop/read.htm?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&search_key=&key=&page=0&y=&m=&idx="+idx;
   }
function reply_readArticle(idx){
         location.href="../bbs_shop/read.htm?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&search_key=&key=&page=0&idx="+idx;
   }

function no_write(){
   alert("본 게시판은 회원 전용 게시판입니다.\n\n로그인하신후 다시 이용하시기 바랍니다.");
}

function no_blog(){
   alert("블러그형은 로그인해야 볼수 있습니다.");
}

//게시글 출력에 필요한 함수
function ToggleAll1(){

   var i =0;
   while(i < document.board_form.elements.length){
      if(document.board_form.elements[i].name=='idx_chk[]'){
         if(document.board_form.elements[i].checked == true){
            document.board_form.elements[i].checked = false;
         }else{
            document.board_form.elements[i].checked = true;
         }
      }
      i++;
   }
}

function mem_secret_no_read(){
                  alert("본 게시글은 로그인을 해야만 볼수 있습니다.");
         }

function secret_no_read2(idx){
   secret_read2(idx);
   //alert("본 게시글은 [회원 전용 비밀글]로 설정되어 있습니다.\n\n [회원 전용 비밀글]은 관리자 또는 작성자만 볼수 있습니다.");
}

function secret_read2(idx){
         var secret_read2_win = window.open('../bbs_shop/popup/pwd_chk_form.htm?pwd_mode=board_secret&me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&search_key=&key=&page=0&idx='+idx,'secret_read2_win','top=150,left=300,width=330,height=200,scrollbars=no');
      secret_read2_win.focus();
   }

function tmp_div2_close(){
   tmp_div2.style.display = 'none';
}
</script>

<div id='tmp_div2' style='position:absolute;display:none;'>
   <iframe src='' width=360 height=213 style='border:0' title='게시판 체크 프레임' name='tmp_frame2' id='tmp_frame2' scrolling=no allowtransparency="true"></iframe>
</div>

<script type="text/javascript" src='./hanki/bbs_shop/js/board.js'></script>
<script type="text/javascript" src='./hanki/bbs_shop/js/sub_menu.js'></script>
<script type="text/javascript">
function scrap_cyworld_pop(idx){
   
      var w = 450;
      var h = 410;
      var window_left = (screen.width-w)/2;
      var window_top = (screen.height-h)/2;
      var cyopenscrap = window.open('http://api.cyworld.com/openscrap/post/v1/?xu=http%3A%2F%2Fwww.hankikor.com%2Fbbs_shop%2Fscrap_cyworld.php%3Fboard_code%3Dg1%26idx%3D'+idx+'&sid=y7NSneU4hjAxwDnNpa3QtP89ptHNy4TL','cyopenscrap','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
      cyopenscrap.focus();
      
}

function scrap_twitter_pop(idx){
   window.open('../bbs_shop/scrap_twitter.php?board_code=g1&idx='+idx);
}

function scrap_me2day_pop(idx){
   window.open('../bbs_shop/scrap_me2day.php?board_code=g1&idx='+idx);
}

function scrap_facebook_pop(idx){
   window.open('../bbs_shop/scrap_facebook.php?board_code=g1&idx='+idx);
}

function link_board_code_ch(tar){
   location.href='../bbs_shop/list.htm?me_popup=&auto_frame=&board_code='+tar.value
}

function link_cate_sub_ch(tar){
   location.href='../bbs_shop/list.htm?me_popup=&auto_frame=&cate_sub_idx='+tar.value+'&list_mode=board&board_code=g1';
}


function scrap_mypage_pop(idx){
   
      alert('스크랩은 로그인 후 이용가능합니다.');
      
}
</script><script type="text/javascript">
//parent.scrollTo(0, 0);
var tmp_chk=0;

function div_move_chk(){
   if(!tmp_chk){
      tmp_div.style.top = tmp_div.offsetTop-230;
      tmp_chk = 1;
   }
}

function goList(){
   location.href="./BoardList.bo";
/*    location.href="../bbs_shop/list.htm?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&keyfield=&key=&page=0&y=&m="; */
}
function editArticle(){
   location.href= "./passch.bo?num=<%=board.getBOARD_NUM()%>";

         }
function replyArticle(){
         location.href="../bbs_shop/reply_form.htm?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&keyfield=&key=&page=0&idx=278081";
   }
function deleteArticle(){           
       var del_win = window.open('../bbs_shop/popup/pwd_chk_form.htm?pwd_mode=board_del&me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&idx=278081&board_code=g1&keyfield=&key=&page=0','del_win','top=150,left=300,width=330,height=450,scrollbars=no');
         del_win.focus();
         }
function moveArticle(){
         var move_win = window.open('../bbs_shop/popup/move_form.htm?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&idx=278081&board_code=g1&keyfield=&key=&page=0','move_win','top=150,left=300,width=330,height=450,scrollbars=no');
      move_win.focus();
   }

function secret_read(idx){
         var move_win = window.open('../bbs_shop/popup/pwd_chk_form.htm?pwd_mode=board_secret&me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&keyfield=&key=&page=0&idx='+idx,'move_win','top=150,left=300,width=330,height=450,scrollbars=no');
      move_win.focus();
   }

function secret_no_read(idx){
   //alert("본 게시글은 [회원 전용 비밀글]로 설정되어 있습니다.\n\n [회원 전용 비밀글]은 관리자 또는 작성자만 볼수 있습니다.");
   secret_read(idx);
}

function tmp_div_close(){
   tmp_div.style.display = 'none';
}

function resizeImage(num,stop){

   if(!stop) stop=0;
   if(stop > 6) return;

   var obj = document.getElementById("userImg" + num);
   if(obj){
               if (obj.width > 600) obj.width = 600;
         }
}


function goConfirm(){
   if(confirm("정상등록 하시겠습니까?")){
      var iframe_name = create_iframe();
      document.getElementById(iframe_name).src="../bbs_shop/confirm_ok.php?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&idx=278081&board_code=g1&keyfield=&key=&page=0";
   }
}

function goConfirm_no(){
   if(confirm("게시글을 안보이도록 설정 하시겠습니까?")){
      var iframe_name = create_iframe();
      document.getElementById(iframe_name).src="../bbs_shop/confirm_no.php?me_popup=&auto_frame=&cate_sub_idx=0&list_mode=board&idx=278081&board_code=g1&keyfield=&key=&page=0";
   }
}

function board_view_print(){
         var w = 700;
      var h = 600;
      var window_left = (screen.width-w)/2;
      var window_top = (screen.height-h)/2;
      var board_view_print_win = window.open('../bbs_shop/read.htm?print_yn=1&board_code=g1&idx=278081','board_view_print_win','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
      board_view_print_win.focus();
   }

function file_download(sel_no,file_name){
   var file_name_arr = new Array();
   
                              var iframe_name = create_iframe();
            document.getElementById(iframe_name).src = "../bbs_shop/file_download.php?board_code=g1&board_idx=278081&sel_no="+sel_no;
                  }


</script>

<div id='tmp_div' style='position:absolute;display:none;'>
   <iframe src='' width=360 height=213 style='border:0' title='게시판 체크 프레임' name='tmp_frame' id='tmp_frame' scrolling=no allowtransparency="true"></iframe>
</div>

<script type="text/javascript">

// 아래 함수 사용 금지..
function vicious_chk(){
         var w = 400;
      var h = 350;
      var window_left = (screen.width-w)/2;
      var window_top = (screen.height-h)/2;
      var vicious_chk_win = window.open('../bbs_shop/popup/vicious_form.htm?mode=board&idx=278081','vicious_chk','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
      vicious_chk_win.focus();
   }

// 아래 함수 사용 할것.
function read_vicious_chk(){
         var w = 400;
      var h = 350;
      var window_left = (screen.width-w)/2;
      var window_top = (screen.height-h)/2;
      var vicious_chk_win = window.open('../bbs_shop/popup/vicious_form.htm?mode=board&idx=278081','vicious_chk','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
      vicious_chk_win.focus();
   }


function board_chu_ok(){
   if(confirm("추천 하시겠습니까?")){
      var iframe_name = create_iframe();
      document.getElementById(iframe_name).src="../bbs_shop/read_chu_ok.php?board_code=g1&idx=278081";
   }
}


function view_Poll(){
   location.href="../bbs_shop/read.htm?board_code=g1&idx=278081&poll_view=1";
}

function vote_Poll(){
   var form = document.frmPoll;


   var poll_sel = 0;
   for(var i=0; i<document.getElementsByName("poll_chk_no").length; i++){
      if(document.getElementsByName("poll_chk_no")[i].checked == true){
         poll_sel = document.getElementsByName("poll_chk_no")[i].value;
         break;
      }
   }

   if(!poll_sel){
      alert("하나 이상 투표해주셔야 합니다.");
   }else{
      location.replace("../bbs_shop/read.htm?board_code=g1&idx=278081&poll_idx=0&poll_sel="+poll_sel)
   }
}



</script>
<script type="text/javascript">
function comment_chu_ok(idx){
   if(confirm("추천 하시겠습니까?")){
      var iframe_name = create_iframe();
      document.getElementById(iframe_name).src="../bbs_shop/comment_chu_ok.php?idx="+idx;
   }

}

function deleteComment(bbs_read_idx,idx){
   if (confirm("댓글을 삭제하시겠습니까?")){
      var iframe_name = create_iframe();
      document.getElementById(iframe_name).src="../bbs_shop/popup/pwd_chk_exec.php?pwd_mode=comment_del&board_code=g1&board_idx="+bbs_read_idx+"&idx="+idx;
   }
}

function editComment(bbs_read_idx,idx){

         var w = 400;
      var h = 280;
      var window_left = (screen.width-w)/2;
      var window_top = (screen.height-h)/2;
      var editComment_win = window.open("../bbs_shop/popup/comment_edit_form.htm?board_code=g1&board_idx="+bbs_read_idx+"&idx="+idx,"editComment_win","top="+window_top+",left="+