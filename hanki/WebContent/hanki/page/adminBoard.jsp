<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String id = (String)request.getSession().getAttribute("id"); %>

<%String store_name = (String)request.getSession().getAttribute("store_name"); %>
<%if(session.getAttribute("suc")!=null){
	int suc;
	suc = ((Integer)session.getAttribute("suc")).intValue();
	
	if(suc==0){
 		/*
 		PrintWriter script = response.getWriter();
 		script.println("<script>");
 	    script.println("alert('test');");
 	    script.println("</script>"); 
        */
       out.println("<script>");
       out.println("alert('매장등록을 성공하였습니다.')");
       out.println("</script>");
       session.removeAttribute("suc");
	}
session.removeAttribute("suc");
}  %>
<%-- <%=store_name %> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>한끼맛있다</title>
<meta name="naver-site-verification" content="fdb874a536daa44431e562983af2c160a76457cf"/>
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=2.0, minimum-scale=0.5, width=device-width">
<meta name="subject" content="한끼맛있다" />
<meta name="copyright" content="(주)쉐프마인드" />
<meta name="title" content="한끼맛있다" />
<meta name="description" content="패밀리 퓨전레스토랑 프랜차이즈, 브랜드스토리, 메뉴소개 및 매장안내, 매장창업" />
<link rel="canonical" href="http://www.hankikor.com/" />
<meta property="og:title"           content="한끼맛있다"/>
<meta property="og:site_name"       content="(주)쉐프마인드"/>
<meta property="og:type"            content="website"/>
<meta property="og:url"             content="http://www.hankikor.com/main"/>
<meta property="og:image"           content="http://www.hankikor.com/thum_img/ehompy0118/og_img/og_logo1519610629.jpg"/>
<meta property="og:description"     content="패밀리 퓨전레스토랑 프랜차이즈, 브랜드스토리, 메뉴소개 및 매장안내, 매장창업"/>
<meta name="twitter:card"           content="summary">
<meta name="twitter:title"          content="한끼맛있다">
<meta name="twitter:site"           content="(주)쉐프마인드">
<meta name="twitter:image"          content="http://www.hankikor.com/thum_img/ehompy0118/og_img/og_logo1519610629.jpg">
<meta name="twitter:description"    content="패밀리 퓨전레스토랑 프랜차이즈, 브랜드스토리, 메뉴소개 및 매장안내, 매장창업">
<link rel="shortcut icon" href="../img/favicon_null.png" />
<script type="text/javascript" src="../img_up/_addon/jquery/1.11.3/jquery.min.js"></script>


<link rel="stylesheet" href="../css/head_basic.css" type="text/css" media="all" />
<link rel="stylesheet" href="../css/head_logout.css" type="text/css" media="all" />
<script type="text/javascript">var MOBILE_CONN_YN = false;</script>
<script type="text/javascript" src="../js/all_default.js"></script>
<script type="text/javascript">
var ios_yn = false;
var APP_CONN_YN = false;
var isKitkat = window.navigator.userAgent.search( "AnybuildApp Android 4.4") > -1 ? true : false;
</script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/etc/navi_category_all.js"></script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/etc/goods_category_all.js"></script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/etc/board_list.js"></script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/etc/site_category_all.js"></script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/etc/gisa_category_all.js"></script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/etc/movie_category_all.js"></script>
<script type="text/javascript" src="../js/all_default2.js"></script>
<script type="text/javascript" src="../js/google_map.js"></script>
<script type="text/javascript" src="../js/load_frame.js"></script>
<script type="text/javascript" src="../js/head_logout.js"></script>
<script type="text/javascript" id='naver_map_js' ></script>
<script type="text/javascript" id='dynamic_js' ></script>

<script type="text/javascript" src="../img_up/_addon/jquery/1.11.3/jquery.min.js"></script>
<!---->

<link rel="stylesheet" type="text/css" href="../img_up/_addon/css/reset_1.0.css">

<link rel="stylesheet" type="text/css" href="../img_up/shop_pds/ehompy0118/src_css_fram/pc.skin.admin.css" />
<script type="text/javascript" src="../img_up/_addon/_plugin/modernizr/modernizr.custom.media.query.js"></script>
<link rel="stylesheet" type="text/css" href="../img_up/shop_pds/ehompy0118/src_css_fram/pc.main.44525.css" />
<link rel="stylesheet" type="text/css" href="../img_up/shop_pds/ehompy0118/design/owl.carousel.min.css" />
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/design/owl.carousel.min.js"></script>
<script type="text/javascript" src="../img_up/shop_pds/ehompy0118/design/modernizr.custom.media.query.js"></script>


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
   var page_title = "한끼맛있다";
   </script>
            <script>
         // AI-LOG 기본 스크립트
         var ai_log_user_key = "";  // 최초접속자 설정 키값 (default:null)
         var ai_log_account_id = "ehompy0118"; // AI-LOG 계정 아이디
         var ai_log_mem_id = ""; // 고객 아이디
         var ai_log_mobile_web_yn = "0"; // 모바일웹 이라면 1, 데스크탑 홈페이지라면 0
         var ai_log_app_conn_yn = "0"; // 하이브리드 앱이라면 1, 아닌경우 0
         var ai_log_page_title = "한끼맛있다"; // 페이지 제목
         var ai_log_page_url = "./main"; // 페이지 url, 빈값 입력시 브라우져 url 자동 입력 입니다.
         var ai_log_event_mode = ""; // board_reg:게시글 작성, mem_reg:회원가입, sale:매출발생  (default:빈칸)
         var ai_log_event_sale_price = ""; // ai_log_event_mode가 sale 일때  매출 금액
         </script>
                     <script type="text/javascript" id="ai_log_chk_script"></script>
            <script type="text/javascript" id="ai_log_default_script" src="https://chk101.ai-log.biz/etc/connect_ai_set.js?ver=1"></script>
                     </head>

      <body >
<div  >
<!-- ---------------  layout : 2칸 레이아웃 : 182959 --------------- -->


<div class="layout_182959_ grid_13">
   <div class="container_1">
<!-- ---------------   layout in : 로고 A : 182961  --------------- -->
<div   style='text-align:center;'  ><!-- 로고 A -->



<div class="logo_182961_">
   <h1><a href="./admin.ad" target="_self"><img src="../img_up/shop_pds/ehompy0118/farm/logo1519610629.jpg" alt="로고"></h1>
   <a href="javascript:alert('스마트폰에서만 전화를 연결할 수 있습니다.');"class="toggle_182961_ tel_182961_">전화걸기</a>
   <a href="#" id="farmToggleSearch" class="toggle_182961_ toggleSearch_182961_">토글 검색</a>
   <a href="#" id="farmToggleGnb" class="toggle_182961_ toggleGnb_182961_">토글 상단로그인</a>
   <a href="#" id="farmToggleLnb" class="toggle_182961_ toggleLnb_182961_">토글 네비게이션</a>
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
<!-- ---------------   layout in : 네비게이션 A : 182960  --------------- -->
<div   style='margin-top:30px;margin-bottom:20px;'  ><!-- 네비게이션 A -->





<div id="farmBoxLnb" class="lnb_182960_">
   <!-- 1 Depth -->
   <ul class="dep1">
                  <li class=" first has_sub">
         <a href="../ResBoardList.yu" target="_self">예약 관리</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="../ResBoardList.yu" target="_self">예약 현황</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="../../BoardList.bo" target="_self">게시판 관리</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
            	<%if(store_name.equals("전국점포")){ %> 
                                             <li>
                  <a href="./page/sub2_10.jsp" target="_self">공지/뉴스 관리</a>
               </li>
               <%} %>
                                             <li>
                  <a href="./adminboard.ad" target="_self">자유게시판 관리</a>
               </li>                                           
               <%if(store_name.equals("전국점포")){ %>               
                               <li>
                  <a href="../QnaListAction.yu" target="_self">1:1 문의 게시판</a>
               </li>
               <%}%>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="./adminsales.ad" target="_self">판매 관리</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
            <%if(store_name.equals("전국점포")){%>
                   <li>
                  <a href="./adminDaily.ad" target="_self">일자별 현황</a>
               </li>
                                        
                                             
                         
            
            <% }else{ %>
              <li>
                  <a href="./adminsales.ad" target="_self">매장 매출 관리</a>
               </li>
               <li>
                  <a href="./adminsaleslist.ad" target="_self">매장 매출 현황</a>
               </li>
                                             <li>
                  <a href="./adminDaily.ad" target="_self">일자별 현황</a>
               </li>
                                        
                        <% } %>                     
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <p>dddd</p>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                                       <li>
                  <a href="./sub2_6.jsp" target="_self">일자별 현황</a>
               </li>
                                             <li>
                  <a href="./sub2_7.jsp" target="_self">월별 현황</a>
               </li>
                                             
                           </ul>
                           <!--  -->
             <%if(store_name.equals("전국점포")){%>
              </div>      
              </li>
              <li class=" has_sub">
              <a href="./adminJoin.ad" target="_self"><%=store_name %></a>
       		  <div>
        	  <ul class="dep2">
              <li>
					<a href="./adminJoin.ad" target="_self">매장 등록</a>
			  </li>
			  <li>
					<a href="./adminManage.ad" target="_self">매장 관리</a>
			  </li>
              </ul>
              </div>      
              </li>
       		  <%}else{%>
       		  
              <li class=" has_sub">
              <a href="./admin.ad" target="_self"><%=store_name %></a>
       		  <%} %>
              <!-- 2 Depth -->
              
              <li class=" has_sub">
     		 <a href="./adminLogin.ad" target="_self">로그아웃</a>
         <div>
            <!-- // 2 Depth -->
             </div>      </li>
            <!-- // 2 Depth -->
   <!-- // 1 Depth -->
</div>
</div></div>
</div>
</div><!-- ---------------    body content : 57327 --------------- -->


<!-- ---------------    배너관리 - 이미지 슬라이드 (확장형) : 57297 --------------- -->
<div  >








<div id="owl__57297_" class="owl-carousel">
         <div class="item" data-hash="_57297__item0">
               <img src="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu11519619214.jpg"
             data-src-m="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu11519619214.jpg"
               data-src="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu11519619214.jpg"
                alt="" class="main_img">                  </div>
         <div class="item" data-hash="_57297__item1">
               <img src="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu21519619225.jpg" data-src-m="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu21519619225.jpg" data-src="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu21519619225.jpg" alt="" class="main_img">                  </div>
         <div class="item" data-hash="_57297__item2">
               <img src="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu31519619236.jpg" data-src-m="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu31519619236.jpg" data-src="../img_up/shop_pds/ehompy0118/contents/banner/me-in-seul-ra-i-deu31519619236.jpg" alt="" class="main_img">                  </div>
   </div>
<script>
jQuery(function($) {
   $('#owl__57297_').owlCarousel({
      margin: 0,                        // 이미지 간격
      loop: true,                        // 무한 반복
      center: false,                     // 액티브 슬라이드 가운데 정렬
      mouseDrag: true,                  // 마우스 드레그 사용
      touchDrag: true,                  // 터치 드레그 사용
      stagePadding: 0,                  // 스테이지 여백 (좌우 슬라이드 노출)
      nav: false,               // 방향 네비게이션
      dots: true,               // 하단 네비게이션
      dotsEach: false,                  // 하단 네비게이션 (페이지별 출력,항목별 출력)
      autoplay: true,                     // 자동 재생
      smartSpeed: 250,                  // 슬라이드 속도
      responsiveRefreshRate: 200,            // 반응형 체크 시간
      startPosition: 0,                  // 시작 슬라이드 번호
      URLhashListener: false,               // #URL 로 액티브 슬라이드 동작
      autoplayHoverPause: false,            // 마우스 오버시 일시정지
      responsiveClass: false,               // 반응형 class명 사용 (owl-reponsive-0)
      navContainer: false,               // 방향 네비게이션 커스터마이징
      dotsContainer: false,               // 하단 네비게이션 커스터마이징
      items:1,                        // 한 화면 출력수
      slideBy:1,                        // 한번에 슬라이드 되는 수
      animateOut: 'fadeOut'   // 슬라이드(''), 페이드(fadeOut)
   })

   changeImg();

   $(window).on('resize',function(){
      changeImg();
   });

});

function changeImg(){
   if(Modernizr.mq('only all and (min-width:1024px)')==true){
      $('#owl__57297_').find('.main_img').each(function(){
         $(this).attr('src',$(this).attr('data-src'));
      });
   }else{
      $('#owl__57297_').find('.main_img').each(function(){
         $(this).attr('src',$(this).attr('data-src-m'));
      });
   }
}
</script>
</div>
<!-- ---------------    이미지 : 183800 --------------- -->

<!-- ---------------    공백 : 57634 --------------- -->
<!-- 공백 -->



<span class="empty_line_57634_"></span>
<div  >
<!-- ---------------  layout : 2칸 레이아웃 : 57628 --------------- -->



<div class="layout_57628_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 타이틀 텍스트 : 57630  --------------- -->
<div   style='margin-left:3px;margin-right:3px;background-Color:#4C4C4C;text-align:center;'  ><!-- 타이틀 텍스트 -->




<div class="title_57630_ style_none">
   <p>한끼맛있다 메뉴안내</p>
</div>
</div>
<!-- ---------------   layout in : 공백 : 57311  --------------- -->
<div   style='margin-left:3px;margin-right:3px;background-Color:#4C4C4C;'  ><!-- 공백 -->



<span class="empty_line_57311_"></span>
</div>
<!-- ---------------   layout in : 공백 : 183842  --------------- -->
<div   style='margin-left:3px;margin-right:3px;'  ><!-- 공백 -->



<span class="empty_line_183842_"></span>
</div>
<!-- ---------------   layout in : 바둑판형태 이미지출력(반응형) : 57627  --------------- -->




<div class="pm-banner_responsive__57627_">
   <ul>
                  <li class="item  m_clear t_clear p_clear">
                  <a href="./page/sub2_10.jsp">
                     <img src="../thum_img/ehompy0118/banner/f4a4f7540dc18e808dc61e9926df2ef3_water__c1_w130_h200.jpg" alt="dinner set menu">                  </a>
               </li>
                  <li class="item ">
                  <a href="./page/sub2_2.jsp">
                     <img src="../thum_img/ehompy0118/banner/3fe8f2bd07020a69e380a31e4cd2ec2d_water__c1_w130_h200.jpg" alt="lunch set menu">                  </a>
               </li>
                  <li class="item  m_clear">
                  <a href="./page/sub2_1.jsp">
                     <img src="../thum_img/ehompy0118/banner/8a90b3478e36751ed1d6513ce6540c3d_water__c1_w130_h200.jpg" alt="main menu">                  </a>
               </li>
                  <li class="item  t_clear">
                  <a href="./page/sub2_4.jsp">
                     <img src="../thum_img/ehompy0118/banner/864899ca43f05da453889b930ee6c710_water__c1_w130_h200.jpg" alt="fusion rise menu">                  </a>
               </li>
                  <li class="item  m_clear">
                  <a href="./page/sub2_3.jsp">
                     <img src="../thum_img/ehompy0118/banner/a88c69b9c1cc1761d9fa44647efbf242_water__c1_w130_h200.jpg" alt="fusion pasta menu">                  </a>
               </li>
                  <li class="item ">
                  <a href="./page/sub2_5.jsp">
                     <img src="../thum_img/ehompy0118/banner/0f86f903568a806d6fb9c2e690ea6f63_water__c1_w130_h200.jpg" alt="fusion pizza menu">                  </a>
               </li>
                  <li class="item  m_clear t_clear">
                  <a href="../page/out.jsp">
                     <img src="../thum_img/ehompy0118/banner/4d697183a5cbebf6458767f55033cc1b_water__c1_w130_h200.jpg" alt="salsd&drink">                  </a>
               </li>
               </ul>
</div>
</div>
      <div class="container_2">
<!-- ---------------   layout in : 이미지 (비율형) : 57629  --------------- -->
<!-- 이미지 (비율형) -->




<div class="img_ratio_57629_">
         <img src="../thum_img/ehompy0118/farm/9afcd07661081e3b7131ffc61953e613_water__c1_w240_h238.jpg" alt="이미지명">
   </div>
</div>
   </div>
</div>
</div><!-- ---------------    공백 : 183844 --------------- -->
<div  ><!-- 공백 -->



<span class="empty_line_183844_"></span>
</div><div  >
<!-- ---------------  layout : 3칸 레이아웃 : 57632 --------------- -->



<div class="layout_57632_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 이미지 (비율형) : 57633  --------------- -->
<!-- 이미지 (비율형) -->




<div class="img_ratio_57633_">
      <a href="./page/sub1_7" target="_self">
         <img src="../thum_img/ehompy0118/farm/753b7455e70144241efef3d570f80988_water__c1_w370_h200.jpg" alt="매장찾기">
      </a>
   </div>
</div>
      <div class="container_2">
<!-- ---------------   layout in : 이미지 (비율형) : 57638  --------------- -->
<!-- 이미지 (비율형) -->




<div class="img_ratio_57638_">
         <img src="../thum_img/ehompy0118/farm/7178c3ccc2b9174209214f5ca61741d1_water__c1_w370_h200.jpg" alt="매장찾기" width="370" height="200" usemap="#Map" border="0"/>
<map name="Map" id="Map">
  <area shape="rect" coords="50,135,92,175" href="https://www.facebook.com/" target="blank" />
  <area shape="rect" coords="126,135,168,176" href="https://twitter.com/" target="blank"/>
  <area shape="rect" coords="196,135,244,176" href="https://www.instagram.com/" target="blank"/>
  <area shape="rect" coords="272,134,315,177" href="https://story.kakao.com/s/login" target="blank"/>
</map>

   </div>
</div>
      <div class="container_3">
<!-- ---------------   layout in : 최근 게시글 탭 - 웹진 + 목록형 (반응형) : 57631  --------------- -->


<div id="tab__57631_" class="tab-board-extract-list pm-board_tab_webzine_list__57631_">
      <div class="tab-wrap">
      <ul class="tab-btn tab_col2">
                     <li class="on"><a href="#extract-list1-_57631_">News</a></li>
                     <li class=""><a href="#extract-list2-_57631_">Notice</a></li>
               </ul>
   </div>

               <div id="extract-list1-_57631_" class="tab-cont on">
         <ul>
                                          <li class="webzine">
                  <a href="../bbs_shop/read.htm?board_code=hh1&idx=276757&cate_sub_idx=0">
                     <div class="thumnail">
                        <img src="../thum_img/ehompy0118/2018/53c646668eab6e96b91b13116825ea1d_water__c1_w100_h100.jpg" alt="맛과 가성비를 고루 갖춘 한끼맛있다 퓨전레스토랑이 드디어' 울산삼산동'에도 생겼다아!! ">
                     </div>                     <div class="title">
                        맛과 가성비를 고루 갖춘 한끼맛있다 퓨전레스토랑이 드디어' 울산삼산동'에도 생겼다아!!                                                                      </div>
                     <div class="date">2018-04-10</div>
                                          <!--<div class="body">한끼맛있다 울산삼산점 04월 07일 grand open.!!!
울산에 한끼맛있다 삼산점이 오픈하였습니다. 한끼맛있다의 푸짐하고 맛있는 요리를 삼산동에서도 만나보실 수 있습니다.
부추통삼겹스테이크, 찹스테이크, 단호박불고기, 게살크림까르보나라,마약옥수수피자 등 다양한 셋트로 구성되어 있어 가성비최고 입니다.
가족, 연인, 친구,모임 등 삼산점에서 맛있는 ...</div>-->
                  </a>
               </li>
                                          <li class="list">
                  <a href="./bbs_shop/read.htm?board_code=hh1&idx=275597&cate_sub_idx=0">
                                          <div class="title">
                        한끼맛있다 울산삼산점 04월초 GRAND OPEN!!                                                                     </div>
                     <div class="date">2018-03-14</div>
                                          <!---->
                  </a>
               </li>
                                 </ul>
      </div>
               <div id="extract-list2-_57631_" class="tab-cont ">
         <ul>
                                          <li class="webzine">
                  <a href="../bbs_shop/read.htm?board_code=news&idx=267272&cate_sub_idx=0">
                     <div class="thumnail">
                        <img src="../thum_img/ehompy0118/2017/2ed25db98e3ef10faeb6a3a9226807b7_water__c1_w100_h100.jpg" alt="[대구월성점] 한끼맛있다 오픈준비중. (12월초오픈)">
                     </div>                     <div class="title">
                        [대구월성점] 한끼맛있다 오픈준비중. (12월초오픈)                                                                     </div>
                     <div class="date">2017-10-28</div>
                                          <!--<div class="body">한끼맛있다 대구월성점이 인테리어 공사중으로 12월초 오픈준비중입니다.</div>-->
                  </a>
               </li>
                                          <li class="list">
                  <a href="./bbs_shop/read.htm?board_code=news&idx=265054&cate_sub_idx=0">
                                          <div class="title">
                        대구성서점 11월 중순 오픈준비중 (인테리어공사착공)                                                                     </div>
                     <div class="date">2017-09-28</div>
                                          <!---->
                  </a>
               </li>
                                 </ul>
      </div>
   </div>

<script>
jQuery(function($){
   $('#tab__57631_ .tab-btn a').on('mouseenter click',function(){
      var href= $(this).attr('href')
      if ($(this).parents('li').hasClass('on') == false) {
         $(href).addClass('on').siblings('.tab-cont').removeClass('on');
         $(this).parents('li').addClass('on').siblings('li').removeClass('on');
         return false;
      }
      return false;
   });
});
</script>
</div>
   </div>
</div>
</div><!-- ---------------    공백 : 57299 --------------- -->
<div  ><!-- 공백 -->



<span class="empty_line_57299_"></span>
</div><!-- ---------------  layout : 1칸 레이아웃 : 183819 --------------- -->



<div class="layout_183819_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 최근 게시글 탭 - 웹진 + 목록형 (반응형) : 58595  --------------- -->
</div>
   </div>
</div>
<!-- ---------------    아이콘 버튼 : 184656 --------------- -->
<div   style='background-Color:#f3f3f3;'  >
<!-- ---------------  layout : 1칸 레이아웃 : 57330 --------------- -->



<div class="layout_57330_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 하단 메뉴 : 57331  --------------- -->
<div   style='margin-top:5px;margin-bottom:3px;text-align:center;'  ><!-- 하단 메뉴 -->




<nav class="fnb_57331_">
   <ul>
               <li><a href="../shop_info/privacy.htm">개인정보취급방침</a></li>
               <li><a href="../shop_info/agree.htm">이용약관</a></li>
               <li><a href="./sub1_3.jsp" target="_self">한끼맛있다 소개</a></li>
               <li><a href="./sub2_6.jsp" target="_self">개설절차</a></li>
               <li><a href="../myboard/cp368638.jsp" target="_self">매장찾기</a></li>
               <li><a href="./sub1_4.jsp" target="_self">오시는길</a></li>
               <li><a href="./sub2_1.jsp" target="_self">MENU</a></li>
         </ul>
   </nav>
</div></div>
   </div>
</div>
</div><div   style='background-Color:#5f5a58;' >
<!-- ---------------  layout : 1칸 레이아웃 : 58204 --------------- -->



<div class="layout_58204_">
   <div>
      <div class="container_1">
<!-- ---------------   layout in : 하단 정보 : 58205  --------------- -->
<div   style='margin-top:20px;margin-bottom:20px;text-align:center;'  ><!-- 하단 정보 -->



<div class="footer_info_58205_">
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
</div><!-- ---------------    상단으로 바로가기 버튼 : 57334 --------------- -->
<div   style='text-align:right;'  ><!-- 상단으로 바로가기 -->




<script>
$(window).on('scroll', function(){
   if ($(this).scrollTop() > 300){
      $('.scroll_top_57334_').addClass('on');
   }else{
      $('.scroll_top_57334_').removeClass('on');
   }
});

jQuery(function($){
   $('.scroll_top_57334_').click(function() {
      $('body,html').animate({
         scrollTop: 0
      }, 800);
      return false;
   });
})

</script>

<div class="scroll_top_57334_">
   <span>상단으로 바로가기</span>
</div>
</div><script type="text/javascript" src="../js/all_bottom_script.js"></script>
<script type="text/javascript">
all_page_script('','','','','','','','','0');
</script>
                  
                  
      <script type="text/javascript">
      setTimeout("create_iframe(0,'ok_frame');",100);
      setTimeout("create_iframe(0,'ok_frame2');",100);
      </script>
      </body></html>