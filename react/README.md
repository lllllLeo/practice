
# React

Virtual DOM
 - Virtual DOM을 사용하여 기존 DOM과 비교를 해서 변화가 일어난 부분을 캐치해서 그 부분만 **Patch**함
 - React는 Virtual DOM을 성공적으로 도입한 사례. 이후 Vue 등 도 Virtual DOM을 사용함
 - 업데이트 처리 간결성
 - https://www.youtube.com/watch?v=muc2ZF0QIO4&feature=youtu.be [참고영상]

이벤트
 1. camelCase로 작성
   - HTML의 onclick는 리액트에서는 onClick으로 작성
 2. 이벤트를 실행할 함수 형태의 값을 전달
 3. DOM 요소에만 이벤트를 설정할 수 있다.
   - 우리가 직접 만든 컴포넌트에는 이벤트를 자체적으로 설정할 수 없다.

Webpack
  - 코드들을 의존하는 순서대로  잘 합쳐서 하나 또는 여러 개의 파일로 결과물을 만들어낸다. 
  - 프로젝트를 만들 때 전체적으로 파일들을 관리해주는 도구

> 더 알아볼것

 
JavaScript 변수
 - `var`는 스코프가 함수 단위, ES6에서 더 이상 쓰지않음
 - `let`은 유동적인 값, 스코프가 블록 단위
 - `const`는 한번 선언 후 고정적인 값, 스코프가 블록 단위
 - 기본적으로 const를 사용하고, 해당 값을 바꾸어야 할 때는 let을 사용하면 된다.

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
  1. Multi Line 주석에 { }로 감싼다.
  2. JSX 태그 사이에도 주석을 남길 수 있다. 
```javascript
    return (
      <div className=”my-div”>
        { /* 요소 밖에서는 이렇게 작성해요. */ }
        <h1>리액트 안녕!</h1>
        <h2>{text}</h2>
        { condition && ‘보여주세요’ }
        <div 
          style={style}
          // self-closed 태그에서만 작동하는 주석
          // 마지막 />가 꼭 새 줄에 있어야 합니다.
          /* 이렇게 작성할 수도 있고요. */
        />
        // 여기 쓰는 건 그대로 렌더링됩니다.
        /* 여기에선 주석 못 써요 */
      </div>
    );
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
- 모듈 내보내기  
 맨 밑줄에 있는 export default App;은 다른 파일에서 이 파일을 import할 때, 위쪽에서 선언한 App 클래스를 불러오도록 설정한다.

- propTypes
컴포넌트의 필수 props를 지정하거나 props 타입(type)을 지정할 때는 propTypes를 사용

- defaultProps와 propTypes는 꼭 사용해야 하나요?  
 이 두 가지 설정은 컴포넌트의 필수 사항은 아닙니다. 하지만 여러분이 React를 사용하여 꽤 큰 규모의 프로젝트를 진행한다면, 특히 다른 개발자와 협업을 한다면 해당 컴포넌트에 어떤 props가 필요한지 쉽게 알 수 있어 개발 능률을 올릴 수 있습니다.

---

#### State
 - 컴포넌트 내부에 처음부터 값을 들고 있음. **읽기, 변경가능**
 - state 초기값은 컴포넌트의 생성자 메서드인 constructor 내부에서 설정
 - 변화가 필요하면 컴포넌트 내장함수인 **setState()**로 변경. 값이 바뀔때마다 컴포넌트는 rerendering하는 트리거역할이다. setState()로 하지 않고 직접 바꾸게 된다면 rerendering을 하지 않는다. **this.forceUpdate()** 메서드를 호출하여 강제로 리렌더링을 시작할 수 있지만, 이 방식은 매우 비효율적이므로 웬만하면 사용을 피해야 합니다.


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
JSX는 리액트용으로 공식 자바스크립트 문법은 아니다.  
코드가 번들링되면서 babel-loader를 사용하여 자바스크립트로 변환한다.
> 번들링 : 모듈화된 코드를 한 파일로 합치는 것  

코드로 보면 XML형식이지만 실제로는 자바스크립트 객체이다.

- 조건부(삼항) 연산자
  - JSX안에서 if문을 사용할 수 없다. JSX 밖에서 if문을 사용하거나, { } 안에 조건부(삼항) 연산자를 사용하면 된다.

```javascript
import React, { Component } from ‘react’;

class App extends Component {
  render() {
    const text = ‘당신은 어썸한가요?’;
    const condition = true;

    return (
      <div>
        <h1>리액트 안녕!</h1>
        <h2>{text}</h2>
        {
          condition ? ‘참’ : ‘거짓’
        }
      </div>
    );
  }
}

export default App;
```
  - { condition **&&** ‘보여주세요’ }

---

- fragment
  - fragment를 import하여 사용
  - 불필요한 div를 랜더링하는 것 대신에 사용할 수 있다.

- style 작성
  - `-` 대신에 camelCase적용.
  - JavaScript 상에서 style을 작성하는 것이기 때문에 자바스크립트처럼 작성이 가능하다.
  - `font-size : 37px;` -> `fontSize : '37px'` or `fontSize : 3+4+'px'`
---

- class
  - `class = "first"` -> `className = "first"`
  - `class = "first"` 이 방법은 지금은 동작은하지만 올바른 컨센션은 두번째 방법이니까 `className`을 사용하자
---

- 보통 HTML코드는 코드를 닫지 않아도 웹 브라우저에서 보일 때 전혀 문제가 없다. 하지만 JSX에서 이렇게 작성하면, Virtual DOM에서 트리 형태의 구조를 만들지 못하기 때문에 오류가 발생하기 떄문에 코드를 꼭 닫아줘야 한다.

---

ref
- 리액트 프로젝트 내부에서 DOM에 이름을 다는 방법
- **DOM을 꼭 직접적으로 건드려야 할 때** ref를 사용 
- ref는 전역적으로 작동하지 않고 컴포넌트 내부에서만 작동한다.