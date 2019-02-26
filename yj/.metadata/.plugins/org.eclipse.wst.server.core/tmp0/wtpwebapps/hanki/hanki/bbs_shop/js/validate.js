/* validate 관련 함수 */

// FORM FIELD CHECK 1. NULL CHECK
function on_focus(this_input){
	if(this_input.readOnly == false){
		this_input.style.backgroundColor = "#FFFF66";
		this_input.select();
	}
}

function on_blur(this_input){
	if(this_input.readOnly == false){
		this_input.style.backgroundColor = "#ffffff";
	}
}

function dddddd(input,val){
	if(input.type == 'hidden'){
		input.value = val
	}else if(input.type == 'button' || input.type == 'submit'){
		input.value = val
		input.disabled = true ;
	}else if(input.type == 'select-one'){
		input.style.backgroundColor = "#dddddd";
		input.disabled = true ;
	}else{		
		input.style.backgroundColor = "#dddddd";
		input.value = val
		input.disabled = true ;
	}
}
function ffffff(input,val){
	if(input.type == 'hidden'){
		input.value = val
	}else if(input.type == 'button' || input.type == 'submit'){
		input.value = val
		input.disabled = false ;
	}else if(input.type == 'select-one'){
		input.style.backgroundColor = "#ffffff";
		input.disabled = false ;
	}else{		
		input.style.backgroundColor = "#ffffff";
		input.value = val
		input.disabled = false ;
	}
}

function checkNull(oField, strMsg, blnFocus){
	
	var isNotNull = false;
	var fieldType = null;
	var mainField;

	
	if (typeof(oField.type) == 'undefined' && typeof(oField.length) != 'undefined')
		mainField = oField[0];
	else
		mainField = oField;

	fieldType = mainField.type;


	switch (fieldType)
	{
		case "text" :
		case "password" :
		case "file" :
		case "hidden" :
			isNotNull = hasValue(oField);
			break;
		case "textarea" :
			isNotNull = hasEditerValue(oField);
			break;
		case "checkbox" :
		case "radio" :		
			isNotNull = isChecked(oField);
			break;		
		case "select-one" :
		case "select-multiple" :
			isNotNull = isNotSelected(oField);
			break;
	}
	
	if (!isNotNull)
	{
		alert(strMsg);
		if (blnFocus == true)
		{
			mainField.focus();
		}
	}
	
	return isNotNull;
}

function hasValue(oField)
{
	if (oField.value.replace(/(^\s*)|(\s*$)/g, "") == "")
		return false;
	else
		return true;
}

function hasEditerValue(oField)
{
	if (oField.value.replace(/&nbsp;/g, " ").replace(/(^\s*)|(\s*$)/g, "") == "")
		return false;
	else
		return true;
}

function isChecked(oField)
{	
	var checked = false;

	if (typeof(oField.length) != 'undefined')
	{
		for (var i=0; i<oField.length; i++)
			if (oField[i].checked)
				checked = true;
	}
	else
	{
		checked = oField.checked;
	}
	
	return checked;
}

function isNotSelected(oField)
{
	if (oField.selectedIndex == -1)
	{
		return false;
	}
	else
	{
		if (oField.value == -1)
			return false;
		else
			return true;
	}
}
// FORM FIELD CHECK 2. LENGTH CHECK
function checkLength(oField, min, max, strMsg, blnFocus)
{
	var isValid = false;
	var len_value = oField.value.length;
	
	if (min < 0)
	{
		if (len_value < max)
			isValid = true;
	}
	if (max < 0)
	{
		if (len_value > min)
			isValid = true;
	}
	if (min >= 0 && max >= 0)
	{
		if (len_value >= min && len_value <= max)
			isValid = true;
	}
		
	if (!isValid)
	{
		alert(strMsg);
		if (blnFocus == true)
			oField.focus();
	}
	
	return isValid;
}
// FORM FIELD CHECK 3. LENGTH CHECK (INCLUDE KOREAN)
function checkLengthKor(oField, min, max, strMsg, blnFocus)
{
	var isValid = false;
	var len_value = oField.value.bytes();
	
	if (min < 0)
	{
		if (len_value < max)
			isValid = true;
	}
	if (max < 0)
	{
		if (len_value > min)
			isValid = true;
	}
	if (min >= 0 && max >= 0)
	{
		if (len_value >= min && len_value <= max)
			isValid = true;
	}
		
	if (!isValid)
	{
		alert(strMsg);
		if (blnFocus == true)
			oField.focus();
	}
	
	return isValid;
}

function getCheckedIndex(oField) // for radio button
{
	var index = -1;

	for(i=0; i < oField.length; i++) {
		if(oField[i].checked) {
			index = i;
			break;
		}
	}

	return index;
}

function getCheckedValue(oField) // for radio button
{
	var value = null;

	for(i=0; i < oField.length; i++) {
		if(oField[i].checked) {
			value = oField[i].value;
			break;
		}
	}

	return value;
}

function radioCheck(oField, paramValue) // for radio button
{
	for (var i=0; i<oField.length; i++) {
		if (oField[i].value == paramValue) {
			oField[i].checked = true;
			break;
		}
	}
}

function getSelectedValue(oField) // for select button
{
	var value = null;

	selectedIndex = oField.selectedIndex;

	value = oField[selectedIndex].value;

	return value;
}

function strLenCk(str)
{
  var len = 0;
  for (var i=0;i<str.length; i++) {
    var n = str.charCodeAt(i);
    if ((n>= 0)&&(n<256)) {
      len ++;
    } else {
      len += 2;
	}
  }
  return len;
}
function strLenCnt(str,lengths)	//문자열의 특정 길이를 반환한다.
{
  var len = 0;
  var newStr = '';
  
  for (var i=0;i<str.length; i++) {
    var n = str.charCodeAt(i);
    var nv = str.charAt(i);
    if ((n>= 0)&&(n<256)) {
      len ++;
    } else {
      len += 2;
	}

	if (len>lengths)
		break;
	else
		newStr = newStr + nv;
  }

  return newStr;
}
function strCutPrint(str,byteLength) {	 //몇글자 이상 되면 ..을 붙여준다.
	var strOld = str;
	str = strLenCnt(str,byteLength);
	if (str!=strOld) {
		str = str+'..';
	}
	return str;
}
function strCutPrintT(obj,byteLength) {	 //몇글자 이상 되면 ..을 붙여준다. textarea로부터 불러오기
	var str = '';
	str = obj.value;
	var strOld = str;
	str = strLenCnt(str,byteLength);
	if (str!=strOld) {
		str = str+'..';
	}
	return str;
}

function hasWrongWord(str, wrongStr)
{
	if(str.indexOf(wrongStr) >= 0) return true;
	else return false;
}
// FORM FIELD CHECK 4. WRONG CHAR CHECK (특정문자가 포함되어 있으면 false)
function checkWrongWord(oField, wrongStr, strMsg) // for text and textbox
{
	var isWrong = false;
	var fieldType = null;
	var mainField;
	
	if (typeof(oField.type) == 'undefined' && typeof(oField.length) != 'undefined')
		mainField = oField[0];
	else
		mainField = oField;
	fieldType = mainField.type;

	switch (fieldType)
	{
		case "text" :
		case "textarea" :
			isWrong = hasWrongWord(oField.value, wrongStr);
			break;
	}
	
	if (isWrong)
	{
		alert(strMsg);
		array = mainField.value.split(wrongStr);
		result = '';
		for(i=0; i<array.length; i++) {
			result += array[i];
		}
		mainField.value = result;
		mainField.focus();
	}
	
	return !isWrong;
}
// FORM FIELD CHECK 5. ALPHA NUMERIC CHARACTER CHECK (영문 소문자와 숫자로만 되어 있으면 true)
function checkAlphaNum(oField, strMsg, blnFocus) // for text and textbox
{
	var isAlphaNum = false;
	var fieldType = null;
	var mainField;
	
	if (typeof(oField.type) == 'undefined' && typeof(oField.length) != 'undefined')
		mainField = oField[0];
	else
		mainField = oField;
	fieldType = mainField.type;

	switch (fieldType)
	{
		case "text" :
		case "textarea" :
			isAlphaNum = isLowAlphaNumCheck(oField.value);
			break;
	}
	
	if (!isAlphaNum)
	{
		alert(strMsg);
		if (blnFocus == true)
			mainField.focus();
	}
	
	return isAlphaNum;
}

function isLowAlphaNumCheck(arg_v)
{
	if (arg_v.match(/^[a-z0-9]*$/g)) return true;
	else return false;
}

function isAlphaNumCheck(arg_v)
{
	var alpha_num_Str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	for (i=0; i < arg_v.length; i++)
	{
		var substr = arg_v.substring(i, i+1);		
		if (alpha_num_Str.indexOf(substr) < 0) 
			return false;	
		
	}
	
	return true;
}

// 숫자 체크
function isNumber(arg) {
	for (i =0 ; i < arg.length; i++) {
  	
	  	if (arg.charCodeAt(i) < 48 || arg.charCodeAt(i) > 57) {
	  		return false;
	  	}
	}
	return true;
}
// FORM FIELD CHECK 6. SPECIAL CHARACTER CHECK (특수문자 하나도 없어야 true)
function checkNotSpecialChar(oField, strMsg, blnFocus) // for text and textbox
{
	var notSpecialChar = false;
	var fieldType = null;
	var mainField;
	
	if (typeof(oField.type) == 'undefined' && typeof(oField.length) != 'undefined')
		mainField = oField[0];
	else
		mainField = oField;
	fieldType = mainField.type;

	switch (fieldType)
	{
		case "text" :
		case "textarea" :
			notSpecialChar = hasNotSpecialChar(oField.value);
			break;
	}
	
	if (!notSpecialChar)
	{
		alert(strMsg);
		if (blnFocus == true)
			mainField.focus();
	}
	
	return notSpecialChar;
}

// 특수문자 체크 (특수문자 하나도 포함되어 있지 않으면 true)
function hasNotSpecialChar(id_text)
{
		//var specialchar = '~`!@#$%^&*()-_=+\|<>?,./;:"';
		var specialchar = '`@#$%&\|<>;"';

		var i ; 
		for ( i=0; i < id_text.length; i++ )  {
			if( specialchar.indexOf(id_text.substring(i,i+1)) > 0) {
				break ; 
			}
		}
		if ( i != id_text.length ) {
			return false ; 
		}
		else{
			return true ;
		} 

		return false;
}

// 한글로만 되어있는지 체크 (한글외의 다른 글자가 있으면 true, 한글로만 되어 있어야 false)
function isNotOnlyKorean(id_text){
	for ( var i=0; i < id_text.length; i++ ) {
		if ( id_text.charCodeAt(i) < 0xAC00 || id_text.charCodeAt(i) > 0xD7A3){
			if (( id_text.charCodeAt(i) < 12593 || id_text.charCodeAt(i) > 12643 ) && ( id_text.charCodeAt(i) != 32)) {
				return true;
			}
		}
	}	
	return false;
}

function keydownEngNum() {			//keydown시에 영어와 숫자만 먹는 것.
	if (!(event.keyCode>=48&&event.keyCode<=57)&&!(event.keyCode>=65&&event.keyCode<=90)&&event.keyCode!=9&&event.keyCode!=8&&event.keyCode!=46&&event.keyCode!=37&&event.keyCode!=39&&event.keyCode!=45) {
		event.keyCode = 0;
		event.cancelBubble = true;
		event.returnValue = false;
	}
}

function notInMSIE5(functionnm) {		//브라우저가 5.0이면 함수를 호출하지 않는다.
	if (navigator.userAgent.indexOf("MSIE 5")==-1)
	{
		eval(functionnm);
	}
}


function checkSpace( str ) // 공백이 있다면 1을 반환한다.
{
	return ''; // 익스10에서 에러나는 관계로 임시 처리

     if(str.search(/\s/) != -1){
     	return 1;
     }

     else {
         return "";
     }
}

function isHangul(s) //한글이 없다면 1을 반환한다.
{
     var len;
     
     len = s.length;

     for (var i = 0; i < len; i++)  {
         if (s.charCodeAt(i) != 32 && (s.charCodeAt(i) < 44032 || s.charCodeAt(i) > 55203))
             return 0;
     }
     return 1;
}
