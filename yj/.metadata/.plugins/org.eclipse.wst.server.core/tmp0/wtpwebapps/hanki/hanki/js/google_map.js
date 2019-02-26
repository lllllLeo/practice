function gg_map_search(addr1,addr2,google_map_x,google_map_y){
	var w = 600;
	var h = 600;
	var window_left = (screen.width-w)/2;
	var window_top = (screen.height-h)/2;	
	
	var google_map_x_val = document.getElementById('google_map_x').value;
	var google_map_y_val = document.getElementById('google_map_y').value;

	var ori_addr = document.getElementsByName('ori_addr1')[0].value + ' ' +document.getElementsByName('ori_addr2')[0].value;
	var addr = document.getElementsByName(addr1)[0].value + ' ' +document.getElementsByName(addr2)[0].value;

	if(addr != ori_addr){
		document.getElementById('google_map_x').value = 0;
		document.getElementById('google_map_y').value = 0;
		google_map_x_val = 0;
		google_map_y_val = 0;
		document.getElementsByName('ori_addr1')[0].value = document.getElementsByName(addr1)[0].value;
		document.getElementsByName('ori_addr2')[0].value = document.getElementsByName(addr2)[0].value;
	}

	var gg_map_search_win = window.open('/API/google_map/xy_search.htm?addr='+addr+'&google_map_x='+google_map_x+'&google_map_y='+google_map_y+'&google_map_x_val='+google_map_x_val+'&google_map_y_val='+google_map_y_val,'gg_map_search_win','top='+window_top+',left='+window_left+',width='+w+',height='+h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
	gg_map_search_win.focus();
}

function google_map_xy_ouput(str){	
	str += "";
	str = str.replace("(","");
	str = str.replace(")","");
	str = str.replace(" ","");
	var tmp_arr = str.split(',');
	document.getElementById('google_map_x').value = tmp_arr[0];
	document.getElementById('google_map_y').value = tmp_arr[1];
	
	var fn_result = new Array();
	fn_result['google_map_x'] = tmp_arr[0];
	fn_result['google_map_y'] = tmp_arr[1];
	return fn_result;
}

function google_map_xy_ouput2(str){	
	str += "";
	str = str.replace("(","");
	str = str.replace(")","");
	str = str.replace(" ","");
	var tmp_arr = str.split(',');
	
	return tmp_arr;
}


function google_map_submit_chk(addr_str){
	
	var g_map_load = 0;

	if(addr_str && addr_str != ''){

		if(document.getElementById('google_map_x') && document.getElementById('google_map_y')){
			
			var x = document.getElementById('google_map_x').value;
			var y = document.getElementById('google_map_y').value;

			if(x == '' || x == '0' || !x || y == '' || y == '0' || !y  ){
				var g_map_load = 1;
				geocoder =  new google.maps.Geocoder();	
				geocoder.geocode( {'address': addr_str }, function(results, status) {
								if ( status == google.maps.GeocoderStatus.OK ) {
									for ( var j = 0; j < results.length; j++ ) {                        
										google_map_xy_ouput(results[j].geometry.location);
										ok_frame2.location.href="/API/google_map/xy_sav.php?google_map_x="+document.getElementById("google_map_x").value+"&google_map_y="+document.getElementById("google_map_y").value+"&addr="+addr_str;
									} 		
								}
							});
			}

		}
	}
	
	return g_map_load;
}

function google_map_addr(title,addr,w,h,zoom,id){
	if(!title) title = '';
	if(!zoom) zoom = '16';
	if(!w) w = '300';
	if(!h) h = '300';
	if(!id) id = 'google_iframe';
	if(!addr) addr = '';
	
	var map_src = "/API/google_map/google_map_addr.htm?addr="+addr+"&title="+title+"&zoom="+zoom;
	if(document.getElementById(id)){
		document.getElementById(id).src = map_src;
	}else{
		document.write("<iframe src='"+map_src+"' width="+w+" height="+h+" frameborder=0 scrolling=no id='"+id+"' name='"+id+"' ></iframe>");
	}
}

function google_map_xy(title,x,y,w,h,zoom,id,mode){
	if(!title) title = '';
	if(!zoom) zoom = '16';
	if(!w) w = '300';
	if(!h) h = '300';
	if(!id) id = 'google_iframe';
	
	var map_src = "/API/google_map/google_map_addr.htm?google_map_x="+x+"&google_map_y="+y+"&title="+title+"&zoom="+zoom;

	if(mode == 'popup'){
		var popup_w = w+50;
		var popup_h = h+100;
		var window_left = (screen.width-w)/2;
		var window_top = (screen.height-h)/2;	
		var google_map_xy_win = window.open(map_src,'google_map_xy_win','top='+window_top+',left='+window_left+',width='+popup_w+',height='+popup_h+',toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no');
		google_map_xy_win.focus();

	}else{
		if(document.getElementById(id)){
			document.getElementById(id).src = map_src;
		}else{
			document.write("<iframe src='"+map_src+"' width="+w+" height="+h+" frameborder=0 scrolling=no id='"+id+"' name='"+id+"' ></iframe>");
		}
	}
}


function google_map_json(json,default_addr,w,h,zoom,id){
	if(!zoom) zoom = '16';
	if(!w) w = '300';
	if(!h) h = '300';
	if(!default_addr) default_addr = '';
	if(!id) id = 'google_iframe';
	
	var map_src = "/API/google_map/google_map_json.htm?json="+json+"&zoom="+zoom+"&default_addr="+default_addr;

	if(document.getElementById(id)){
		document.getElementById(id).src = map_src;
	}else{
		document.write("<iframe src='"+map_src+"' width="+w+" height="+h+" frameborder=0 scrolling=no id='"+id+"' name='"+id+"' ></iframe>");
	}
}



// UTF-8 한글 체크