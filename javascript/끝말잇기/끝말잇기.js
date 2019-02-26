var 바디 = document.body;
var 단어 = document.createElement('div');
단어.textContent = '유준';
// 이대로만하면 브라우저가 기억만한다
document.body.append(단어); // append해야 html에 추가가 됨
var 폼 = document.createElement('form');
document.body.append(폼);
var 입력창 = document.createElement('input');
document.폼.append(입력창);
var 버튼 = document.createElement('button');
버튼.textContent = '입력!';
document.append(버튼);
var 결과창 = document.createElement('div');
document.body.append(결과창);

폼.addEventListener('submit', function(e){ // function() 은 콜백함수 / 함수에 이름을 안붙여도 됨
    e.preventDefault(); // 기본 이벤트를 막는다.(form의 기본동작인 새로고침이 안됨)
    if(단어.textContent[단어.textContent.length-1] === 입력창.value){
        // alert('딩동댕');
        결과창.textContent ='딩동댕';
        단어.textContent = 입력창.value;
        입력창.value = '';
        입력창.focus();
    }else {
        결과창.textContent ='땡';
        입력창.value = '';
        입력창.focus();
    }
}); 

// 반복문을 이벤트 리스너로 대체한 셈이다.
// var word = '유준';
//
// while(true) {
//     var answer = prompt(word);
//     if(word[word.length-1] === answer[0]){
//         alert('딩동댕');
//         word = answer;
//     }else {
//         alert('땡');
//     }
// }