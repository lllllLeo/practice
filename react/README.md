
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

Props와 State
 - 리액트에서 데이터를 다룰때 사용되는 개념
 - Props는 부모 컴포넌트가 자식 컴포넌트에게 값을 전달할 때 사용


---

#### 즉시 호출 함수
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

#### 컴포넌트를 만드는 방법
  1. class를 통해서 만들 수 있다.
  2. 함수를 통해서 만들 수 있다.
    - Props를 사용할 때 딱히 기능이 없고 단순히 Props만 받아와서 보여주는 경우에는 Class를 통한 컴포넌트 대신 **함수형 컴포넌트**로 작성한다.
    - 초기 마운트 속도가 class를 이용하는 방법보다 미세하게 빠르다.
    - 불필요한 기능이 없기 떄문에 메모리 자원도 덜 사용한다.
    - 그런데 컴포넌트가 많이 없으면 큰 차이 없음

---
#### 주석
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

#### Props
  - 데이터를 다룰때 사용되는 개념
  - Props는 **부모 컴포넌트**가 **자식 컴포넌트**에게 **값**을 **전달**할 때 사용 // 자식 입장에서는 **읽기 전용**
  - 딱히 기능이 없고 단순히 Props만 받아와서 보여주는 경우에는 Class를 통한 컴포넌트 대신 **함수형 컴포넌트**로 작성한다.
  - 함수형 컴포넌트로 작성시 코드 상단에서 Component를 불러오지 않아도 된다.
  ---
  - Props에 값 넣어주기
  - Props에 Default 값 넣어주기

1. 함수형 컴포넌트
- **MyName.js**
```javascript
import React from 'react'; // Component 안불러도 됨

const MyName = ({ name }) => {
  return (
    <div>
      안녕하세요! 제 이름은 {name}입니다
    </div>
  )
};

MyName.defaultProps = {
  name : 'yujun'
};

export default MyName;
```


2. Class를 통한 컴포넌트
- **MyName.js**
```javascript
import React, { Component } from 'react';

class MyName extends Component {
   /* Props 기본값 지정방법1 
   (최신 JS의 문법, Babel이 코드를 변환하는 과정에서 밑처럼 아래로 내려줌) - Class내부에 static값 설정 */
  static defaultProps = {
    name : '기본이름'
  }
  render() {
    return (
      <div>
        안녕하세요! 제 이름은 <b>{this.props.name}</b>  {/* Props에 값 넣기 */}
      </div>
    )
  }
}
/* Props 기본값 지정방법2*/
MyName.defaultProps = {
  name: 'yujun'
};

export default MyName;
```

- **App.js**
```javascript
import React, { Component } from 'react';
import MyName from './MyName';

class App extends Component {
  render() {
    // return <MyName name = "리액트"/>; // Props에 값 넣어주기
    return <MyName/>;
  }
}

export default App;
```

---

#### State
 - 컴포넌트 내부에 처음부터 값을 들고 있음. **읽기, 변경가능**
 - 변화가 필요하면 컴포넌트 내장함수인 **setState()**로 변경. 값이 바뀔때마다 컴포넌트는 rerendering이 된다. setState()로 하지 않고 직접 바꾸게 된다면 rerendering을 하지 않는다.

---

#### 비구조화 할당
 - 변수 선언(var, let, const)없이 할당
 - 기분 구조 분해 할당과는 다르게 `()`로 묶어줘야함
```javascript
({ a, b} = { a : 10, b : 20});
console.log(a); // 10
console.log(b); // 20
```

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
