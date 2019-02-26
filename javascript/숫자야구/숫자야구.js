var 바디 = document.body;
var 숫자후보 = [1,2,3,4,5,6,7,8,9];
var 숫자배열 = [];

/*
 *  뽑을 때
 *   pop :   [9,9,9,9]
 *   shift : [1,2,3,4]
 *  넣을 때
 *   push
 *   unshift
 */
for(var i = 0; i < 4; i += 1){
    // 1~9가아니라 0~8 뽑아야하니까 ceil이 아니라 floor써야함
    // [0] 안하면 배열로 나옴
    var 뽑은것 = 숫자후보.splice(Math.floor(Math.random() * (9 - i)), 1)[0]; 
    숫자배열.push(뽑은것);
}
console.log(숫자배열);

var 결과 = document.createElement('h1');
바디.append(결과);

var 폼 = document.createElement('form');
document.body.append(폼);

var 입력창 = document.createElement('input');
입력창.type ='number';
폼.append(입력창);

var 버튼 = document.createElement('button');
버튼.textContent = '입력';
폼.append(버튼);


폼.addEventListener('submit', function 콜백함수 (){      // 엔터쳤을때


});

function Rectangle(length, width) {
    this.length = length;
    this.width= width;
}

Rectangle.prototype.getArea = function () {
    return this.length * this.width;
};

Rectangle.prototype.toString = function () {
    return "[Rectangle " + this.length + "x" + this.height + "]";
};

//Rectangle에서 상속한다

function Square(size) {
    Rectangle.call(this, size, size);
}

Square.prototype = Object.create(Rectangle.prototype , {
    constructor:{
        configurable: true,
        enumerable : true,
        value : Square,
        writable : true
    }
});

// 상위타입 메소드 호출

Square.prototype.toString = function () {
    var text = Rectangle.prototype.toString.call(this);
    return text.replace("Rectangle", "Square");
};




























