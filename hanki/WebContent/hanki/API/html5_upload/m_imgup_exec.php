
<textarea id='insert_html'>


</textarea>
<script>

function img_in(){

	var img_tag_str = document.getElementById('insert_html').value;

	try{
		// 실제 모바일웹 ....

		if(parent.parent.document.getElementById("_editor_mode")){

			if(parent.parent.document.getElementById("_editor_mode").value == 'ckeditor' ){

				var oEditor = top.opener.CKEDITOR.instances.;

				if ( oEditor.mode == 'wysiwyg' ){
					oEditor.insertHtml( img_tag_str );

				}else{
					alert("HTML 편집기 모드에서만 파일을 첨부 할 수 있습니다.");
					/*
					oEditor.execCommand( 'source' );

					alert('aa');
					var oEditor2 = top.opener.CKEDITOR.instances.;
					oEditor2.focus();
					oEditor2.insertHtml( img_tag_str );
					oEditor2.insertHtml( '머야 대췌~' );
					*/

				}

			}else if(parent.parent.document.getElementById("_editor_mode").value == 'source' ){

				//parent.parent.document.getElementById("").value = parent.parent.document.getElementById("").value+"<br>"+img_tag_str;
				//top.opener._codepress.edit('','javascript');

			}else if(parent.parent.document.getElementById("_editor_mode").value == "text"){
				parent.parent.document.getElementById("").value = parent.parent.document.getElementById("").value+"<br>"+img_tag_str;
			}
		}else{
			if(parent.parent.document.getElementById("")){
				parent.parent.document.getElementById("").value = parent.parent.document.getElementById("").value+"<br>"+img_tag_str;
			}else{
				parent.parent.document.getElementsByName("")[0].value = parent.parent.document.getElementsByName("")[0].value+"<br>"+img_tag_str;
			}
		}

		parent.parent.x_pop_window.close();

	}catch(e){
		// 관리자 모드에서 접속시...

		if(top.opener.document.getElementById("_editor_mode")){

			if(top.opener.document.getElementById("_editor_mode").value == 'ckeditor' ){

				var oEditor = top.opener.CKEDITOR.instances.;

				if ( oEditor.mode == 'wysiwyg' ){
					oEditor.insertHtml( img_tag_str );

				}else{
					alert("HTML 편집기 모드에서만 파일을 첨부 할 수 있습니다.");
					/*
					oEditor.execCommand( 'source' );

					alert('aa');
					var oEditor2 = top.opener.CKEDITOR.instances.;
					oEditor2.focus();
					oEditor2.insertHtml( img_tag_str );
					oEditor2.insertHtml( '머야 대췌~' );
					*/

				}

			}else if(top.opener.document.getElementById("_editor_mode").value == 'source' ){

				//top.opener.document.getElementById("").value = top.opener.document.getElementById("").value+"<br>"+img_tag_str;
				//top.opener._codepress.edit('','javascript');

			}else if(top.opener.document.getElementById("_editor_mode").value == "text"){
				top.opener.document.getElementById("").value = top.opener.document.getElementById("").value+"<br>"+img_tag_str;
			}
		}else{
			if(top.opener.document.getElementById("")){
				top.opener.document.getElementById("").value = top.opener.document.getElementById("").value+"<br>"+img_tag_str;
			}else{
				top.opener.document.getElementsByName("")[0].value = top.opener.document.getElementsByName("")[0].value+"<br>"+img_tag_str;
			}
		}

		top.close();
	}
}

window.onload = img_in;
</script>
