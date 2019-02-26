var 숫자1 = Math.ceil(Math.random() * 9 );
var 숫자2 = Math.ceil(Math.random() * 9 );
var 결과 = 숫자1 * 숫자2;

var 바디 = document.body;
var 단어 = document.createElement('div');
단어.textContent = String(숫자1) + '곱하기' + String(숫자2) + '는?';
document.body.append(단어);
var 폼 = document.createElement('form');
document.body.append(폼);
var 입력창 = document.createElement('input');
폼.append(입력창);
var 버튼 = document.createElement('button');
버튼.textContent = '입력!';
폼.append(버튼);
var 결과창 = document.createElement('div');
document.body.append(결과창);

폼.addEventListener('submit', function(e){ // function() 은 콜백함수 / 함수에 이름을 안붙여도 됨
    e.preventDefault(); // 기본 이벤트를 막는다.(form의 기본동작인 새로고침이 안됨)
    if(결과 === Number(입력창.value)){
        결과창.textContent = '딩동댕';
        결과창.setTimeout(function(){결과창.empty();},3000);
        숫자1 = Math.ceil(Math.random() * 9 );
        숫자2 = Math.ceil(Math.random() * 9 );
        단어.textContent = String(숫자1) + '곱하기' + String(숫자2) + '는?';
        결과 = 숫자1 * 숫자2;
    }else{
        결과창.textContent = '땡';
        입력창.value = '';
        입력창.focus();
    }
});