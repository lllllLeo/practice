
# React

Virtual DOM
 - Virtual DOM을 사용하여 기존 DOM과 비교를 해서 변화가 일어난 부분을 캐치해서 그 부분만 **Patch**함
 - React는 Virtual DOM을 성공적으로 도입한 사례. 이후 Vue 등 도 Virtual DOM을 사용함
 - https://www.youtube.com/watch?v=muc2ZF0QIO4&feature=youtu.be [참고영상]


Webpack
  - 코드들을 의존하는 순서대로  잘 합쳐서 하나 또는 여러 개의 파일로 결과물을 만들어낸다. 
  - 프로젝트를 만들 때 전체적으로 파일들을 관리해주는 도구

> 더 알아볼것


JavaScript 변수
 - `var`는 스코프가 함수 단위, ES6에서 더 이상 쓰지않음
 - `let`은 유동적인 값, 스코프가 블록 단위
 - `const`는 한번 선언 후 고정적인 값, 스코프가 블록 단위




---
## JSX

- style 작성
  - `-` 대신에 Camel Case적용.
  - JavaScript 상에서 style을 작성하는 것이기 때문에 자바스크립트처럼 작성이 가능하다.
  - `font-size : 37px;` -> `fontSize : '37px'` or `fontSize : 3+4+'px'`
---

- class
  - `class = "first"` -> `className = "first"`
  - `class = "first"` 이 방법은 지금은 동작은하지만 올바른 컨센션은 두번째 방법이니까 `className`을 사용하자
---

- 즉시 호출 함수
  1. function()
```javascript
   <div>
    {
        (function() {     
            if (value === 1) return <div>1이다!</div>
            if (value === 2) return <div>2다!</div>
            if (value === 3) return <div>3이다!</div>
        })()
    }
    </div>
```
  2. 화살표 함수
```javascript
    <div>
    {
        (() => {  // 화살표 함수 ES6
            if (value === 1) return <div>1이다!</div>
            if (value === 2) return <div>2다!</div>
            if (value === 3) return <div>3이다!</div>
        })()
    }
    </div>
```
---

- 컴포넌트를 만드는 방법
  1. class 를 통해서 만들 수 있다.
  2. 함수를 통해서 만들 수 있다.

---
- 주석
  1. Multi Line 주석에 중괄호로 감싼다.
  2. JSX 태그 사이에도 주석을 남길 수 있다. 
```javascript
    <div>
       {/* 1. Multi Line 주석. */}
     <h1
        somethig ="adsasdf" // 2. JSX 태그 사이에도 주석을 남길 수 있음
       >리액트</h1>
     </div>
```
---