if( window.console == undefined ){ console = { log : function(){} }; }

function input_on(input_var){
	input_var.style.backgroundColor = "#E5F3FA";
	input_var.style.borderColor="#77AACC";
}

function input_off(input_var){
	input_var.style.backgroundColor = "#F5F5F5";
	input_var.style.borderColor="#cccccc";
}

function tr_on(input_var){
	input_var.style.background = "#E5F3FA";
}

function tr_off(input_var){
	input_var.style.background = "#ffffff";
}

function log(str)
{
	console.log(str);
}


jQuery(document).ready(function() {
	/* 왼쪽 네비게이션 */
	var
		_sideNav = $('#sc_lft_nav')
	;
	
	// 1뎁스 첫번째 메뉴 열어놓기
	_sideNav.find('.stitle').next().hide();
	_sideNav.find('.stitle:first').next().show();
	_sideNav.find('.stitle:first dl').addClass('active');

	// 2뎁스메뉴 롤오버이벤트
	_sideNav.find('.bbox').mouseenter(function() {
		$(this).toggleClass('hover');
	}).mouseleave(function(){
		$(this).toggleClass('hover');
	});
	
	// 2뎁스메뉴 클릭이벤트
	_sideNav.find('.subj').click(function() {
		var
			_bbox = $(this).parent(),
			_bboxs = _sideNav.find('.bbox'),
			_url = $(this).attr('href')
		;
		_bboxs.removeClass('active');
		_bbox.addClass('active');
		
		console.log(_url);
		if (_url) {
			parent.m_body.location = _url;
		}
		return false;
	});
	
	// 2뎁스메뉴 팝업창 클릭이벤트
	_sideNav.find('.pop_link').click(function() {
		window_open($(this).prev().attr('href'),1000,700);
		return false;
	});
	
	// 1뎁스메뉴 클릭이벤트
	_sideNav.find('.stitle dl').click(function() {
		var _child = $(this).parent().parent().next();
		if (!$(this).hasClass('active')) {
			_sideNav.find('.child_tr').hide();
			_child.parent().find('.stitle dl').removeClass('active');
			
			_child.show();
			$(this).addClass('active');
		} else {
			$(this).toggleClass('active')
			_child.toggle();
			log($(this));
		}
	});
	
	/* // 왼쪽 네비게이션 */
});
