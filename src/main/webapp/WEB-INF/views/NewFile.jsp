<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
   Theory by TEMPLATED
   templated.co @templatedco
   Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<script src="js/jquery.min.js"></script>
<script src="js/sweetalert2.all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
<head>
<title>Hello Code</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/sweetalert2.min.css"/>


<script type="text/javascript"> 


$(document).ready(function(){
   if("<%=request.getSession().getAttribute("HCID")%>"!="null"){
      location.href="error"
   }
}) 

var isRun = false;
function joinsubmit(){ 
   if($('#idch').val()=='N'){
      $('#HCID').focus();
      swal({
         type : 'warning',
         title : '아이디를 확인해 주세요!',
         timer : 1500
      })         
   }else if($('#passch').val()=='N'){
      $('#HCpassword').focus();
      swal({
         type : 'warning',
         title : '패스워드를 확인해 주세요!',
         timer : 1500
      })      
   }else if($('#emailch').val()=='N'){
      $('#email').focus();
      swal({
         type : 'warning',
         title : '이메일을 확인해 주세요!',
         timer : 1500
      })} else if($('#keych').val()=='N'){
         $('#email').focus();
         swal({
            type : 'warning',
            title : '이메일인증을 해주세요!',
            timer : 1500
         })} 
   else{
   var j = document.join;
   j.action="/account";
   j.method="post";
   j.encoding="multipart/form-data"
   j.submit();
   }
}

function checkID(pass){
   console.log($('#HCID').val());
   var str_space = /\s/;
    if(str_space.exec(pass.value)){
       console.log("??")
         pass.value = pass.value.replace(/(\s*)/g,'');
         pass.focus();
         $('#checks').empty();
         $('#checks').append("공백은 사용할 수 없습니다!");
         $('#idch').val('N');
      }
    else{
   
    $.ajax({
      url : "/checkID",
      data : {
         id : $('#HCID').val()
      },
      success : function(responseData){
         console.log(responseData);
         if(responseData == -11){
            console.log("-11쪽")
            $('#checks').empty();
            $('#checks').append("ID는 영문,숫자를 사용해 6~15자 사이로 만들어 주세요.");
            $('#idch').val('N');
         }
         else if(responseData == -1){
            console.log("성공!")
            $('#checks').empty();
            $('#checks').append("숫자만 사용은 불가능합니다!");
            $('#idch').val('N');
         }
         else if(responseData == -2){
            $('#checks').empty();
            $('#checks').append("한글은 사용하실 수 없습니다!");
            $('#idch').val('N');
         }
         else if(responseData == -3){
            $('#checks').empty();
            $('#checks').append("특수문자는 사용하실 수 없습니다!");
            $('#idch').val('N');
         }else if(responseData == -4){
            $('#checks').empty();
            $('#checks').append("아이디는 6~15자 사이로 만들어 주세요!");
            $('#idch').val('N');
         }
         else if(responseData == -5){
            $('#checks').empty();
            $('#checks').append("숫자로 시작되는 아이디는 사용하실 수 없습니다!");
            $('#idch').val('N');
         }else if(responseData == -6){
            $('#checks').empty();
            $('#checks').append("사용하실 수 없는 아이디입니다.");
            $('#idch').val('N');
         }else if(responseData == 0){
            $('#checks').empty();
            $('#checks').append("중복되는 아이디가 존재합니다.");
            $('#idch').val('N');
         }
         else if(responseData == 1){
            $('#checks').empty();
            $('#checks').append("사용가능한 아이디입니다.");
            $('#idch').val('Y');
         }
      }
   }); 
    }
} 


function checkNick(pass){
   console.log($('#NICKNAME').val());
   var str_space = /\s/;
    if(str_space.exec(pass.value)){
         pass.value = pass.value.replace(/(\s*)/g,'');
         pass.focus();
         $('#nickcheck').empty();
         $('#nickcheck').append("공백은 사용할 수 없습니다!");
         $('#idch').val('N');
      }
    else{
   
    $.ajax({
      url : "/checkNick",
      data : {
         nick : $('#NICKNAME').val()
      },
      success : function(responseData){
         console.log(responseData);
         if(responseData == -11){
            console.log("-11쪽")
            $('#nickcheck').empty();
            $('#nickcheck').append("부적절한 닉네임을 가진 아이디는 경고없이 삭제될 수 있습니다");
            $('#nickch').val('N');
         }
         else if(responseData == 0){
            $('#nickcheck').empty();
            $('#nickcheck').append("중복되는 닉네임 존재합니다.");
            $('#nickch').val('N');
         }
         else if(responseData == 1){
            $('#nickcheck').empty();
            $('#nickcheck').append("사용가능한 닉네임입니다.");
            $('#nickch').val('Y');
         }
      }
   }); 
    }
} 






function checkpass1(pass){ 
   var str_space = /\s/;
    if(str_space.exec(pass.value)){
       console.log("??")
         pass.value = pass.value.replace(/(\s*)/g,'');
         pass.focus();
         $('#passcheck').empty();
         $('#passcheck').append("공백은 사용할 수 없습니다!");
         $('#passch').val('N');
      }else{
   var p1 = $('#HCpassword'); 
   var p2 = $('#password2'); 
   if(p1.val() ==""||p2.val()==""){
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호는 대소문자를 구별합니다.");
      $('#passch').val('N');
   }
   else if(p1.val().length<8){
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호의 길이는 8~20자 사이로 만들어 주세요.");
      $('#passch').val('N');
   }else if(p1.val()!=p2.val()){
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호가 일치하지 않습니다.");
      $('#passch').val('N');
   }else if(p1.val()==p2.val()){
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호가 일치합니다.");
      $('#passch').val('Y');
   }
   else{
      $('#passcheck').empty();    
      $('#passch').val('N');
   }
}
}

function checkPass(pass) {  
   var str_space = /\s/;
    if(str_space.exec(pass.value)){
       console.log("??")
         pass.value = pass.value.replace(/(\s*)/g,'');
         pass.focus();
         $('#passcheck').empty();
         $('#passcheck').append("공백은 사용할 수 없습니다!");
         $('#passch').val('N');
      }else{
   var p1 = $('#HCpassword'); 
   var p2 = $('#password2'); 
   if(p1.val().length<8){
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호의 길이는 8~20자 사이로 만들어 주세요.");
      $('#passch').val('N');
   }
   else if(p1.val()==""){ 
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호를 입력해 주세요");
      $('#passch').val('N');
      $('#HCpassword').focus();  
   }else{ 
      if(p1.val()==p2.val()){
         var y = 'Y';
      $('#passcheck').empty(); 
      $('#passcheck').append("비밀번호가 일치합니다.");
      $('#passch').val('Y');
   }else if(p2.val()==""){
      $('#passcheck').empty();
      $('#passcheck').append("비밀번호는 대소문자를 구별합니다.");
      $('#passch').val('N');
   }else{
      $('#passcheck').empty();
      $('#passcheck').append("비밀번호가 일치하지 않습니다.");
      $('#passch').val('N');
   }
   }
      }
}

function checkemail(pass){
   if(isRun==true){
      clearInterval(tid);   
      $('#sessiontime').empty();
      $('#sessiontime').append("다시 인증을 해주세요.");
      $('#mailkey').val("");
      SetTime = 180;
      isRun = false;
   }
   var str_space = /\s/;
    if(str_space.exec(pass.value)){
         pass.value = pass.value.replace(/(\s*)/g,'');
         pass.focus();
         $('#emailcheck').empty();
         $('#emailcheck').append("공백은 사용할 수 없습니다!");
         $('#emailch').val('N');
      }else{
         var p1 = $('#email'); 
         $.ajax({
            url : "/checkEmail",
            data : {
               mail : $('#email').val()
            },
            success : function(responseData){
               console.log(responseData);
               if(responseData == -11){
                  console.log("-11쪽")
                  $('#emailcheck').empty();
                  $('#emailcheck').append("정확한 이메일을 입력하셔야 비밀번호를 찾을 수 있습니다.");
                  $('#emailch').val('N');
               }else if(responseData == -1){
                  $('#emailcheck').empty();
                  $('#emailcheck').append("이메일 형식에 맞지 않습니다.");
                  $('#emailch').val('N');
               }
               else if(responseData == 0){
                  $('#emailcheck').empty();
                  $('#emailcheck').append("중복되는 이메일이 존재합니다.");
                  $('#emailch').val('N');
               }
               else if(responseData == 1){
                  $('#emailcheck').empty();
                  $('#emailcheck').append("사용가능한 이메일입니다.");
                  $('#emailch').val('Y');
               }
            }
         }); 
         
         
      }
}
var isRun = false;
var SetTime = 180;      // 최초 설정 시간(기본 : 초)

function msg_time() {   // 1초씩 카운트
   $('#sessiontime').empty();
   m = Math.floor(SetTime / 60) + "분 " + (SetTime % 60) + "초";   // 남은 시간 계산
   var msg = "현재 남은 시간은 <font color='red'>" + m + "</font> 입니다.";
   
   //document.all.ViewTimer.innerHTML = msg;      // div 영역에 보여줌 
   $('#sessiontime').append(msg);
   SetTime--;               // 1초씩 감소

   if (SetTime < 0) {         // 시간이 종료 되었으면..
      
      clearInterval(tid);      // 타이머 aaa해제;
      SetTime= 180;   

      $('#sessiontime').empty();
      $('#sessiontime').append("인증시간 초과");
      $('#mailkey').val("");
      isRun = false;
   }
   
}



function emailcheck(){
   console.log(isRun);
   var email = $('#email').val();
   console.log(email);
   $('#mails').val(email);
   console.log($('#mails').val());
   if($('#emailch').val()=="N"){
      swal({
         type : 'warning',
         title : '이메일을 확인해 주세요!',
         timer : 1500
      })
      } else{
         console.log(isRun);
         if($('#mailkey').val()!=""||isRun==true){
            swal({
               type : 'warning',
               title : '아직 인증키를 발송할 수 없습니다!'
            }) 
            return;
         }else{
            isRun=true;
            console.log("엘스들어온후"+isRun);
    $.ajax({ 
         url : "/emailsub",
         data : {
            email : $('#mails').val()
         },
         beforeSend : function(){
            $("#sessiontime").empty();
            $("#sessiontime")
                  .append("<p><img src='images/load.gif' border=0></p>")
         },
         success : function(responseData){
            $('#mailkey').val(responseData);
            console.log(isRun);
            console.log(responseData);
            $('#sessiontime').empty();
            tid=setInterval('msg_time()',1000);
            console.log($('#mailkey').val());
            var key = responseData;
            $('#mailkey').val(key);
            console.log($('#mailkey').val());
            
         }
      }); 
         }
   }
}

function emailcheck2(){
   //var mailkey = $('#keycheck').val();
   //console.log(mailkey);
   //$('#mailkey').val(mailkey);
   //console.log($('#mailkey').val());
   if($('#emailch').val()=="N"){
      swal({
         type : 'warning',
         title : '이메일을 확인해 주세요!',
         timer : 1500
      })
      } else if(isRun==false){
         swal({
            type : 'warning',
            title : '인증키부터 발송해 주세요!',
            timer : 1500
         })
      }
   else{
    $.ajax({ 
         url : "/emailchecksub",
         data : {
            mailkey : $('#mailkey').val(),
            keycheck : $('#keycheck').val()
         },
         success : function(responseData){
            console.log(responseData);
            if(isRun==false){
               swal({
                  type : 'warning',
                  title : '인증키부터 발송해 주세요!',
                  timer : 1500
               })
            }
            if(responseData == 1){
               $('#keych').val('Y');
               clearInterval(tid);   
               $('#sessiontime').empty();
               $('#sessiontime').append("<font color='blue'>인증이 완료되었습니다.</font>");
               $('#email').attr("readonly",true);
               $('#keycheck').attr("readonly",true);
               console.log($('#keych').val());
               swal({
                  type : 'success',
                  title : '인증이 완료되었습니다.!',
                  timer : 1500
               })
            }else{
               swal({
                  type : 'warning',
                  title : '인증키를 확인해 주세요!',
                  timer : 1500
               })
            }
         }
      }); 
   }
}


function upimages(input){
   $('#imgsize').empty();
   var thumbext = $('#file').val();
   thumbext = thumbext.slice(thumbext.indexOf(".") + 1).toLowerCase(); //파일 확장자를 잘라내고, 비교를 위해 소문자로 만듭니다.

   if(thumbext != "jpg" && thumbext != "png" &&  thumbext != "gif"){ //확장자를 확인합니다.
      $('#file').val("");
      $('#ShowImage').attr('style',"display:none");
      $('#imggg').append("이미지를 올려보세요");
      $('#imgsize').append("0Kb / 5242880Kb");
      swal({
         type : 'error',
         title : '이미지는 jpg, png, gif만 사용가능합니다!',
         timer : 1500
      })         

      return;

   }

   
   var nMaxSize = 5 * 1024 * 1024; // 5 MB

    var nFileSize = input.files[0].size;

   var nSize = nFileSize/1024
   
   
   
   if(nMaxSize<nFileSize){
      
      $('#file').val("");
      swal({
         type : 'error',
         title : '파일의 크기가 너무 큽니다!',
         text : nSize.toFixed(2)+'Kb',
         timer : 1500
      })         
      $('#ShowImage').attr('style',"display:none");
      $('#imggg').append("이미지를 올려보세요");
      $('#imgsize').append("0Kb / 5242880Kb");
      
      return;
   }  
      
   if (input.files && input.files[0]) { 
        var reader = new FileReader();
        $('#imgsize').append(nSize.toFixed(2)+"Kb"+ "/ 5242880Kb");
        $('#imggg').empty();
        $('#ShowImage').attr('style',"display:block");
        reader.onload = function (e) {
            $('#ShowImage')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

</script>
</head>
<body>

   <!-- Header -->
   <header id="header">
   <div class="inner">
      <a href="/" class="logo">Hello Code<!-- <img src="images/logo1.png" class="img"/> --></a>
         <nav id="nav">
               <% if (session.getAttribute("HCID") == null) {   // %>
                  <a href="/real_login">login</a>
                  <a href="/real_noticeBoard?page=1">notice</a>
                  <a href="/real_freeBoard?page=1">freeBoard</a>
                  <a href="/real_questionBoard?page=1">questionBoard</a>
                  <a href="/real_hotBoard?page=1&qpage=1">now hot</a>
                  <% } else if (session.getAttribute("HCID").equals("admin")) {%>
                  <a href="/allInfo">allinfo</a>
                  <a href="/real_noticeBoard?page=1">notice</a>
                  <a href="/real_freeBoard?page=1">freeBoard</a>
                  <a href="/real_questionBoard?page=1">questionBoard</a>
                  <a href="/real_hotBoard?page=1&qpage=1">now hot</a>
                  <a href="/logout">logout</a>
                  <% } else {%>
                  <a href="/myInfo">myinfo</a>
                  <a href="/codePractice">CodePractice</a>
                  <a href="/real_noticeBoard?page=1">notice</a>
                  <a href="/real_freeBoard?page=1">freeBoard</a>
                  <a href="/real_questionBoard?page=1">questionBoard</a>
                  <a href="/real_hotBoard?page=1&qpage=1">now hot</a>
                  <a href="/logout">logout</a>
                  <% }   %>
               </nav>
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
   <h2>SIGN UP</h2>
   <p>WELCOME !</p>
   </header>

   <form name="join">
      <div class="inner2">
         <div class="row uniform">
            <div class="6u 12u$(xsmall)">
               <h3>ID</h3>
               <input type="text" name="HCID" id="HCID" oninput="checkID(this);" placeholder="join id" maxlength="15" autocomplete="false" spellcheck="false"/> <br>
               <h4 id="checks">ID는 영문,숫자를 사용해 7~15자 사이로 만들어 주세요.</h4>
               <div class="12u$"></div>
            </div>

            <div class="6u$ 12u$(xsmall)">
               <h3>PASSWORD</h3>
               <input type="password" name="HCpassword" id="HCpassword"
                  placeholder="Password" maxlength="20" onfocusout="checkpass1(this)" /> <br> <input type="password"
                  name="password2" id="password2" oninput="checkPass(this);"
                  placeholder="Password Check" maxlength="20" />
            </div>
            <div class="6u 12u$(xsmall)">
               <h3>NICKNAME</h3>
               <input type="text" name="NICKNAME" id="NICKNAME" oninput="checkNick(this);"
                  placeholder="your nickname" maxlength="12" spellcheck="false" autocomplete="false"/> <br>
               <h4 id="nickcheck">부적절한 닉네임을 가진 아이디는 경고없이 삭제될 수 있습니다.</h4>
            </div>
            <div class="6u 12u$(xsmall)">
               <h3 id="passcheck">비밀번호의 길이는 8~20자 사이로 만들어 주세요.</h3>

            <br>
            </div>
            <div class="6u 12u$(xsmall)">
               <h3>E-MAIL</h3>
            </div>
            <div class="9u 12u$(small)">
               <input type="text" name="email" id="email"
                  placeholder="Enter your Email" onchange="checkemail(this)" autocomplete="false" spellcheck="false"/>
                  <h3 id="emailcheck">정확한 이메일을 입력하셔야 비밀번호를 찾을 수 있습니다.</h3>
            </div>
             <div class="3u$ 12u$(small)">
               <input type="button" onclick="javascript:emailcheck();" value="인증키 발송" class="fit" />
               <h3 id="sessiontime"></h3>
            </div>
            <div class="9u 12u$(small)">
               <input type="text" name="keycheck" id="keycheck"
                  placeholder="Email Check" />
            </div>
            <div class="3u$ 12u$(small)">
               <input type="button" onclick="javascript:emailcheck2();" value="confirm" class="fit" />
            </div> 
         </div>
         <br> <br>
         <input type="file" name="file" id = "file" onchange="javascript:upimages(this);"  accept="image/gif, image/jpeg, image/png">
         <div class="3u$ 12u$(small)">
         
         <img id="ShowImage"  style="display: none" src="#" >
         <p id="imggg">이미지를 올려보세요</p>
         <p id="imgsize">0Kb / 5242880Kb</p>
         </div>
          <br> <br>
         <h3>Introduce</h3>
         
            <textarea spellcheck="false" style="resize: none; height: 400px;" name="introduce" id="introduce" placeholder="Enter your message."
               rows="6"></textarea>
         
         <div class="12u$">
            <ul class="actions">
               <center>
               <br> <br> 
                  <br> <br> <br>
                  <li><a href="javascript:void(0);" onclick="javascript:joinsubmit();" class="button special">SIGN UP</a></li>
                  <li><input type="reset" value="RESET" class="alt" /></li>
            </center>
            </ul>
         </div>
      </div>



<input type="hidden" id="idch" name="idch" value="N">
<input type="hidden" id="passch" name="passch" value="N">
<input type="hidden" id="nickch" name="nickch" value="N">
<input type="hidden" id="emailch" name="emailch" value="N"> <!-- 임시 -->
<input type="hidden" id="keych" name="keych" value="N"><!--임시  -->
   </form>
      <form id="emch">
               <input type="hidden" id="mails" value="">
<input type="hidden" id="mailkey" name="mailkey" value="">
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