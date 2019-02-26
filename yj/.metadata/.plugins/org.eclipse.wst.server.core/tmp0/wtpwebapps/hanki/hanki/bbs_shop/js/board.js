

function popview(url){
	if(MOBILE_CONN_YN == true){
		x_popup('/bbs_shop/inc/viewimage.htm?url='+url);
	}else{
		var view_win = window.open('/bbs_shop/inc/viewimage.htm?url='+url,'view_win','top=0,left=0,width=100,height=100,scrollbars=yes,resizable=yes');
		view_win.focus();
	}
}

function popview2(tar){
	if(MOBILE_CONN_YN == true){
		x_popup('/bbs_shop/inc/viewimage.htm?url='+tar.src);
	}else{
		var view_win = window.open('/bbs_shop/inc/viewimage.htm?url='+tar.src,'view_win','top=0,left=0,width=100,height=100,scrollbars=yes,resizable=yes');
		view_win.focus();
	}
}


function bbs_add_file(){
	if(MOBILE_CONN_YN == true){
		x_popup("../bbs_shop/popup/flash_fileup_form.htm?board_code="+document.getElementsByName('board_code')[0].value);

	}else{		
		var w = 420;
		var h = 350;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		var addfile = window.open("../bbs_shop/popup/flash_fileup_form.htm?board_code="+document.getElementsByName('board_code')[0].value,'','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		addfile.focus();
	}
}

function bbs_add_file_mobile(){
	if(MOBILE_CONN_YN == true){
		x_popup("../bbs_shop/popup/fileup_form.htm?board_code="+document.getElementsByName('board_code')[0].value);

	}else{
		var w = 330;
		var h = 270;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		var addfile = window.open("../bbs_shop/popup/fileup_form.htm?board_code="+document.getElementsByName('board_code')[0].value,'','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		addfile.focus();
	}
}

var movfile_pop;
function bbs_add_mov(){
	var tmp_board_idx = 0;
	if(document.frmWrite.mode.value == 'edit'){
		tmp_board_idx = document.frmWrite.idx.value;
	}

	if(MOBILE_CONN_YN == true){
		x_popup("/bbs_shop/mov_upload/mov_fileup_form.htm?board_code="+document.frmWrite.board_code.value+'&mode='+document.frmWrite.mode.value+'&board_idx='+tmp_board_idx,'movfile_pop');

	}else{		
		var w = 500;
		var h = 600;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		movfile_pop = window.open("/bbs_shop/mov_upload/mov_fileup_form.htm?board_code="+document.frmWrite.board_code.value+'&mode='+document.frmWrite.mode.value+'&board_idx='+tmp_board_idx,'movfile_pop','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		movfile_pop.focus();
	}
}

function bbs_movfile_pop_chk(mov_idx){

	var tmp_board_idx = 0;
	if(document.frmWrite.mode.value == 'edit'){
		tmp_board_idx = document.frmWrite.idx.value;
	}
	try{
		//alert('창닫음1')
		var iframe_name = create_iframe();
		document.getElementById(iframe_name).src="/bbs_shop/mov_upload/mov_fileup_chk.php?board_code="+document.frmWrite.board_code.value+'&mode='+document.frmWrite.mode.value+'&board_idx='+tmp_board_idx+'&mov_idx='+mov_idx;
	}catch(e){
		//alert('창닫음2')
		var iframe_name = create_iframe();
		document.getElementById(iframe_name).src="/bbs_shop/mov_upload/mov_fileup_chk.php?board_code="+document.frmWrite.board_code.value+'&mode='+document.frmWrite.mode.value+'&board_idx='+tmp_board_idx+'&mov_idx='+mov_idx;
	}
}

function bbs_add_bgm(){
	
	if(MOBILE_CONN_YN == true){
		x_popup("/bbs_shop/popup/bgmup_form.htm?board_code="+document.getElementsByName('board_code')[0].value);

	}else{
		var w = 420;
		var h = 380;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		var bgmfile = window.open("/bbs_shop/popup/bgmup_form.htm?board_code="+document.getElementsByName('board_code')[0].value,'bgmfile','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		bgmfile.focus();
	}
}

function bbs_add_link(){
	
	if(MOBILE_CONN_YN == true){
		x_popup("/bbs_shop/popup/link_form.htm?board_code="+document.getElementsByName('board_code')[0].value);

	}else{
		var w = 330;
		var h = 300;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		var addlink = window.open("/bbs_shop/popup/link_form.htm?board_code="+document.getElementsByName('board_code')[0].value,'addlink','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		addlink.focus();
	}

}


function bbs_add_poll(){

	if(MOBILE_CONN_YN == true){
		
		if(document.frmWrite.poll_idx.value){
			x_popup("/bbs_shop/popup/poll_form.htm?board_code="+document.getElementsByName('board_code')[0].value+"&poll_idx="+document.frmWrite.poll_idx.value);
		}else{
			x_popup("/bbs_shop/popup/poll_form.htm?board_code="+document.getElementsByName('board_code')[0].value);
		}

	}else{

		var w = 330;
		var h = 260;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	

		if(document.frmWrite.poll_idx.value){
			var addpoll = window.open("/bbs_shop/popup/poll_form.htm?board_code="+document.getElementsByName('board_code')[0].value+"&poll_idx="+document.frmWrite.poll_idx.value,'addpoll','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		}else{
			var addpoll = window.open("/bbs_shop/popup/poll_form.htm?board_code="+document.getElementsByName('board_code')[0].value,'addpoll','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		}
		addpoll.focus();
	}
}


function addList(dirname, filename, filesize ,imgid,bgm_title){    
    if (imgid == 'poll'){
		// 폴 첨부
        document.getElementById('attachfilelist').add(new Option('폴이 첨부되었습니다' , filename +"|"+imgid+"|"+filesize));

	}else if (imgid == 'bgm'){
		// 음악 첨부
        document.getElementById('attachfilelist').add(new Option('배경음악 - '+ bgm_title, dirname +"/" +filename +"|"+imgid+"|"+filesize + "|"+bgm_title));
	
	}else if(imgid == 'mobile_img'){
		// 모바일에서 이미지 첨부하는 경우..
		document.getElementById('attachfilelist').add(new Option('Image - '+filename + "   " + parseInt(parseInt(filesize)/1024) + "KB", dirname +"/" + filename +"|"+imgid+"|"+filesize));

    }else if (imgid == 'mov' || imgid == 'file' || imgid >0){
		// 일반 파일 첨부
        if (filesize){            
			document.getElementById('attachfilelist').add(new Option(filename + "   " + parseInt(parseInt(filesize)/1024) + "KB", dirname +"/" + filename +"|"+imgid+"|"+filesize));
        }else{
			document.getElementById('attachfilelist').add(new Option(filename, dirname +"/" + filename +"|"+imgid+"|"+filesize));
		}
    }
}


function addPoll(re_poll_idx){
	document.frmWrite.poll_idx.value = re_poll_idx;
}


function removeAttach(mode){
    var attachlist = document.getElementById('attachfilelist');
    
    if(attachlist.selectedIndex <= 0)return;

    if(attachlist.options[attachlist.selectedIndex].value.indexOf('poll') >= 0){
		document.frmWrite.poll_idx.value = "";
    }

	if(attachlist.options[attachlist.selectedIndex].value.indexOf('bgm') >= 0){
		document.frmWrite.bgm_title.value = "";
		document.frmWrite.bgm_dir.value = "";
    }

	var iframe_name = create_iframe();
	document.getElementById(iframe_name).src="/bbs_shop/file_del.php?mode="+mode+"&board_code="+document.frmWrite.board_code.value+"&board_idx="+document.frmWrite.idx.value+"&dir_file="+attachlist.options[attachlist.selectedIndex].value;
    attachlist.remove(attachlist.selectedIndex);
}

