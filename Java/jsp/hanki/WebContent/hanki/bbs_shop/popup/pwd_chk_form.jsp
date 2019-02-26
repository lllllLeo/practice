<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% int num = Integer.parseInt(request.getParameter("num"));
%>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
<title>popup</title>
<script type="text/javascript" src="./hanki/img_up/_addon/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="./hanki/js/all_default.js"></script>

<link rel="stylesheet" type="text/css" href="./hanki/bbs_shop/popup/css/style.css" />
<!-- <script type="text/javascript">
if(window.console == undefined)
{
    console = { log : function(){} };
}
function log(o)
{
   console.log(o);
}
</script> -->

</head>
<body>
<div id="tmp_id_win" style="display:none;">
<iframe src="" width=600 height=100 style='border:0' title='' name="ok_frame" id="ok_frame"></iframe>
</div>
<script type="text/javascript">
function edit_form_chk(){
   var form = document.edit_form;
   if(!form.passwd.value){
      alert("패스워드를 입력해 주세요.");
      form.passwd.focus();
      return false;
   }
}

// titleí  ê·¸ ì  ì  
/* jQuery(document).ready(function() {
   $('title').html($('#wrap .title').text());
            window.resizeTo(370,370);
   });
 */

</script>




<div>
<!-- <div class="wrap" id="wrap"> -->
   <div class="password_confirm container">
      <h1 class="title">패스워드 확인</h1>

      <form name="edit_form" method="post" action="./passchAction.bo?num=<%=num %>" onsubmit="return edit_form_chk()">
   
      <fieldset>
         <legend class="blind">Password confirm form</legend>
         <div class="txt">
            <strong>본 게시글은 패스워드가 설정되어 있습니다.</strong><br/>
            <strong class="red">비밀번호</strong>를 입력하세요.</div>

         <div class="formbox">
            <label for="ipt_password">패스워드</label>
            <input type="password" name="passwd" class="ipt_password" id="ipt_password"/>
         </div>

         <div class="btngroup">
            <input type="submit" value="확인" class="ibtn"/>
            <input type="button" value="닫기" class="ibtn" onclick="javascript:history.back();"/>
         </div>
      </fieldset>
      </form>
   </div>
</div>

</body>
</html>