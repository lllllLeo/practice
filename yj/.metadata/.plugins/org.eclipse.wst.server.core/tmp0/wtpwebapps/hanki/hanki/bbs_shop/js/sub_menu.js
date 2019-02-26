// Browse Type
// IE Script
var NS4;
var IE4;
NS4 = (document.layers);
IE4 = (document.all);
isWin = (navigator.appVersion.indexOf("Win") != -1)

if (NS4) {
	document.captureEvents(Event.CLICK)
	document.onclick = MouseDown;
} else if (IE4) {
	document.onclick = MouseDown;
}


// ==Name UI Handling ==
var n_id = "";
var n_tid = "";
var open_type = "";

function ui(lv_tid) {
    n_tid = lv_tid;
}

function exec_menuitem(key) {
    switch(key) {
        case "EVENT1" :			
            my_gallery(n_tid);
            break;
        case "EVENT2" :
            sendmemo(n_tid);
            break;
        case "EVENT3" :
            sendsms(n_tid);
            break; 
		case "EVENT4" :
            sendemail(n_tid);
            break;
		case "EVENT5" :
            sendfriend(n_tid);
            break;
    }

}

function my_gallery(id){
	if(my_board_frame != null){
		my_board_frame.location.href="../inc/my_board_chk.php?id="+id;		
	}
}

function sendmemo(susin_id){
	if(MOBILE_CONN_YN == true){
		x_popup('/shop_mypage/s_paper_form.htm?susin_id='+susin_id);
	}else{
		var w = 400;
		var h = 400;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		var asendmemo_win = window.open('/shop_mypage/s_paper_form.htm?susin_id='+susin_id,'asendmemo_win','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		asendmemo_win.focus();
	}
}

function sendsms(s_id){
	if(MOBILE_CONN_YN == true){
		window.open('/bbs_shop/popup/sms_form.htm?s_id='+s_id);
	}else{
		var sms_win = window.open('/bbs_shop/popup/sms_form.htm?s_id='+s_id,'sms_win','top=0,left=0,width=370,height=340,scrollbars=no');
		sms_win.focus();
	}
}
function sendemail(s_id){
	if(MOBILE_CONN_YN == true){
		window.open('/bbs_shop/popup/email_form.htm?s_id='+s_id);
	}else{
		var mail_win = window.open('/bbs_shop/popup/email_form.htm?s_id='+s_id,'mail_win','top=0,left=0,width=640,height=520,scrollbars=no');
		mail_win.focus();
	}
}
function sendfriend(s_id){
	top.frames[1].friend_frame.location.href="../sub5/friend_ok.php?friend_id="+s_id;
}

var mouse_top;
var mouse_left;
var scroll_top;
var scroll_left;
var event_id = "none";
var status_over = false;    
var parent_menu_name = "menu_parent";
var child_menu_array = ["menu_child1"];
var submenu_left_indent = 70;
var column_height = 18;
var submenu_top_indent = 0;
var mainmenu_top_indent = 0;

var menuover_bgcolor = "#ccff00";
var menuover_fgcolor = "#ffffff";
var default_menuover_bgcolor = "#ffffff";
var default_menuover_fgcolor = "#000000";


    
function menuOver(ar_obj, ar_id) {
	status_over = true;
	changeColor(ar_obj);
	hideChild(event_id);
	viewSubMenu(event, ar_obj, ar_id);
}
    
function SubmenuOver(ar_obj) {
	status_over = true;
	changeColor(ar_obj);
}
    
function MouseDown(e) {
	event_target = event.srcElement;
	event_target = event_target.toString();
	event_check = event_target.indexOf("javascript:ui(");
	if (!status_over) hideAll();
	if (!event_check) 
		viewMenu(event,  parent_menu_name);
	else {
		if (!status_over) hideAll();
		return;
	}
}    
    
function hideChild(ar_id) {

	if (event_id == "none") return;
	var menu_len = child_menu_array.length;
	for (i=0; i<menu_len; i++) eval(child_menu_array[i] + ".style.display = \"none\"");
}
    
function hideAll() {
	if(!document.getElementById(parent_menu_name)) return;
	eval(parent_menu_name + ".style.display = \"none\"");
	if (event_id == "none") return;
	var menu_len = child_menu_array.length;
	for (i=0; i<menu_len; i++) eval(child_menu_array[i] + ".style.display = \"none\"");
}

function viewMenu(e, ar_id) {

	if (ar_id == "none") return;
	menuLocBod = window.document.body;
	xPos = menuLocBod.scrollLeft + event.clientX;
	yPos = event.clientY + menuLocBod.scrollTop;
	screen_height = window.document.body.offsetHeight;
	screen_width = window.document.body.offsetWidth;
	mouse_top = e.y;
	mouse_left = e.x;
	eval("mainmenu_top_indent = " + parent_menu_name + ".children[0].children[0].children.length");
	mainmenu_top_indent = mainmenu_top_indent * column_height;
	if (screen_height > mouse_top + mainmenu_top_indent) 
		yPos = event.clientY + menuLocBod.scrollTop;
	else
		yPos = (event.clientY + menuLocBod.scrollTop) - mainmenu_top_indent;

	if (mouse_top - mainmenu_top_indent < 0) 
		yPos = event.clientY + menuLocBod.scrollTop;
		
	eval(ar_id + ".style.pixelTop =" + yPos);
	eval(ar_id + ".style.pixelLeft =" + xPos);
	eval(ar_id + ".style.display = \"\"");
}
    
function viewSubMenu(e, ar_obj, ar_id) {
	
	if (ar_id == "none") return;
	event_id = ar_id;
	parent_top = menu_parent.style.pixelTop;
	parent_left = menu_parent.style.pixelLeft;
	child_top = ar_obj.style.pixelTop;
	child_left = ar_obj.style.pixelLeft;
	screen_height = window.document.body.offsetHeight;
	screen_width = window.document.body.offsetWidth;
	mouse_top = e.y;
	mouse_left = e.x;
	menuLocBod = window.document.body;
	xPos = menuLocBod.scrollLeft + parent_left + submenu_left_indent;
	eval("submenu_top_indent = " + ar_id + ".children[0].children[0].children.length");
	submenu_top_indent = submenu_top_indent * column_height;
	if (screen_height > mouse_top + submenu_top_indent) 
		yPos = event.clientY + menuLocBod.scrollTop;
	else
		yPos = (event.clientY + menuLocBod.scrollTop) - submenu_top_indent;

	if (mouse_top - submenu_top_indent < 0) 
		yPos = event.clientY + menuLocBod.scrollTop;
		
	eval(ar_id + ".style.pixelTop =" + yPos);
	eval(ar_id + ".style.pixelLeft =" + xPos);
	eval(ar_id + ".style.display = \"\"");
}

function menuOut(ar_obj) {
	status_over = false;
	changeColor(ar_obj);
}
    
function changeColor(ar_obj) {
	if (ar_obj.style.background == menuover_bgcolor) {
		ar_obj.style.background = default_menuover_bgcolor;
	} else {
		ar_obj.style.background = menuover_bgcolor;
	}
}
