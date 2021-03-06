<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="net.board.db.*" %>
<%
   BoardBean board = (BoardBean)request.getAttribute("boardbean");
   
%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(주)쉐프마인드</title>
<meta name="naver-site-verification" content="fdb874a536daa44431e562983af2c160a76457cf"/>
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=2.0, minimum-scale=0.5, width=device-width">
<meta name="subject" content="(주)쉐프마인드" />
<meta name="copyright" content="(주)쉐프마인드" />
<meta name="title" content="(주)쉐프마인드" />
<meta name="description" content="패밀리 퓨전레스토랑 프랜차이즈, 브랜드스토리, 메뉴소개 및 매장안내, 매장창업" />
<link rel="canonical" href="../hanki/bbs_shop/write_form.htm?me_popup=0&auto_frame=&cate_sub_idx=0&list_mode=board&mode=write&board_code=g1" />
<meta property="og:title"           content="(주)쉐프마인드"/>
<meta property="og:site_name"       content="(주)쉐프마인드"/>
<meta property="og:type"            content="website"/>
<meta property="og:url"             content="../bbs_shop/write_form.htm?me_popup=0&auto_frame=&cate_sub_idx=0&list_mode=board&mode=write&board_code=g1"/>
<meta property="og:image"           content="../thum_img/ehompy0118/og_img/og_logo1519610629.jpg"/>
<meta property="og:description"     content="패밀리 퓨전레스토랑 프랜차이즈, 브랜드스토리, 메뉴소개 및 매장안내, 매장창업"/>
<meta name="twitter:card"           content="summary">
<meta name="twitter:title"          content="(주)쉐프마인드">
<meta name="twitter:site"           content="(주)쉐프마인드">
<meta name="twitter:image"          content="../thum_img/ehompy0118/og_img/og_logo1519610629.jpg">
<meta name="twitter:description"    content="패밀리 퓨전레스토랑 프랜차이즈, 브랜드스토리, 메뉴소개 및 매장안내, 매장창업">
<link rel="shortcut icon" href="./img/favicon_null.png" />
<script type="text/javascript" src="./img_up/_addon/jquery/1.11.3/jquery.min.js"></script>


<link rel="stylesheet" href="./css/head_basic.css" type="text/css" media="all" />
<link rel="stylesheet" href="./css/head_logout.css" type="text/css" media="all" />
<script type="text/javascript">var MOBILE_CONN_YN = false;</script>
<script type="text/javascript" src="./js/all_default.js"></script>
<script type="text/javascript">
var ios_yn = false;
var APP_CONN_YN = false;
var isKitkat = window.navigator.userAgent.search( "AnybuildApp Android 4.4") > -1 ? true : false;
</script>
<script type="text/javascript" src="./img_up/shop_pds/ehompy0118/etc/navi_category_all.js"></script>
<script type="text/javascript" src="./img_up/shop_pds/ehompy0118/etc/goods_category_all.js"></script>
<script type="text/javascript" src="./img_up/shop_pds/ehompy0118/etc/board_list.js"></script>
<script type="text/javascript" src="./img_up/shop_pds/ehompy0118/etc/site_category_all.js"></script>
<script type="text/javascript" src="./img_up/shop_pds/ehompy0118/etc/gisa_category_all.js"></script>
<script type="text/javascript" src="./img_up/shop_pds/ehompy0118/etc/movie_category_all.js"></script>
<script type="text/javascript" src="./js/all_default2.js"></script>
<script type="text/javascript" src="./js/google_map.js"></script>
<script type="text/javascript" src="./js/load_frame.js"></script>
<script type="text/javascript" src="./js/head_logout.js"></script>
<script type="text/javascript" id='naver_map_js' ></script>
<script type="text/javascript" id='dynamic_js' ></script>

<script type="text/javascript" src="./img_up/_addon/jquery/1.11.3/jquery.min.js"></script>
<!---->

<link rel="stylesheet" type="text/css" href="./img_up/_addon/css/reset_1.0.css">

<link rel="stylesheet" type="text/css" href="./img_up/shop_pds/ehompy0118/src_css_fram/pc.board.g1.css" />
<link rel="stylesheet" type="text/css" href="./img_up/shop_pds/ehompy0118/src_css_fram/pc.skin.sub.css" />
<script type="text/javascript" src="./img_up/_addon/_plugin/modernizr/modernizr.custom.media.query.js"></script>

<link rel="stylesheet" type="text/css" href="./img_up/tmp_img/service/board_tpl/8/pc/css/default_mobile.css" media="all">
<link rel="stylesheet" type="text/css" href="./img_up/tmp_img/service/board_tpl/8/pc/css/default_tablet.css" media="only all and (min-width:768px)">
<link rel="stylesheet" type="text/css" href="./img_up/tmp_img/service/board_tpl/8/pc/css/co-basic.css" media="screen">
<!--[if lt IE 9]><link rel="stylesheet" type="text/css" href="/img_up/tmp_img/service/board_tpl/8/pc/css/default_tablet.css" media="all"><![endif]-->
<!--[if IE]><link rel="stylesheet" type="text/css" href="/img_up/tmp_img/service/board_tpl/8/pc/css/ie.css" media="all"><![endif]-->
<!--[if lt IE 8]><link rel="stylesheet" type="text/css" href="/img_up/tmp_img/service/board_tpl/8/pc/css/ie7.css" media="all"><![endif]-->
      
                     </head>

      <body >
<div  >
<!-- ---------------  layout : 2칸 레이아웃 : 183741 --------------- -->


<div class="layout_183741_ grid_13">
   <div class="container_1">
<!-- ---------------   layout in : 로고 A : 183743  --------------- -->
<div   style='text-align:center;'  ><!-- 로고 A -->



<div class="logo_183743_">
   <h1><a href="../main.bo" target="_self"><img src="./img_up/shop_pds/ehompy0118/farm/logo15196106291.jpg" alt="로고"></a></h1>
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
         <a href="../page/sub1_3.jsp" target="_self">About</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="../page/sub1_3.jsp" target="_self">한끼맛있다 소개</a>
               </li>
                                             <li>
                  <a href="../page/sub1_4.jsp" target="_self">오시는길</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="../page/sub2_1.jsp" target="_self">MENU</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="../page/sub2_10.jsp" target="_self">Diener Set Menu</a>
               </li>
                                             <li>
                  <a href="../page/sub2_2.jsp" target="_self">Lunch Set Menu</a>
               </li>
                                             <li>
                  <a href="../page/sub2_1.jsp" target="_self">Main Menu</a>
               </li>
                                             <li>
                  <a href="../page/sub2_4.jsp" target="_self">Rice Menu</a>
               </li>
                                             <li>
                  <a href="../page/sub2_3.jsp" target="_self">Pasta Menu</a>
               </li>
                                             <li>
                  <a href="../page/sub2_5.jsp" target="_self">Pizza Menu</a>
               </li>
                                             <li>
                  <a href="../page/out.jsp" target="_self">Salad/Drink Menu</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="../page/sub2_6.jsp" target="_self">Franchise</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="../page/sub2_6.jsp" target="_self">개설절차</a>
               </li>
                                             <li>
                  <a href="../page/sub2_7.jsp" target="_self">개설비용</a>
               </li>
                                             <li>
                  <a href="../page/sub22.jsp" target="_self">개설수익률</a>
               </li>
                                             <li>
                  <a href="../myreg/qna.jsp" target="_self">1:1고객상담</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class=" has_sub">
         <a href="../page/sub1_7.jsp" target="_self">Store</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="../myboard/cp368638.jsp" target="_self">매장찾기</a>
               </li>
                                             <li>
                  <a href="../page/sub4_1.jsp" target="_self">매장둘러보기</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
                  <li class="on has_sub">
         <a href="../bbs/hh1.jsp" target="_self">News/Notice</a>
         <div>
            <!-- 2 Depth -->
            <ul class="dep2">
                                             <li>
                  <a href="../bbs/hh1.jsp" target="_self">News</a>
               </li>
                                             <li>
                  <a href="../bbs/news.jsp" target="_self">공지사항</a>
               </li>
                        <li class=" on">
                  <a href="./BoardList.yu" target="_self">자유게시판</a>
               </li>
                           </ul>
            <!-- // 2 Depth -->
         </div>      </li>
         
                  <li class="last has_sub">
         <a href="../page/sub3_1.yu" target="_self">Reservation</a>
               <div>         
               <ul class="dep2">                     
                     <li>
                  <a href="../page/sub3_1.yu" target="_self">예약하기</a>
               </li>
                     <li>
                  <a href="../page/sub3_2.yu" target="_self">예약확인</a>
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
   <h1>Free Board</h1>
   <!-- 1 Depth -->
   <ul class="dep1">
               <li class="on">
            <a href="../bbs/g1.jsp" target="_self">자유게시판</a>
                     </li>         </ul>
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
         <img src="./thum_img/ehompy0118/farm/2ebfa724534437351a10717dcb6edacb_water__c1_w550_h188.jpg" alt="디너세트">
   </div>
</div></div>
   </div>
</div>

<!-- ---------------    board content : 57600 --------------- -->
<div   style='margin-top:20px;'  >


<div id="scbd" class="scbd co-basic">
   <!-- category and board list -->

   
   
   <!-- // category and board list -->
<script language="javascript">

</script>
   <div id="lay_hd" class="lay_hd">
      <div class="hgroup">
         <h1><a href="">자유게시판</a></h1>
         <ul>
            <li>
               <a href="#" id="btnToggleSearch">검색<i class="ui-ico search"></i></a>
            </li>
         </ul>
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

   <form name="frmWrite" action ="./BoardAddAction.bo"  enctype="multipart/form-data"  method="post" style='margin:0'>
         <div class="write">
         <fieldset>
            <legend class="blind">게시글 쓰기</legend>
            <dl>
               <dt><label>게시판</label></dt>
               <dd><span class="ui-input ipt-dis"><input type="text" readonly="readonly" value="자유게시판"></span></dd>
            </dl>
            <dl>
               <dt><label for="fbd_nick">닉네임</label></dt>
               <dd><span class="ui-input"><input type="text" name="BOARD_NAME" value="<%=board.getBOARD_NAME() %>" size="15"></span></dd>
            </dl>
            <dl>
               <dt><label for="passwd">패스워드</label></dt>
               <dd><span class="ui-input"><input type="password" name="BOARD_PASS" id="passwd" maxlength="12" size="10"></span>
                  <span class="msg">* 게시판 수정,삭제시 필요합니다.</span></dd>
            </dl>
               <input type="hidden" name="cate_sub_idx" value="0">
            
            <dl>
               <dt><label for="subject">제목</label></dt>
               <dd><span class="ui-input ipt-block"><input type="text" name="BOARD_SUBJECT" value="<%=board.getBOARD_SUBJECT() %>"></span></dd>
            </dl>
            <dl>
               <dt><label for="content">내용</label></dt>
               <dd>
                  <div>
                     <input name="BOARD_FILE" type="file" class="ui-btn btn-sml">파일첨부</div>
                  <span class="editor">
                  
                  
                  <script type='text/javascript' src='./html_editor/ckeditor_4.3.3_full/ckeditor.js'></script>
             <textarea name='BOARD_CONTENT' value="<%=board.getBOARD_CONTENT() %>" id='BOARD_CONTENT' STYLE='width:100%;height:490px' title='본문내용' ></TEXTAREA>
            <input type='hidden' name='content_editor_mode' id='content_editor_mode' value='ckeditor'>
            <script type="text/javascript">
            //<![CDATA[
            CKEDITOR.replace( 'content',
                        {
                           
                  toolbar :
                        [

                           [ 'Cut','Copy','Paste','-','Undo','Redo' ],
                           ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock' ],
                           [ 'Link','Unlink','Anchor' ],
                           // [ 'Image','Flash','Table','HorizontalRule' ],
                           [ 'Image','Table','HorizontalRule' ],
                           ['FontSize' ,'Bold','Italic','Underline','Strike'  ],
                           [ 'TextColor','BGColor' ]

                        ],
                  
                           
                           language: 'ko',
                           font_names : '맑은 고딕; 돋움; 굴림; 궁서; 바탕;' +  'Arial; Courier New; Tahoma; Verdana;',
                           allowedContent : true,
                           autoParagraph : false,
                           enterMode :CKEDITOR.ENTER_P, 
                           height:340,
                           // filebrowserImageUploadUrl:'/html_editor/ckeditor_3.6.2/upload.php?type=Images&file_path=ZufCn8exG8Ppsoc9%2FIXYI2UdqL95j%2Bfo8YiCwjQeb4k%3D&img_water_type='
                        }
                        );
            CKEDITOR.config.protectedSource.push( /<script[\s\S]*?\/script>/g );


            CKEDITOR.on('instanceReady', function(e){
               var url = 'editor_img_pop("content","../bbs/ehompy0118/add_img/","")';
               $('#cke_content a.cke_button__image')
                  .attr('onclick', url)
                  .attr('onkeydown', '')
                  .attr('onfocus', '')
                  .attr('onmousedown', '')
                  .attr('onmouseup', '')
               ;
            });

            //]]>
            </script>
            </span>         
               </dd>
            </dl>
         </fieldset>
         <div class="btngroup">
            <input type="button" onclick="javascript:submitForm()" value="글쓰기" class="ui-btn btn-co1">
            <!-- <button type="button" onclick="javascript:submitForm()" class="ui-btn btn-co1">글쓰기</button> -->
            <button type="button" onclick="history.back()" class="ui-btn">취소</button>         </div>
         </div>
   </form></div>
</div></div></div>
   </div>
</div>

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
               <li><a href="../page/sub1_3.jsp" target="_self">한끼맛있다 소개</a></li>
               <li><a href="../page/sub2_6.jsp" target="_self">개설절차</a></li>
               <li><a href="../myboard/cp368638.jsp" target="_self">매장찾기</a></li>
               <li><a href="../page/sub1_4.jsp" target="_self">오시는길</a></li>
               <li><a href="../page/sub2_1.jsp" target="_self">MENU</a></li>
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
<script type="text/javascript" src="./js/all_bottom_script.js"></script>
<script type="text/javascript">
all_page_script('','','','','','','','','0');
</script>

<script type="text/javascript" src='./bbs_shop/js/board.js'></script>
<script type="text/javascript" src='./bbs_shop/js/sub_menu.js'></script>
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
   window.open('/bbs_shop/scrap_twitter.php?board_code=g1&idx='+idx);
}

function scrap_me2day_pop(idx){
   window.open('/bbs_shop/scrap_me2day.php?board_code=g1&idx='+idx);
}

function scrap_facebook_pop(idx){
   window.open('/bbs_shop/scrap_facebook.php?board_code=g1&idx='+idx);
}

function link_board_code_ch(tar){
   location.href='/bbs_shop/list.htm?me_popup=0&auto_frame=&board_code='+tar.value
}

function link_cate_sub_ch(tar){
   location.href='/bbs_shop/list.htm?me_popup=0&auto_frame=&cate_sub_idx='+tar.value+'&list_mode=board&board_code=g1';
}


function scrap_mypage_pop(idx){
   
      alert('스크랩은 로그인 후 이용가능합니다.');
      
}
</script>
<script language="javascript" src="./bbs_shop/js/validate.js"></script>


<script type="text/javascript">
function popview(url) {
   open_window("../ssk_inc/viewimage.htm?img=" + url, "imageview",100,100,"scrollbars=yes");
}
function goList(){
   location.href="/bbs_shop/list.htm?me_popup=0&auto_frame=&cate_sub_idx=0&list_mode=board&board_code=g1&keyfield=&key=&page=";
}


function open_wnd(url, name, width, height){
         var oWnd = window.open(url, name, "toolbar=0,menubar=0,resizable=no,scrollbars=no,width=" + width + ",height=" + height+",left=190,top=50");
      oWnd.focus();
      return oWnd;
   }

 function submitForm(){
    var frm = document.frmWrite;

   if (!checkNull(frm.BOARD_NAME, "작성자 이름을 입력하세요.", true)) return;

         var filter_name = '관리자,운영자,홈지기,도우미';
      var filter_name_arr = new Array();
      filter_name_arr = filter_name.split(",");
      for(var i=0;i<filter_name_arr.length;i++){
         tmp = filter_name_arr[i];
         if(tmp == '')  continue;
         if(frm.BOARD_NAME.value.indexOf(tmp)!=-1){
            alert("사용할수 없는 작성자 이름입니다.\n\n다름 이름을 입력해주세요.");
            return;
         }
      }
            if (!checkNull(frm.BOARD_PASS, "암호를 입력하세요.", true)) return;
   

 /*   if(!frm.board_code.value){
      alert("게시판을 선택하세요");
      return;
   } */

   
    // subject
    if (!checkNull(frm.BOARD_SUBJECT, "제목을 입력하세요", true)) return;


       // content

  /*  if(document.getElementById('content_editor_mode')){
      if(document.getElementById('content_editor_mode').value == 'ckeditor'){
         var oEditor = CKEDITOR.instances.content;
         frm.ok_content.value = oEditor.getData();
      }else{
         frm.ok_content.value = frm.content.value;
      }
   }else{
      frm.ok_content.value = frm.content.value;
   } */

   if (!checkNull(frm.BOARD_CONTENT, "내용을 입력하세요", false)){
      if(document.getElementById('content_editor_mode') && document.getElementById('content_editor_mode').value == 'ckeditor'){
         CKEDITOR.instances.content.focus();
      }else{
         frm.content.focus();
      }
      return;
   }


   
   if(document.getElementById('attachfilelist')){
      var i;
      frm.file_list.value='';
      for(i=0;i<frm.attachfilelist.length;i++){
         if(frm.attachfilelist[i].value){
            frm.file_list.value += frm.attachfilelist[i].value +"&&";
         }
      }
   }

   
  /*  var default_action = 'test';
   frm.action = default_action;
   frm.target=create_iframe(); */

   frm.submit();
}

function no_write(){
   alert("선택하신 게시판에 글을 등록할수 없습니다.\n\n선택하신 게시판이 공지게시판 또는 회원전용 게시판인지 확인해주시기 바랍니다.");
}

function resizeImage(num,stop){
   // 에디터에서 작동 안되므로 pass 처리
}

</script>
<script type="text/javascript" src="./img_up/tmp_img/service/board_tpl/8/pc/js/default.js"></script>

      <script type="text/javascript">
      setTimeout("create_iframe(0,'ok_frame');",100);
      setTimeout("create_iframe(0,'ok_frame2');",100);
      </script>
      </body></html>