var IE = false;
if (window.navigator.appName.indexOf("Explorer") != -1) {
    IE = true
}
var MOBILE_CONN_YN = false;
var filter = "win16|win32|win64|mac";
if (navigator.platform) {
    if (filter.indexOf(navigator.platform.toLowerCase()) < 0) {
        MOBILE_CONN_YN = true
    }
}
if (window.console == undefined) {
    console = {
        log: function() {}
    }
}

function flash(d, b, c, a) {
    html = "";
    html += '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="' + b + '" height="' + c + '" id="' + a + '" name="' + a + '">';
    html += '<param name="movie" value="' + d + '">';
    html += '<param name="quality" value="high">';
    html += '<param name="wmode" value="transparent">';
    html += '<embed src="' + d + '" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="' + b + '" height="' + c + '"></embed></object>';
    document.write(html)
}

function bluring() {
    try {
        if (event.srcElement.tagName == "A" || event.srcElement.tagName.toUpperCase() == "IMG" || event.srcElement.type == "radio" || event.srcElement.type == "checkbox" || event.srcElement.type == "image") {
            document.body.focus()
        }
    } catch (a) {}
}

function multi_file_download_chk(a, c, d) {
    if (a == "app") {
        app_download(c, d)
    } else {
        if (a == "mobile") {
            location.href = c
        } else {
            var b = create_iframe();
            document.getElementById(b).src = c
        }
    }
}

function default_content_load(obj_name, default_content) {
    var obj_mode = document.getElementById(obj_name + "_editor_mode");
    if (obj_mode) {
        if (obj_mode.value == "ckeditor") {
            var oEditor = eval("CKEDITOR.instances." + obj_name);
            oEditor.setData(default_content)
        } else {
            if (obj_mode.value == "source") {
                document.getElementById(obj_name).value = default_content;
                eval(obj_name + "_codepress.edit(obj_name,'javascript')")
            } else {
                if (obj_mode.value == "text") {
                    document.getElementById(obj_name).value = default_content
                }
            }
        }
    } else {
        if (document.getElementById(obj_name)) {
            document.getElementById(obj_name).value = default_content
        } else {
            document.getElementsByName(obj_name)[0].value = default_content
        }
    }
}

function radio_val(c) {
    var b = document.getElementsByName(c);
    if (!b) {
        return
    }
    for (var a = 0; a < b.length; a++) {
        if (b[a].checked == true) {
            return b[a].value
        }
    }
    return false
}

function editor_css_view(c, b) {
    if (document.getElementById(c + "_html")) {
        document.getElementById(c + "_html").style.display = "none"
    }
    for (var a = 0; a < 20; a++) {
        if (document.getElementById(c + "_css_" + a)) {
            document.getElementById(c + "_css_" + a).style.display = "none"
        }
    }
    if (b == "html") {
        if (document.getElementById(c + "_html")) {
            document.getElementById(c + "_html").style.display = "block"
        }
    } else {
        if (document.getElementById(c + "_css_" + b)) {
            document.getElementById(c + "_css_" + b).style.display = "block"
        }
    }
}

function editor_img_pop(var_name, file_path, img_water_type) {
    if (document.getElementById(var_name + "_editor_mode")) {
        if (document.getElementById(var_name + "_editor_mode").value == "ckeditor") {
            var oEditor = eval("CKEDITOR.instances." + var_name);
            if (oEditor.mode != "wysiwyg") {
                oEditor.execCommand("source")
            }
        }
    }
    if (!file_path) {
        file_path = ""
    }
    if (!img_water_type) {
        img_water_type = ""
    }
    var w = 500;
    var h = 730;
    var window_left = (screen.width - w) / 2;
    var window_top = (screen.height - h) / 2;
    var editor_img_pop_win = window.open("../../../html_editor/upload/imgup_form.htm?mode=one&var_name=" + var_name + "&img_water_type=" + img_water_type + "&file_path=" + file_path + "&admin_conn_yn=1", "", "top=" + window_top + ",left=" + window_left + ",width=" + w + ",height=" + h + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    editor_img_pop_win.focus()
}

function editor_m_img_pop(var_name, file_path, img_water_type) {
    if (document.getElementById(var_name + "_editor_mode")) {
        if (document.getElementById(var_name + "_editor_mode").value == "ckeditor") {
            var oEditor = eval("CKEDITOR.instances." + var_name);
            if (oEditor.mode != "wysiwyg") {
                oEditor.execCommand("source")
            }
        }
    }
    if (!file_path) {
        file_path = ""
    }
    if (!img_water_type) {
        img_water_type = ""
    }
    var w = 500;
    var h = 900;
    var window_left = (screen.width - w) / 2;
    var window_top = (screen.height - h) / 2 - 50;
    var editor_m_img_pop_win = window.open("../../../html_editor/upload/imgup_form.htm?mode=multi&var_name=" + var_name + "&img_water_type=" + img_water_type + "&file_path=" + file_path + "&admin_conn_yn=1", "", "top=" + window_top + ",left=" + window_left + ",width=" + w + ",height=" + h + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    editor_m_img_pop_win.focus()
}

function editor_mov_pop(editor_name) {
    if (document.getElementById(editor_name + "_editor_mode")) {
        if (document.getElementById(editor_name + "_editor_mode").value == "ckeditor") {
            var oEditor = eval("CKEDITOR.instances." + editor_name);
            if (oEditor.mode != "wysiwyg") {
                oEditor.execCommand("source")
            }
        }
    }
    var w = 850;
    var h = 800;
    var window_left = (screen.width - w) / 2;
    var window_top = (screen.height - h) / 2;
    var editor_m_img_pop_win = window.open("/admin/sub_contents/ucc_data_select_list.htm?editor_name=" + editor_name, "", "top=" + window_top + ",left=" + window_left + ",width=" + w + ",height=" + h + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    editor_m_img_pop_win.focus()
}

function editor_bgm_pop(var_name, file_path, img_water_type) {
    if (document.getElementById(var_name + "_editor_mode")) {
        if (document.getElementById(var_name + "_editor_mode").value == "ckeditor") {
            var oEditor = eval("CKEDITOR.instances." + var_name);
            if (oEditor.mode != "wysiwyg") {
                oEditor.execCommand("source")
            }
        }
    }
    if (!file_path) {
        file_path = ""
    }
    if (!img_water_type) {
        img_water_type = ""
    }
    var w = 500;
    var h = 730;
    var window_left = (screen.width - w) / 2;
    var window_top = (screen.height - h) / 2;
    var editor_img_pop_win = window.open("/html_editor/upload/bgm_form.htm?mode=one&var_name=" + var_name + "&img_water_type=" + img_water_type + "&file_path=" + file_path, "", "top=" + window_top + ",left=" + window_left + ",width=" + w + ",height=" + h + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    editor_img_pop_win.focus()
}

function design_components(var_name, time) {
    if (document.getElementById(var_name + "_editor_mode")) {
        if (document.getElementById(var_name + "_editor_mode").value == "ckeditor") {
            var oEditor = eval("CKEDITOR.instances." + var_name);
            if (oEditor.mode != "wysiwyg") {
                oEditor.execCommand("source")
            }
        }
    }
    var w = 900;
    var h = 750;
    var window_left = 0;
    var window_top = 0;
    var design_components_win = window.open("/admin/sub_design/components__data_list.htm?var_name=" + var_name, "design_components_win_" + time, "top=" + window_top + ",left=" + window_left + ",width=" + w + ",height=" + h + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    design_components_win.focus()
}

function premium_design(d) {
    var c = 900;
    var e = 750;
    var f = 0;
    var a = 0;
    var b = window.open("/admin/sub_program/program_group_view.htm?page_name=" + d, "premium_design_win", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    b.focus()
}

function service_tpl_copy(b, c) {
    var d = document.getElementById(b);
    if (!d.value || d.value == "") {
        alert("디자인 템플릿을 선택해주세요.");
        return
    }
    if (confirm("선택하신 디자인으로 변경 하시겠습니까?")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_design/service_tpl_load.php?tar_content=" + c + "&tpl_idx=" + d.value
    }
}

function help_book(e) {
    if (!e) {
        e = ""
    }
    var c = 1000;
    var d = 800;
    var f = 0;
    var b = 0;
    var a = window.open("/admin/help_book/?s_idx=" + e, "", "top=" + b + ",left=" + f + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    a.focus()
}

function flash(c, b, h, j, a, d, f) {
    var g = new String();
    if (!a) {
        var e = Math.random() * 10000;
        e = Math.round(e);
        a = "flash_name" + e
    }
    if (navigator.appName.indexOf("Microsoft") != -1) {
        g += '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" ';
        g += 'codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=version=8,0,0,0" ';
        g += 'id="' + a + '" width="' + b + '" height="' + h + '" typ="swf">';
        g += '<param name="movie" value="' + c + '"/>';
        if (d != null) {
            g += '<param name="flashvars" value="' + d + '"/>'
        }
        g += '<param name="quality" value="high"/>';
        if (j != null) {
            g += '<param name="bgcolor" value="' + j + '"/>'
        }
        g += '<param name="menu" value="false"/>';
        g += '<param name="salign" value="LT"/>';
        g += '<param name="wmode" value="transparent"/>';
        g += '<param name="allowScriptAccess" value="always"/>';
        if (f != null) {
            g += '<param name="xml_path" value="' + f + '"/>'
        }
        g += "</object>"
    } else {
        g += '<embed src="' + c + '" ';
        g += 'quality="high" ';
        if (j != null) {
            g += 'bgcolor="' + j + '" '
        }
        g += 'width="' + b + '" ';
        g += 'height="' + h + '" ';
        if (f != null) {
            g += 'xml_path="' + f + '" '
        }
        g += 'menu="false" ';
        g += 'id="' + a + '" ';
        g += 'salign="LT" ';
        g += 'wmode="transparent" ';
        g += 'allowScriptAccess="always" ';
        if (d != null) {
            g += 'flashvars="' + d + '" '
        }
        g += 'type="application/x-shockwave-flash" ';
        g += 'pluginspage="http://www.macromedia.com/go/getflashplayer" typ="swf">';
        g += "</embed>"
    }
    document.write(g)
}

function comma(d) {
    var c = 0;
    var b = 0;
    var a = "";
    d = d + "";
    for (b = (d.length) - 1, c = 0; b >= 0; b--, c++) {
        if (c % 3 == 0 && c > 0) {
            a = d.charAt(b) + "," + a
        } else {
            a = d.charAt(b) + a
        }
    }
    a = a.replace("-,", "-");
    return a
}

function number_format(f, c, h, e) {
    f = (f + "").replace(/[^0-9+\-Ee.]/g, "");
    var b = !isFinite(+f) ? 0 : +f,
        a = !isFinite(+c) ? 0 : Math.abs(c),
        k = (typeof e === "undefined") ? "," : e,
        d = (typeof h === "undefined") ? "." : h,
        j = "",
        g = function(o, m) {
            var l = Math.pow(10, m);
            return "" + (Math.round(o * l) / l).toFixed(m)
        };
    j = (a ? g(b, a) : "" + Math.round(b)).split(".");
    if (j[0].length > 3) {
        j[0] = j[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, k)
    }
    if ((j[1] || "").length < a) {
        j[1] = j[1] || "";
        j[1] += new Array(a - j[1].length + 1).join("0")
    }
    return j.join(d)
}

function money_format(c, a) {
    var b;
    a += "";
    a = a.replace(/,/gi, "");
    if (c == "＄" || c == "$" || c == "￡" || c == "￥" || c == "EUR" || c == "USD" || c == "US $" || c == "Can$") {
        a *= 1;
        if (a < 0) {
            b = "-$" + number_format(Math.abs(a), 2)
        } else {
            b = "$" + number_format(a, 2)
        }
    } else {
        a *= 1;
        a = Math.floor(a);
        b = number_format(a)
    }
    return b
}

function mem_info(f) {
    var b = 750;
    var c = 600;
    var e = (screen.width - b) / 2;
    var a = (screen.height - c) / 2;
    var d = window.open("/admin/sub_member/mem_form.htm?sel_id=" + f, "mem_info_win", "top=" + a + ",left=" + e + ",width=" + b + ",height=" + c + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function campus_play_info(b) {
    var c = 900;
    var e = 600;
    var f = (screen.width - c) / 2;
    var a = (screen.height - e) / 2;
    var d = window.open("/admin/sub_campus/mem_play_info.htm?mem_id=" + b, "campus_play_info_win", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function service_qna_pop(b) {
    if (!b) {
        b = ""
    }
    var c = 1000;
    var d = 800;
    var f = (screen.width - c) / 2;
    var a = (screen.height - d) / 2;
    var e = window.open("/admin/help_book/?board_code=qna&s_idx=" + b, "", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    e.focus()
}

function service_faq_pop(b) {
    if (!b) {
        b = ""
    }
    var c = 750;
    var d = 600;
    var f = (screen.width - c) / 2;
    var a = (screen.height - d) / 2;
    var e = window.open("/admin/sub_community/service_notice_list.htm?code=faq&menu_s_idx=" + b, "service_faq_pop_win", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    e.focus()
}

function bookmark_del(a) {
    if (confirm("선택한 책갈피를 삭제 하시겠습니까?")) {
        var b = create_iframe();
        document.getElementById(b).src = "/admin/sub_all/bookmark_exec.php?mode=del&idx=" + a
    }
}

function bookmark_move(b, a) {
    var c = create_iframe();
    document.getElementById(c).src = "/admin/sub_all/bookmark_exec.php?mode=move&idx=" + b + "&move_type=" + a
}

function bookmark_sav(b) {
    if (confirm("책갈피에 추가 하시겠습니까?")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_all/bookmark_exec.php?mode=add&menu_s_idx=" + b
    }
}

function n_bookmark_del(a) {
    if (confirm("선택한 마이메뉴를 삭제 하시겠습니까?")) {
        var b = create_iframe();
        document.getElementById(b).src = "/admin/sub_all/bookmark_exec.php?mode=del&idx=" + a
    }
}

function n_bookmark_move(b, a) {
    var c = create_iframe();
    document.getElementById(c).src = "/admin/sub_all/bookmark_exec.php?mode=move&idx=" + b + "&move_type=" + a
}

function n_bookmark_sav(b) {
    if (confirm("마이메뉴에 추가 하시겠습니까?")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_all/bookmark_exec.php?mode=add&menu_s_idx=" + b
    }
}

function frame_resize(d, a) {
    try {
        if (!a) {
            a = 0
        }
        if (a > 0) {
            var b = parent.document.frames(d).document.body.scrollHeight;
            parent.document.getElementById(d).style.height = b + "px"
        }
        if (a < 5) {
            setTimeout("frame_resize('" + d + "'," + (a + 1) + ")", 400)
        }
    } catch (c) {}
}

function shop_link(b, c, a, d) {
    if (!c) {
        c = ""
    }
    if (!a) {
        a = ""
    }
    if (!d) {
        d = ""
    }
    if (c) {
        c = escape(c)
    }
    window.open("/shop_admin/shop_link.php?shop_id=" + b + "&go_url=" + c + "&mobile_conn=" + a + "&magic_all_idx=" + d)
}

function shop_base_win(a) {
    window.open("/admin/sub_admin/shop_edit_base.htm?shop_id=" + a)
}

function on_focus(a) {
    if (a.readOnly == false) {
        a.style.backgroundColor = "#FFFF66";
        a.select()
    }
}

function on_blur(a) {
    if (a.readOnly == false) {
        a.style.backgroundColor = "#ffffff"
    }
}

function mouseOut(a) {
    a.className = "tb10"
}

function mouseOver(a) {
    a.className = "tb3"
}

function dis_on(a) {
    a.disabled = true;
    a.style.backgroundColor = "dddddd"
}

function dis_off(a) {
    a.disabled = false;
    a.style.backgroundColor = "ffffff"
}

function num_chk(a) {
    if (a.value) {
        for (i = 0; i < a.value.length; i++) {
            if ((a.value.charAt(i) >= 0 && a.value.charAt(i) <= 9) || a.value.charAt(i) == "-" || a.value.charAt(i) == ".") {} else {
                alert("숫자만 입력해주세요.");
                a.focus();
                return false
            }
        }
    }
    return true
}

function num_chk2(a) {
    if (a.prop("value")) {
        for (i = 0; i < a.prop("value").length; i++) {
            if ((a.prop("value").charAt(i) >= 0 && a.prop("value").charAt(i) <= 9) || a.prop("value").charAt(i) == "-" || a.prop("value").charAt(i) == ".") {} else {
                alert("숫자만 입력해주세요.");
                a.focus();
                return false
            }
        }
    }
    return true
}

function mov_play(a) {
    var b = 400;
    var d = 400;
    var c = window.open("../../popup/player.htm?idx=" + a, "shop_detail_win", "top=0,left=0,width=" + b + ",height=" + d + ",toolbar=no,scrollbars=no,resizable=no,status=yes,menubar=no,location=no");
    c.focus()
}

function search_zip() {
    var c = (screen.width - 640) / 2;
    var b = (screen.height - 480) / 2;
    var a = window.open("/shop_popup/zipcode.htm?admin_yn=1", "postcodefind", "resizable=yes,toolbar=no,width=430,height=500,scrollbars=yes,top=" + b + ",left=" + c + "");
    a.focus()
}

function ok_frame_chk() {
    if (document.getElementById("div_ok_frame")) {
        document.getElementById("div_ok_frame").style.display = "block"
    }
    if (document.getElementById("ok_frame")) {
        document.getElementById("ok_frame").style.height = "100px";
        document.getElementById("ok_frame").style.width = "600px"
    }
}

function strTrim(b) {
    var a = /\s+/g;
    return b.replace(a, "")
}

function getDigit(b) {
    var a, d;
    var c = "";
    for (a = 0; a < b.value.length; a++) {
        d = b.value.substring(a, a + 1);
        if (d != ",") {
            c += d
        }
    }
    return c
}

function MakePayValue(b) {
    var f = new String(b);
    var c = f.length;
    var h = "";
    var g = "";
    if (c < 3) {
        return f
    }
    var e = 0;
    for (var d = c; d > 0; d--) {
        h = h + f.substring(d - 1, d);
        if (++e == 3 && d > 1) {
            h = h + ",";
            e = 0
        }
    }
    var a = new String(h);
    for (d = a.length; d > 0; d--) {
        g = g + a.substring(d - 1, d)
    }
    return (g)
}

function isDigit(e, b) {
    var d = true;
    var c = "0123456789" + b;
    for (var a = 0; a < e.length; a++) {
        if (c.indexOf(e.charAt(a)) < 0) {
            d = false;
            break
        }
    }
    return d
}

function getNumber(d) {
    var c = "0123456789.";
    var a = "";
    for (var b = 0; b < d.length; b++) {
        if (c.indexOf(d.charAt(b)) < 0) {
            continue
        } else {
            a = a + d.charAt(b)
        }
    }
    if (a.length < 1) {
        return 0
    }
    return parseInt(a)
}

function OnChangedNumText(a) {
    a.value = MakePayValue(parseInt(getNumber(a.value)))
}

function __OnPreview(b, a, c) {
    if (document.readyState == "complete") {
        document.getElementById("__ImgPreview").innerHTML = c;
        document.getElementById("__ImgPreview").style.pixelLeft = event.clientX + document.body.scrollLeft + 10;
        document.getElementById("__ImgPreview").style.pixelTop = event.clientY + document.body.scrollTop + 10;
        document.getElementById("__ImgPreview").style.display = "block"
    }
}

function __OnPreviewClose() {
    document.getElementById("__ImgPreview").style.display = "none"
}
var _centerWnd = null;

function WndCenterOpen(f, e, b, d, a, c) {
    LeftPosition = (screen.width) ? (screen.width - b) / 2 : 0;
    TopPosition = (screen.height) ? (screen.height - d) / 2 : 0;
    settings = "height=" + d + ",width=" + b + ",top=" + TopPosition + ",left=" + LeftPosition + ",resizable=yes,status=no,scrollbars=" + a + "," + c;
    _centerWnd = window.open(f, e, settings);
    return _centerWnd
}

function OpenModalDialog(c, e, b, a) {
    var d = window.showModalDialog(c, e, "dialogwidth:" + b + "px;dialogheight:" + a + "px;toolbar:no;location:no;help:no;directories:no;status:no;menubar:no;scrollbars=no;resizable:no");
    return d
}

function OnActiveXControlError(a) {
    alert("'예(Y)'버튼을 클릭하셔야 " + a + "(을)를 이용하실 수 있습니다.")
}

function getDigit(b) {
    var a, d;
    var c = "";
    for (a = 0; a < b.value.length; a++) {
        d = b.value.substring(a, a + 1);
        if (d != ",") {
            c += d
        }
    }
    return c
}

function MakePayValue(b) {
    var f = new String(b);
    var c = f.length;
    var h = "";
    var g = "";
    if (c < 3) {
        return f
    }
    var e = 0;
    for (var d = c; d > 0; d--) {
        h = h + f.substring(d - 1, d);
        if (++e == 3 && d > 1) {
            h = h + ",";
            e = 0
        }
    }
    var a = new String(h);
    for (d = a.length; d > 0; d--) {
        g = g + a.substring(d - 1, d)
    }
    return (g)
}

function isDigit(f, b) {
    var d = true;
    var c = "0123456789" + b;
    var e;
    for (var a = 0; a < f.length; a++) {
        if (c.indexOf(f.charAt(a)) < 0) {
            d = false;
            break
        }
    }
    return d
}

function getNumber(d) {
    var c = "0123456789.";
    var a = "";
    for (var b = 0; b < d.length; b++) {
        if (c.indexOf(d.charAt(b)) < 0) {
            continue
        } else {
            a = a + d.charAt(b)
        }
    }
    if (a.length < 1) {
        return 0
    }
    return parseInt(a)
}

function OnChangedNumText(a) {
    a.value = MakePayValue(parseInt(getNumber(a.value)))
}

function mgCheckRadioGroup(b) {
    if (b.length > 1) {
        for (var a = 0; a < b.length; a++) {
            if (b[a].checked) {
                return true
            }
        }
    } else {
        if (b.checked) {
            return true
        }
    }
    return false
}

function mgGetRadioGroupItem(b) {
    if (b.length > 1) {
        for (var a = 0; a < b.length; a++) {
            if (b[a].checked) {
                return a
            }
        }
    } else {
        if (b.checked) {
            return 0
        }
    }
    return -1
}

function mgGetFileExt(b) {
    var a = b.substr(b.length - 3, 3).toLowerCase();
    return a
}

function mgCheckFlashFile(b) {
    var a = b.substr(b.length - 3, 3).toLowerCase();
    if (a == "swf") {
        return true
    }
    return false
}

function mgCheckImageFile(b) {
    var a = b.substr(b.length - 3, 3).toLowerCase();
    switch (a) {
        case "gif":
        case "jpg":
        case "png":
        case "jpeg":
        case "jpe":
            return true;
            break
    }
    return false
}

function ObjectIsNumber(b, c, d) {
    var a = "";
    if (isDigit(b.value, "-+") && b.value.length >= c) {
        return true
    }
    if (c > 0) {
        a = "\n\n'" + d + "' 항목은 필수항목입니다."
    }
    alert("'" + d + "' 항목은 정수만 입력 가능합니다." + a);
    b.focus();
    return false
}

function ObjectIsFloatNumber(b, c, d) {
    var a = "";
    if (isDigit(b.value, "-+.") && b.value.length >= c) {
        return true
    }
    if (c > 0) {
        a = "\n\n'" + d + "' 항목은 필수항목입니다."
    }
    alert("'" + d + "' 항목은 실수만 입력 가능합니다." + a);
    b.focus();
    return false
}

function ObjectIsKorean(b, c, d) {
    var a = "";
    if (isKorean(b.value) && b.value.length >= c) {
        return true
    }
    if (c > 0) {
        a = "\n\n'" + d + "' 항목은 필수항목입니다."
    }
    alert("'" + d + "' 항목은 한글만 입력 가능합니다." + a);
    b.focus();
    return false
}

function ObjectIsAlphabet(b, c, d) {
    var a = "";
    if (isAlphabet(b.value) && b.value.length >= c) {
        return true
    }
    if (c > 0) {
        a = "\n\n'" + d + "' 항목은 필수항목입니다."
    }
    alert("'" + d + "' 항목은 영문만 입력 가능합니다." + a);
    b.focus();
    return false
}

function isKorean(c) {
    for (i = 0; i < c.value.length; i++) {
        var b = c.value.charCodeAt(i);
        if (b > 128) {
            return true
        }
    }
    return false
}

function isEnglish(c) {
    for (i = 0; i < c.value.length; i++) {
        var b = c.value.charCodeAt(i);
        if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)) {
            continue
        } else {
            return false
        }
    }
    return true
}

function isUserId(d) {
    var c = true;
    var b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";
    for (var a = 0; a < d.length; a++) {
        if (b.indexOf(d.charAt(a)) < 0) {
            c = false;
            break
        }
    }
    if (isDigit(d.charAt(0), "")) {
        return false
    }
    return c
}

function isGoodsId(d) {
    var c = true;
    var b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890-_";
    for (var a = 0; a < d.length; a++) {
        if (b.indexOf(d.charAt(a)) < 0) {
            c = false;
            break
        }
    }
    return c
}

function isUnvaildChar(c) {
    for (i = 0; i < c.value.length; i++) {
        var b = c.value.charCodeAt(i);
        if (b == 94 || b == 124) {
            return true
        }
    }
    return false
}

function isDisallowChar(d, c) {
    var b = false;
    for (var a = 0; a < d.length; a++) {
        if (c.indexOf(d.charAt(a)) >= 0) {
            b = true;
            break
        }
    }
    return b
}

function isEMail(a) {
    if (a.search(/(^\..*)|(.*\.$)/) != -1 || a.search(/\S+@(\S+)\.(\S+)/) == -1) {
        alert("전자우편주소의 형식은 '계정@[호스트|도메인]'과 같이 구성되어야 하며,\r\n양쪽에 '.'이 기재되어서는 안됩니다.\r\n\r\n예) userid@domain.co.kr");
        return false
    }
    return true
}

function isCivilNo(c) {
    var b = 0;
    var d = "234567892345";
    for (var a = 0; a < 12; a++) {
        b = b + parseInt(c.substring(a, a + 1)) * parseInt(d.substring(a, a + 1))
    }
    b = 11 - (b % 11);
    if (b == 10) {
        b = 0
    } else {
        if (b == 11) {
            b = 1
        }
    }
    if (parseInt(c.substring(12, 13)) != b) {
        return false
    }
    return true
}

function isDenyEMail(c, b) {
    if (c.search(/(^\..*)|(.*\.$)/) != -1 || c.search(/\S+@(\S+)\.(\S+)/) == -1) {
        alert("전자우편주소의 형식은 '계정@[호스트|도메인]'과 같이 구성되어야 하며,\r\n양쪽에 '.'이 기재되어서는 안됩니다.\r\n\r\n예) angel@pointshop.co.kr");
        return false
    }
    if (b) {
        ar_email = c.split("@");
        if (b.charAt(";")) {
            ar_denymail = b.split(";");
            for (var a = 0; a < ar_denymail.length; a++) {
                if (ar_email[1].toLowerCase() == ar_denymail[a]) {
                    alert(ar_denymail[a] + " 이메일 주소는 메일수신이 되지 않습니다. 다른 메일주소를 입력해 주세요.");
                    return false
                }
            }
        } else {
            if (ar_email[1].toLowerCase() == b) {
                alert(b + " 이메일 주소는 메일수신이 되지 않습니다. 다른 메일주소를 입력해 주세요.");
                return false
            }
        }
    }
    return true
}

function trim(d) {
    var c = d.length;
    var a = c;
    var b = 0;
    while ((b < a) && (d.charAt(b) <= " ")) {
        b++
    }
    while ((b < a) && (d.charAt(a - 1) <= " ")) {
        a--
    }
    return ((b > 0) || (a < c)) ? d.substring(b, a) : d
}

function OnSendMail(d) {
    if (!d) {
        d = ""
    }
    var c = 750;
    var e = 630;
    var f = (screen.width - c) / 2;
    var a = (screen.height - e) / 2;
    var b = window.open("/admin/sub_member2/mail_one_form.htm?to_email_list=" + d, "OnSendMail_win", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    b.focus()
}

function OnSendSMS(c) {
    if (!c) {
        c = ""
    }
    var b = 950;
    var e = 650;
    var f = (screen.width - b) / 2;
    var a = (screen.height - e) / 2;
    var d = window.open("/admin/sub_marketing/sms_one_form.htm?to_hp=" + c, "OnSendSMS_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function agc_send_win(c) {
    if (!c) {
        c = ""
    }
    var b = 1200;
    var e = 900;
    var f = (screen.width - b) / 2;
    var a = (screen.height - e) / 2;
    var d = window.open("/admin_agc/sub_page/agc_goods_list.htm?to_hp=" + c, "agc_send_win_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function send_memo(a) {
    if (a == "") {
        var b = "/admin/post/s_paper_form.htm"
    } else {
        var b = "/admin/post/s_paper_form.htm?mem_id=" + a
    }
    WndCenterOpen(b, "", 500, 500, 0, "")
}

function OnSMSLibrary(c, b) {
    var a = "/admin/sub_marketing/sms_tema.htm?vFormName=" + c + "&vValName=" + b;
    return WndCenterOpen(a, "", 600, 710, 0, "")
}

function OpenImageView(a) {
    popwin = window.open("", "", "width=100,height=100");
    popwin.document.open();
    popwin.document.write("<head><title>이미지보기</title></head>");
    popwin.document.write("<body topmargin=0 leftmargin=0 marginwidth=0 marginheight=0>");
    popwin.document.write("<a href='javascript:self.close()'><IMG SRC=" + a + "></a>");
    popwin.document.write("<script language=javascript>\n");
    popwin.document.write("if ( document.images.length ) {\n");
    popwin.document.write(" var sizew = document.images[0].width\n");
    popwin.document.write(" var sizeh = document.images[0].height\n");
    popwin.document.write(" self.resizeTo(sizew, sizeh)\n");
    popwin.document.write("} else { alert('이미지가 없습니다.'); window.close(); }\n");
    popwin.document.write("<\/script></body>\n")
}

function OnSwapOptionItem(objForm, id, dir) {
    eval("var vObj = objForm." + id + ";");
    if (vObj.options.length < 1) {
        alert("선택할 항목이 없습니다.");
        return
    }
    var nSel = vObj.selectedIndex;
    var nMax = vObj.options.length - 1;
    if (nSel < 0) {
        alert("선택된 항목이 없습니다. 이동할 항목을 선택하세요.");
        return
    }
    var nVal;
    var nText;
    if (dir > 0) {
        if (nSel + 1 > nMax) {
            return
        }
        nVal = vObj.options[nSel + 1].value;
        nText = vObj.options[nSel + 1].text;
        vObj.options[nSel + 1].value = vObj.options[nSel].value;
        vObj.options[nSel + 1].text = vObj.options[nSel].text;
        vObj.options[nSel].value = nVal;
        vObj.options[nSel].text = nText;
        vObj.selectedIndex = nSel + 1
    } else {
        if (dir < 0) {
            if (nSel == 0) {
                return
            }
            nVal = vObj.options[nSel - 1].value;
            nText = vObj.options[nSel - 1].text;
            vObj.options[nSel - 1].value = vObj.options[nSel].value;
            vObj.options[nSel - 1].text = vObj.options[nSel].text;
            vObj.options[nSel].value = nVal;
            vObj.options[nSel].text = nText;
            vObj.selectedIndex = nSel - 1
        }
    }
}

function makeNumber(b) {
    var d = "" + b;
    if (isNaN(d) || d == "") {
        return
    } else {
        var a = new RegExp("([0-9])([0-9][0-9][0-9][,.])");
        var c = d.split(".");
        c[0] += ".";
        do {
            c[0] = c[0].replace(a, "$1,$2")
        } while (a.test(c[0]));
        if (c.length > 1) {
            return c.join("")
        } else {
            return c[0].split(".")[0]
        }
    }
}

function init_end(a) {
    if (parent) {
        setTimeout("parent.ok_resize_iframe('" + a + "',1)", 300);
        setTimeout("parent.ok_resize_iframe('" + a + "',0)", 1000);
        setTimeout("parent.ok_resize_iframe('" + a + "',0)", 2000)
    }
}

function ok_resize_iframe(a, h) {
    try {
        var d = document.getElementById(a).contentDocument.body;
        var c = document.getElementById(a);
        var f = d.offsetHeight * 1;
        var b = d.scrollHeight * 1;
        if (f < b) {
            f = b
        }
        if (h == 1) {
            f = f + 30;
            c.style.height = f + "px"
        } else {
            if (f - c.style.height > 20) {
                c.style.height = f + "px"
            }
        }
    } catch (g) {
        try {
            var d = document.frames(a).document.body;
            var c = document.getElementById(a);
            var f = d.scrollHeight * 1;
            if (h == 1) {
                f = f + 20;
                c.style.height = f + "px"
            } else {
                if (f - c.style.height > 20) {
                    c.style.height = f + "px"
                }
            }
        } catch (g) {}
    }
}

function spam_str_list(b) {
    if (!b) {
        b = ""
    }
    var c = 500;
    var e = 600;
    var f = (screen.width - c) / 2;
    var a = (screen.height - e) / 2;
    var d = window.open("/admin/sub_marketing/sms_spam_str.htm", "spam_str_list_win", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function auto_chk(e, d, b) {
    if (!b) {
        b = ""
    }
    var c = document.getElementsByName(e);
    if (!c) {
        return
    }
    if (c[0].type == "radio" || c[0].type == "checkbox") {
        if (!c.length) {
            return
        }
        for (var a = 0; a < c.length; a++) {
            if (c[a].value == d) {
                c[a].checked = true;
                break
            }
        }
    } else {
        if (c[0].type == "select-one") {
            if (!c[0].length) {
                return
            }
            for (var a = 0; a < c[0].length; a++) {
                if (b) {
                    if (c[0][a].value == d && c[0][a].text == b) {
                        c[0][a].selected = true;
                        break
                    }
                } else {
                    if (c[0][a].value == d) {
                        c[0][a].selected = true;
                        break
                    }
                }
            }
        } else {
            if (c[0].type == "text") {
                c[0].value = d
            }
        }
    }
}

function auto_select(input_name, val) {
    var obj = eval("document.getElementById('" + input_name + "')");
    if (!obj) {
        return
    }
    if (!obj.length) {
        return
    }
    for (var i = 0; i < obj.length; i++) {
        if (obj[i].value == val) {
            obj[i].selected = true;
            break
        }
    }
}

function auto_select2(b, c) {
    if (!b.length) {
        return
    }
    for (var a = 0; a < b.length; a++) {
        if (b[a].value == c) {
            b[a].selected = true;
            break
        }
    }
}

function history_view(c, g) {
    var b = 730;
    var e = 650;
    var f = (screen.width - b) / 2;
    var a = (screen.height - e) / 2;
    var d = window.open("/admin/sub_design/history_list.htm?design_type=" + g + "&keyfield=subject&key=" + c, "history_view_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function md_money_add_pop() {
    var c = 600;
    var d = 500;
    var e = (screen.width - c) / 2;
    var a = (screen.height - d) / 2;
    var b = window.open("/admin/sub_md/md_money_add_form.htm", "md_money_add_pop_win", "top=" + a + ",left=" + e + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    b.focus()
}

function window_open(d, b, e) {
    if (!b) {
        b = 0
    }
    if (!e) {
        e = 0
    }
    var f = ((screen.width - b) / 2) - 100;
    var a = ((screen.height - e) / 2) - 100;
    if (f <= 0) {
        f = 0
    }
    if (a <= 0) {
        a = 0
    }
    var c = window.open(d, "", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    c.focus()
}

function popup_window(a, m, f, l, c) {
    if (!m) {
        m = 0
    }
    if (!f) {
        f = 0
    }
    if (!l) {
        l = 0
    }
    if (!c) {
        c = 0
    }
    var b = ((screen.width - m) / 2) - 100;
    var d = ((screen.height - f) / 2) - 100;
    if (c) {
        b = c
    }
    if (l) {
        d = l
    }
    if (b <= 0) {
        b = 0
    }
    if (d <= 0) {
        d = 0
    }
    var k = a;
    k = k.replace(/\//gi, "");
    k = k.replace(/\?/gi, "");
    k = k.replace(/\&/gi, "");
    k = k.replace(/\=/gi, "");
    k = k.replace(/\:/gi, "");
    k = k.replace(/\./gi, "");
    k = k.replace(/\%/gi, "");
    k = k.replace(/-/gi, "");
    if (m > 0 && f > 0) {
        var g = window.open(a, k, "top=" + d + ",left=" + b + ",width=" + m + ",height=" + f + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no")
    } else {
        var g = window.open(a, k)
    }
    try {
        g.focus()
    } catch (j) {}
}

function time_count(obj_name, h, m, s) {
    var obj = eval(obj_name);
    s--;
    if (s < 0) {
        if (m > 0) {
            s = 59;
            m--
        } else {
            if (h > 0) {
                s = 59;
                m = 59;
                h--
            } else {
                s = 0;
                m = 0;
                h = 0
            }
        }
    }
    var h_str, m_str, s_str;
    if (h < 10) {
        h_str = "0" + h
    } else {
        h_str = h
    }
    if (m < 10) {
        m_str = "0" + m
    } else {
        m_str = m
    }
    if (s < 10) {
        s_str = "0" + s
    } else {
        s_str = s
    }
    obj.innerHTML = "<font color='#009900'><b>" + h_str + " : " + m_str + " : " + s_str + "</b></font>";
    if (h > 0 || m > 0 || s > 0) {
        setTimeout("time_count('" + obj_name + "'," + h + "," + m + "," + s + ")", 1000)
    }
}

function dhms_count(obj_name, d, h, m, s) {
    var obj = eval(obj_name);
    s--;
    if (s < 0) {
        if (m > 0) {
            s = 59;
            m--
        } else {
            if (h > 0) {
                s = 59;
                m = 59;
                h--
            } else {
                if (d > 0) {
                    s = 59;
                    m = 59;
                    h = 23;
                    d--
                } else {
                    s = 0;
                    m = 0;
                    h = 0;
                    d = 0
                }
            }
        }
    }
    var d_str, h_str, m_str, s_str;
    if (d < 10) {
        d_str = "0" + d
    } else {
        d_str = d
    }
    if (h < 10) {
        h_str = "0" + h
    } else {
        h_str = h
    }
    if (m < 10) {
        m_str = "0" + m
    } else {
        m_str = m
    }
    if (s < 10) {
        s_str = "0" + s
    } else {
        s_str = s
    }
    obj.innerHTML = "<font color='#009900'><b>" + d_str + " : " + h_str + " : " + m_str + " : " + s_str + "</b></font>";
    if (d > 0 || h > 0 || m > 0 || s > 0) {
        setTimeout("dhms_count('" + obj_name + "'," + d + "," + h + "," + m + "," + s + ")", 1000)
    }
}

function GetCookie(d) {
    var b = d + "=";
    var f = b.length;
    var a = document.cookie.length;
    var e = 0;
    while (e < a) {
        var c = e + f;
        if (document.cookie.substring(e, c) == b) {
            return getCookieVal(c)
        }
        e = document.cookie.indexOf(" ", e) + 1;
        if (e == 0) {
            break
        }
    }
    return ""
}

function SetCookie(c, e) {
    var a = SetCookie.arguments;
    var h = SetCookie.arguments.length;
    var b = (2 < h) ? a[2] : null;
    var g = (3 < h) ? a[3] : null;
    var d = (4 < h) ? a[4] : null;
    var f = (5 < h) ? a[5] : false;
    document.cookie = c + "=" + escape(e) + ((b == null) ? "" : ("; expires=" + b.toGMTString())) + ((g == null) ? "" : ("; path=" + g)) + ((d == null) ? "" : ("; domain=" + d)) + ((f == true) ? "; secure" : "")
}

function ip_view(b) {
    var a = document.back_whoisFrm;
    a.domain_name.value = b;
    a.target = "_blank";
    a.action = "http://whois.nida.or.kr/result.php";
    a.submit()
}

function ip_conn_view(f) {
    var c = 1250;
    var d = 700;
    var g = (screen.width - c) / 2;
    var b = (screen.height - d) / 2;
    var a = "/admin/sub_marketing/connect_ajax_form.htm?file_code=connect_info_list&day_length=365&device_mode=all&conn_ip=" + f + "&ajax_yn=0";
    var e = window.open("/admin/main?url=" + escape(a), "", "top=" + b + ",left=" + g + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    e.focus()
}

function table_column_pop(d) {
    var b = 500;
    var c = 700;
    var f = (screen.width - b) / 2;
    var a = (screen.height - c) / 2;
    var e = window.open("/admin/sub_main/table_column_list.htm?table_mode=" + d, "table_column_pop_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + c + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    e.focus()
}

function ip_denial_on(b) {
    if (confirm("선택하신 IP주소를 [부정클릭IP] 로 등록 하시겠습니까?")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_main/ip_denial_exec.php?mode=on&ip=" + b
    }
}

function ip_denial_off(b) {
    if (confirm("선택하신 IP주소를 [부정클릭IP]에서 제외 하시겠습니까?")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_main/ip_denial_exec.php?mode=off&ip=" + b
    }
}

function lan_real_edit(b) {
    var c = 500;
    var d = 400;
    var f = (screen.width - c) / 2;
    var a = (screen.height - d) / 2;
    var e = window.open("/admin/sub_main/lts_form.htm?idx=" + b, "", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=yes");
    e.focus()
}

function doBlink() {
    var a = document.getElementsByTagName("blink");
    for (var b = 0; b < a.length; b++) {
        a[b].style.visibility = a[b].style.visibility == "" ? "hidden" : ""
    }
}

function startBlink() {
    if (document.getElementsByTagName("blink").length) {
        setInterval("doBlink()", 500)
    }
}
window.onload = startBlink;

function design_edit_mode(b) {
    if (b == "mobile") {
        if (confirm("모바일웹 디자인 수정 모드로 접속 하시겠습니까?")) {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_main/design_edit_mode_exec.php?mode=mobile"
        }
    } else {
        if (confirm("PC용 디자인 수정 모드로 접속 하시겠습니까?")) {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_main/design_edit_mode_exec.php?mode=pc"
        }
    }
}

function admin_mode_change(b) {
    if (b == 1) {
        if (confirm("운영 관리자모드로 접속 하시겠습니까?")) {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_main/admin_mode_change_exec.php?sel_mode=easy"
        }
    } else {
        if (confirm("고급 관리자모드로 접속 하시겠습니까?")) {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_main/admin_mode_change_exec.php?sel_mode=normal"
        }
    }
}

function admin_lan_change(b) {
    if (b == "jp") {
        if (confirm("일본어 관리자모드로 접속 하시겠습니까?")) {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_main/admin_lan_change_exec.php?sel_lan=jp"
        }
    } else {
        if (b == "ch") {
            if (confirm("중국어 관리자모드로 접속 하시겠습니까?")) {
                var a = create_iframe();
                document.getElementById(a).src = "/admin/sub_main/admin_lan_change_exec.php?sel_lan=ch"
            }
        } else {
            if (b == "en") {
                alert("준비중입니다.");
                return;
                if (confirm("영어 관리자모드로 접속 하시겠습니까?")) {
                    var a = create_iframe();
                    document.getElementById(a).src = "/admin/sub_main/admin_lan_change_exec.php?sel_lan=en"
                }
            } else {
                if (confirm("한국어 관리자모드로 접속 하시겠습니까?")) {
                    var a = create_iframe();
                    document.getElementById(a).src = "/admin/sub_main/admin_lan_change_exec.php?sel_lan=kr"
                }
            }
        }
    }
}

function tpl_file_download(b, d) {
    if (!b) {
        b = ""
    }
    if (!d) {
        d = ""
    }
    if (!b && !d) {
        alert("다운받을 파일을 선택해주세요.");
        return
    }
    if (confirm("다운받으시겠습니까?")) {
        if (MOBILE_CONN_YN) {
            var c = window.open("/admin/sub_admin/tpl_file_download.php?all_idx=" + b + "&shop_id=" + d, "download_win");
            c.focus()
        } else {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_admin/tpl_file_download.php?all_idx=" + b + "&shop_id=" + d
        }
    }
}

function program_file_download(c) {
    if (!c) {
        c = ""
    }
    if (!c) {
        alert("다운받을 파일을 선택해주세요.");
        return
    }
    if (confirm("다운받으시겠습니까?")) {
        if (MOBILE_CONN_YN) {
            var b = window.open("/admin/sub_program/psd_file_download.php?tpl_idx=" + c, "download_win");
            b.focus()
        } else {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_program/psd_file_download.php?tpl_idx=" + c
        }
    }
}

function mysite_file_download(e, d, b) {
    if (!e) {
        e = ""
    }
    if (!d) {
        d = ""
    }
    if (!b) {
        b = ""
    }
    if (!e || !d || !b) {
        alert("다운받을 파일을 선택해주세요.");
        return
    }
    if (confirm("다운받으시겠습니까?")) {
        if (MOBILE_CONN_YN) {
            var c = window.open("/admin/sub_community/mysite_edit_file_download.php?mode=" + e + "&ori_idx=" + d + "&num=" + b, "download_win");
            c.focus()
        } else {
            var a = create_iframe();
            document.getElementById(a).src = "/admin/sub_community/mysite_edit_file_download.php?mode=" + e + "&ori_idx=" + d + "&num=" + b
        }
    }
}

function program_sample_view(e, b, c) {
    if (!b) {
        b = 1150
    }
    if (!c) {
        c = 700
    }
    var f = (screen.width - b) / 2;
    var a = (screen.height - c) / 2 - 50;
    var d = window.open("/admin/sub_program/auto_login_out.php?tpl_idx=" + e, "sample_view_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + c + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function program_sample_view_m(e) {
    if (IE == true) {
        alert("익스플로어에서는 모바일버젼을 확인 할 수 없습니다.\n\n스마트폰의 QR코드 인식어플을 통해 체험하거나,\n\n파이어폭스, 크폼, 사파리등에서 체험하시기 바랍니다.")
    } else {
        var b = 400;
        var c = 550;
        var f = (screen.width - b) / 2;
        var a = (screen.height - c) / 2 - 50;
        var d = window.open("/admin/sub_program/auto_login_out.php?program_mobile_yn=1&tpl_idx=" + e, "sample_view_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + c + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
        d.focus()
    }
}

function card_receipt(f, j, b) {
    var c = 400;
    var e = 600;
    var g = (screen.width - c) / 2;
    var a = (screen.height - e) / 2;
    var d = window.open("/admin/sub_price/card_receipt.php?mode=" + f + "&y=" + j + "&idx=" + b, "card_receipt_win", "top=" + a + ",left=" + g + ",width=" + c + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function direct_tab_reg(c, d, b) {
    var a = create_iframe();
    document.getElementById(a).src = "/admin/sub_design/direct_tab_data_reg.php?page_type=" + c + "&direct_idx=" + d + "&msg_yn=" + b
}

function direct_tab_del(b) {
    var a = create_iframe();
    document.getElementById(a).src = "/admin/sub_design/direct_tab_data_del.php?list_idx=" + b
}

function direct_tab_del_all() {
    if (confirm("모든 탭을 삭제 하시겠습니까?")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_design/direct_tab_data_del_all.php"
    }
}

function shop_edit_board_list(c) {
    var a = 1200;
    var b = 700;
    var d = window.open("/admin/sub_admin/shop_edit_list.htm?search_type=1&search_shop_id=" + c, "", "width=" + a + ",height=" + b + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function shop_contract_list(d) {
    var b = 1200;
    var c = 700;
    var a = window.open("/admin/sub_admin/contract_list.htm?search_type=1&search_shop_id=" + d, "", "width=" + b + ",height=" + c + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    a.focus()
}

function shop_contract_view(c) {
    var a = 1200;
    var b = 700;
    var d = window.open("/admin/sub_admin/contract_form.htm?search_shop_id=" + c, "", "width=" + a + ",height=" + b + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function cash_reg_pop(e, c) {
    var b = 600;
    var f = 500;
    var g = (screen.width - b) / 2;
    var a = (screen.height - f) / 2;
    var d = window.open("/credite_cash/cash_reg_form.htm?solution_type=" + e + "&jumun_idx=" + c, "cash_reg_pop_win", "top=" + a + ",left=" + g + ",width=" + b + ",height=" + f + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function cash_view_pop(f, d, e) {
    var c = 600;
    var g = 500;
    var j = (screen.width - c) / 2;
    var b = (screen.height - g) / 2;
    var a = window.open("/credite_cash/cash_reg_result.htm?solution_type=" + f + "&cash_idx=" + e + "&jumun_idx=" + d, "cash_view_pop_win", "top=" + b + ",left=" + j + ",width=" + c + ",height=" + g + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    a.focus()
}

function checkSpace(a) {
    return "";
    if (a.search(/\s/) != -1) {
        return 1
    } else {
        return ""
    }
}

function email_chk(c) {
    if (c == "") {
        alert("이메일 주소를 입력하세요.");
        return false
    }
    var b = checkSpace(c);
    if (b != "") {
        alert("이메일 주소를 빈공간 없이 넣으세요.");
        return false
    }
    var a = /[-!#$%&'*+\/^_~{}|0-9a-zA-Z]+(\.[-!#$%&'*+\/^_~{}|0-9a-zA-Z]+)*@[-!#$%&'*+\/^_~{}|0-9a-zA-Z]+(\.[-!#$%&'*+\/^_~{}|0-9a-zA-Z]+)*/;
    if (!a.test(c)) {
        alert("이메일 형식이 잘못 되었습니다.");
        return false
    }
    if (c.length > 60) {
        alert("이메일 주소는 60자까지 유효합니다.");
        return false
    }
    return true
}

function OpenSendMemo() {
    if (MOBILE_CONN_YN) {
        var c = window.open("/admin/sub_member2/spaper_form1.htm", "OpenSendMemo_win");
        c.focus()
    } else {
        var b = 500;
        var d = 450;
        var e = (screen.width - b) / 2;
        var a = (screen.height - d) / 2;
        var c = window.open("/admin/sub_member2/spaper_form1.htm", "OpenSendMemo_win", "top=" + a + ",left=" + e + ",width=" + b + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
        c.focus()
    }
}

function tax_all_info(b) {
    if (MOBILE_CONN_YN) {
        var e = window.open("/admin/sub_community/tax_list.htm?page=1&order_type=1&ok_chk=all&vKeyType=3&&keyfield=reg&key=" + b, "tax_all_info_win");
        e.focus()
    } else {
        var c = 1100;
        var d = 650;
        var f = (screen.width - c) / 2;
        var a = (screen.height - d) / 2;
        var e = window.open("/admin/sub_community/tax_list.htm?page=1&order_type=1&ok_chk=all&vKeyType=3&&keyfield=reg&key=" + b, "tax_all_info_win", "top=" + a + ",left=" + f + ",width=" + c + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
        e.focus()
    }
}

function tax_all_shop(c) {
    if (MOBILE_CONN_YN) {
        var e = window.open("/admin/sub_community/tax_list.htm?sub_id=" + c, "tax_all_info_win");
        e.focus()
    } else {
        var b = 1100;
        var d = 650;
        var f = (screen.width - b) / 2;
        var a = (screen.height - d) / 2;
        var e = window.open("/admin/sub_community/tax_list.htm?sub_id=" + c, "tax_all_info_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
        e.focus()
    }
}

function tax_reg(c) {
    if (MOBILE_CONN_YN) {
        var e = window.open("/admin/sub_community/tax_form.htm?sub_id=" + c, "tax_all_info_win");
        e.focus()
    } else {
        var b = 1100;
        var d = 650;
        var f = (screen.width - b) / 2;
        var a = (screen.height - d) / 2;
        var e = window.open("/admin/sub_community/tax_form.htm?sub_id=" + c, "tax_all_info_win", "top=" + a + ",left=" + f + ",width=" + b + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
        e.focus()
    }
}

function all_email_sel_chk(b, a) {
    if (a != null) {
        if (document.getElementById(b)) {
            document.getElementById(b).value = a
        }
    }
}

function job2_n0504_call_log(e, d, j) {
    if (!j) {
        j = 0
    }
    if (MOBILE_CONN_YN) {
        var b = window.open("/admin/sub_job2/n0504_call_log.htm?data_mode=" + e + "&data_idx=" + d + "&link_idx=" + j, "tax_all_info_win");
        b.focus()
    } else {
        var c = 900;
        var f = 650;
        var g = (screen.width - c) / 2;
        var a = (screen.height - f) / 2;
        var b = window.open("/admin/sub_job2/n0504_call_log.htm?data_mode=" + e + "&data_idx=" + d + "&link_idx=" + j, "", "top=" + a + ",left=" + g + ",width=" + c + ",height=" + f + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
        b.focus()
    }
}

function page_x_reload(a) {
    ok_frame.location.replace("about:blank");
    setTimeout("location.href='" + a + "';", 10)
}

function msg_go(b, a) {
    if (b) {
        alert(b)
    }
    if (a) {
        location.href = a
    }
}

function create_iframe(d, b) {
    if (!d) {
        d = 0
    }
    if (b) {
        var f = b
    } else {
        var c = Math.floor(Math.random() * 100000) + 1;
        var f = "ok_frame_" + c
    }
    var a = document.getElementById(f);
    var e;
    if (!a) {
        e = document.createElement("iframe");
        e.setAttribute("id", f);
        e.setAttribute("name", f)
    } else {
        e = a
    }
    if (d > 0) {
        e.style.width = "100px";
        e.style.height = d + "px"
    } else {
        e.style.width = "0px";
        e.style.height = "0px";
        e.style.display = "none"
    }
    if (!a) {
        document.body.appendChild(e)
    }
    window.frames[f].name = f;
    return f
}

function farm2_page_pop() {
    var b = (screen.width) - 100;
    var c = (screen.height) - 140;
    var e = 0;
    var a = 0;
    var d = window.open("/admin/sub_build/", "fram2_editor_win", "top=" + a + ",left=" + e + ",width=" + b + ",height=" + c + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    d.focus()
}

function farm_page_pop(g, e, f) {
    if (!g) {
        g = ""
    }
    if (!f) {
        f = ""
    }
    if (!e) {
        e = ""
    }
    var b = 1300;
    var d = 900;
    var j = (screen.width - b) / 2 - 50;
    var a = (screen.height - d) / 2 - 50;
    var c = window.open("/admin/sub_design/farm_user_form.htm?mpc=" + g + "&page_type=" + e + "&page_code=" + f, "", "top=" + a + ",left=" + j + ",width=" + b + ",height=" + d + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    c.focus()
}

function farm_decode(d, b, c) {
    if (confirm("소스 편집모드로 전환 하시겠습니까?\n\n소스 편집 모드로 전환시 더이상 디자인팜을 사용할수 없게 됩니다.")) {
        var a = create_iframe();
        document.getElementById(a).src = "/admin/sub_design/farm_user_cancel_exec.php?mpc=" + d + "&page_type=" + b + "&page_code=" + c
    }
}

function old_db_view(f, b) {
    var d = 900;
    var e = 700;
    var g = (screen.width - d) / 2 - 50;
    var a = (screen.height - e) / 2 - 50;
    var c = window.open("/admin/sub_design/_old_db_view.htm?mode=" + f + "&idx=" + b, "", "top=" + a + ",left=" + g + ",width=" + d + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    c.focus()
}

function admin_data_lan_pop(c) {
    var b = document.createElement("div"),
        d = document.createElement("div"),
        a = document.createElement("iframe");
    b.id = "data-lan-layer-popup";
    b.style.width = "500px";
    b.style.height = "480px";
    b.style.position = "fixed";
    b.style.top = "20%";
    b.style.left = "50%";
    b.style.zIndex = "100";
    b.style.marginLeft = "-250px";
    b.style.borderWidth = "1px";
    b.style.borderStyle = "solid";
    b.style.borderColor = "#dddddd";
    b.style.backgroundColor = "#ffffff";
    d.id = "data-lan-layer-popup-bg";
    d.style.position = "fixed";
    d.style.top = "0";
    d.style.bottom = "0";
    d.style.left = "0";
    d.style.right = "0";
    d.style.zIndex = "0";
    d.style.backgroundColor = "#000000";
    d.style.opacity = "0.5";
    a.style.width = "100%";
    a.style.height = "100%";
    a.style.border = "none";
    a.name = "data-lan-option";
    if (document.getElementById("data-lan-layer-popup") == null) {
        b.appendChild(a);
        a.src = "/admin/sub_all/admin_data_lan_form.htm?admin_data_lan=" + c;
        if (document.getElementById("Viewport")) {
            document.getElementById("Viewport").appendChild(b)
        }
        if (document.getElementById("Viewport")) {
            document.getElementById("Viewport").appendChild(d)
        }
    }
}

function data_lan_layer_close() {
    var a = window.parent.document.getElementById("data-lan-layer-popup"),
        b = window.parent.document.getElementById("data-lan-layer-popup-bg");
    a.parentNode.removeChild(a);
    b.parentNode.removeChild(b)
}

function first_key_log(g, c) {
    if (!g) {
        g = ""
    }
    if (!c) {
        c = ""
    }
    var d = 1200;
    var e = 800;
    var f = (screen.width - d) / 2;
    var b = (screen.height - e) / 2;
    var a = window.open("/admin/sub_marketing/connect_first_key_list.htm?first_key=" + g + "&mem_id=" + c, "", "top=" + b + ",left=" + f + ",width=" + d + ",height=" + e + ",toolbar=no,scrollbars=yes,resizable=yes,status=yes,menubar=no,location=no");
    a.focus()
}
var ajaxSave = null;

function admin_page_url(c, b, e) {
    if (!b || b != 0 && b != 1) {
        b = 0
    }
    if (c.indexOf("/admin/") == 0 || c.indexOf("/admin_gifticon/") == 0 || c.indexOf("/admin_agc/") == 0) {
        if (c.indexOf("ajax_yn") < 0) {
            if (c.indexOf("?") == -1) {
                c = c + "?ajax_yn=" + b
            } else {
                c = c + "&ajax_yn=" + b
            }
        }
        var d = window.location.search.substring(1);
        d = d.replace(/\%2F/g, "/").replace(/\%3F/g, "?").replace(/\%3D/g, "=").replace(/\%26/g, "&");
        if (d.indexOf("url") >= 0) {
            d = d.split("url=")[1]
        }
        if (c == d) {
            e = true
        }
        if (typeof history.pushState != "undefined") {
            if (!e) {
                var a = c.replace(/\?/g, "%3F").replace(/\=/g, "%3D").replace(/\&/g, "%26").replace(/\//g, "%2F");
                window.history.pushState({
                    page: c,
                    ajax_yn: b
                }, "Web", "/admin/main?url=" + a)
            }
            $("#admin_ajax_loading").addClass("on");
            $("#admin_frame_div").css("height", "0");
            if (b == 1) {
                $("#admin_frame_div").empty()
            }
            $("#admin_main_div").hide().empty()
        } else {
            b = 0
        }
        $("#admin_main_frame").stop().off("load");
        if (ajaxSave && ajaxSave.readyState != 4) {
            ajaxSave.abort()
        }
        if (b == 1) {
            setTimeout(function() {
                ajaxSave = $.ajax({
                    type: "GET",
                    crossDomain: false,
                    url: c,
                    async: false,
                    dataType: "html",
                    success: function(g) {
                        var f = $("<div>").append(g);
                        $("#admin_main_div").append(f.find("#Viewport"), f.find("footer"));
                        document.createElement("div");
                        if (f.find("script").length != 0) {
                            f.find("script").each(function(h, j) {
                                if ($("script[src*='" + $(this).attr("src") + "']").length == 0 && $(this)[0].textContent.indexOf("history.pushState") < 0) {
                                    if ($(this).attr("src")) {
                                        $("#admin_main_div").prepend($(this))
                                    } else {
                                        $("#admin_main_div").append($(this))
                                    }
                                } else {
                                    $(this).remove()
                                }
                            })
                        }
                        if (f.find("link").length != 0) {
                            f.find("link").each(function(h, j) {
                                if ($("link[src*='" + $(this).attr("href") + "']").length == 0) {
                                    $("#admin_main_div").prepend($(this))
                                } else {
                                    $(this).remove()
                                }
                            })
                        }
                        $("#admin_ajax_loading").removeClass("on");
                        $("#admin_main_div").show();
                        f.remove()
                    }
                })
            })
        } else {
            setTimeout(function() {
                if (typeof history.pushState != "undefined") {
                    if ($("#admin_frame_div").length != 0) {
                        var f = $("#admin_main_frame");
                        if (f.length == 0) {
                            f = $("<iframe>").attr({
                                width: "100%",
                                height: "100%",
                                frameborder: "0",
                                name: "admin_main_frame",
                                id: "admin_main_frame",
                                border: "0"
                            });
                            $("#admin_frame_div").append(f)
                        }
                        $("#admin_frame_div").css({
                            height: "100%",
                            "font-size": "0"
                        });
                        var g = true;
                        f.get(0).contentWindow.location.replace(c);
                        f.on({
                            load: function() {
                                if (g == false) {
                                    var h = $(this).get(0).contentWindow.location.pathname + $(this).get(0).contentWindow.location.search;
                                    if (h.indexOf("ajax_yn") == -1) {
                                        if (h.indexOf("?") == -1) {
                                            h = h + "?ajax_yn=0"
                                        } else {
                                            h = h + "&ajax_yn=0"
                                        }
                                    }
                                    window.history.pushState({
                                        page: h,
                                        ajax_yn: 0
                                    }, "Web", "/admin/main?url=" + escape(h))
                                } else {}
                                g = false;
                                $("#admin_ajax_loading").removeClass("on")
                            }
                        })
                    }
                } else {
                    location.href = "/admin/main?url=" + c + "&ieChk=1";
                    return false
                }
            })
        }
    } else {
        window.open(c)
    }
};