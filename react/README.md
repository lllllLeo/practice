
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

### ref
- 리액트 프로젝트 내부에서 DOM에 이름을 다는 방법
- **DOM을 꼭 직접적으로 건드려야 할 때** ref를 사용 
- ref는 전역적으로 작동하지 않고 컴포넌트 내부에서만 작동한다.

#### 컴포넌트에 ref
 - 컴포넌트 내부에 있는 DOM을 컴포넌트 외부에서 사용할 때 쓴다. 먼저 ref를 사용하지 않고도 원하는 기능을 구현할 수 있는지 꼭 고려한 후에 활용.
 - 서로 다른 컴포넌트끼리 데이터를 교류할 때 ref를 사용하면 안됨! 컴포넌트끼리 데이터를 교류할 때는 언제나 데이터를 부모 ↔ 자식 흐름으로 교류해야 함.

### 19/08/23 
 - 6장

 #### map / key / component
   - 컴포넌트 배열을 렌더링 할 때, key가 없을 경우에는 가상 DOM을 비교하는 과정에서 리스트를 순차적으로 비교하면서 변화를 감지한다. 근데 key가 있으면 이 값을 사용해서 어떤 변화가 일어났는지 더욱 빨리 감지할 수 있다.

 #### 배열
   - state를 수정할 때에는 setState()를 사용해야한다. 배열에서 값을 추가하기 위해 push()를 사용한다면 기존 배열 자체가 변형되므로 안됨. 자동 트리거가 실행이 안된다. 그래서 기존 배열을 직접 수정하지 않고, 기존 배열과 새 값을 합친 새 배열을 생성하는 concat()을 사용하면 된다.

 #### 전개 연산자 (spread operator)
   - ... 뒤에 위치한 배열 값을 그대로 꺼내서 현재 배열에 복사하는 것

 #### array.filter()
   - 배열에서 특정 조건을 만족하는 값들만 추출하여 새로운 배열을 만든다.

 #### 메모
   - IterationSample.js
   ```javascript
    onDoubleClick = {() => this.handleRemove(index)}>
   ```
   
   여기서 일반적으로 {this.handleRemove} 호출이 아닌 화살표 함수로 만든 이유는 `index` 값을 handleRemove()에 인자로 전달하기 위해서이다. 이처럼 우리가 만든 임의 메서드에 파라미터가 있을 때는 사용할 때 내부에서 함수를 새로 만들면 된다.

   - 상태 안에서 배열을 변형할 때는 배열에 직접 접근하여 수정하는 것이 아니라 `concat`, `slice`, 전개 연산자, `filter` 등을 사용해서 새로운 배열을 만든 후, setState 메서드로 적용한다.

---

 - 7장

 #### 라이프 사이클
   - 마운트
     - DOM이 생성되고 웹 브라우저상에 나타나는 것

   - 업데이트
     - 컴포넌트를 업데이트 하는 경우 4가지
       1. props가 바뀔 때
       2. state가 바뀔 때
       3. 부모 컴포넌트가 리랜더링될 때
       4. this.forceUpdate로 강제로 랜더링을 트리거할 떄

   - 언마운트
     - 컴포넌트를 DOM에서 제거하는 것

  ##### render()
    - 이 메서드 안에서 절대로 state를 변형해서는 안 되며, 웹 브라우저에 접근해서도 안 된다.
  
  #### constructor()
    - 컴포넌트의 생성자 메서드로 컴포넌트를 만들 때 처음으로 실행된다.
    - 초기 state를 정할 수 있다.
  
  #### getDerivedStateFromProps()
    - props로 받아 온 값을 state에 동기화 시키는 용도
    - 컴포넌트를 마운트하거나 props를 변경할 때 호출한다.
  
  #### componentDidMount()
    - 컴포넌트를 만들고, 첫 랜더링을 다 마친 후 실행
    - 이 안에서 다른 자바스크립트 라이브러리 또는 프레임워크의 함수를 호출하거나 이벤트 등록, setTimeout, setInterval, 네트워크 요청 같은 비동기 작업을 처리하면 된다.
  
  #### shouldComponentUpdate()
    - props나 state를 변경했을 떄, 리랜더링 시작여부를 지정하는 메소드
    - 반드시 true 값 또는 false 값을 반환해야 한다. 컴포넌트를 만들 때 이 메서드를 따로 생성하지 않으면 기본적으로 true를 반환하고 false를 반환하면 업데이트 과정은 여기에서 중지된다.

  #### getSnapshotBeforeUpdate()
    - render()를 호출한 후 DOM에 변화를 반영하기 직전에 호출하는 메서드
    - 주로 업데이트하기 직전의 값을 참고할 일이 있을 떄 활용(ex)스크롤바 위치 유지)
  
  #### componentDidUpdate()
    - 리랜더링을 완료한 후 실행됨.
    - 업데이트가 끝날 직후이므로, DOM 관련 처리를 해도 무방하다.

  #### componentWillUnmount
    - 컴포넌트를 DOM에서 제거할 때 실행
    - componentDidMount에서 등록한 이벤트, 타이머, 직접 생성한 DOM이 있다면 여기에서 제거 작업을 해야한다.

 #### 매모
   - 모든 리액트 컴포넌트에는 라이프사이클이 존재하는데 컴포넌트 수명은 페이지에 랜더링되기 전 준비 과정에서 시작하여 페이지에서 사라질 때 끝난다.
   - 라이프사이클 메서드는 컴포넌트 상태에 변화가 있을 떄마다 실행하는 메서드이다.


### 19/08/24

 #### 함수형 컴포넌트
   - 컴포넌트를 만들 때 마다 class를 만들고 ~~ 작업안해도 되고 만들 컴포넌트가 라이프사이클 API와 state를 사용할 필요가 없고, 오로지 props를 전달받아 뷰를 랜더링하는 역할만 한다면 컴포넌트를 더 간단하게 선언할 수 있다.
   - 함수형 컴포넌트는 컴포넌트에서 라이프사이클, state 등 불필요한 기능을 제거한 상태이기 때문에 메모리 소모량은 일반 클래스형 컴포넌트보다 적다.
   - 리액트 프로젝트에서는 state를 사용하는 컴포넌트 개수를 최소화하면 좋다. 따라서 컴포넌트를 만들 때는 대부분 함수형으로 작성하여 state를 사용하는 컴포넌트 개수를 줄이는 방향으로 하고, state나 라이프사이클 API를 꼭 써야 할 때만 클래스 형태로 변환하여 컴포넌트를 작성하면 된다.

 ```javascript
 import React from 'react';
 
 function Hello(props) {
   return (
     <div>Hello {props.name}</div>
   )
 }

 export default Hello;
 ```

 ES6
 ```javascript
 import React from 'react';

 const Hello = ({name}) => {
   return (
     <div>Hello {name}</div>
   )
 }

 export default Hello;
 ```

 #### CSS
   - css를 작성하다보면 클래스네임이 중복될 가능성이 있으니까 이를 방지하기 위해 앞에 컴포넌트 이름을 접두사로 붙여주는게 좋겠다. 
     - (App-header, App-intro)
   - .App .header { ... } 도 가능

### 컴포넌트 스타일링
 #### CSS Module
  - <div className={[styles.box, styles.blue].join(' ')}> 이렇게 하면 
  아래 처럼 됨
 <div class="src-App_-_box--mjrNr src-App_-_blue--3CWHK"></div>

  ##### classnames
  - 위보다 `yarn add classnames`로 라이브러리를 다운받으면 훨씬 쉽게 할 수 있다. 
    - classNames(클래스 이름1, 클래스 이름2) 으로 하면 위처럼 자동으로 사이에 공백을 넣어줌
      - <div className={classNames(styles.box, styles.blue)}>
    - classNames의 bind 기능
      - 객체 형식이나 배열 형식 또는 혼용해서 전달할 수도 있다.
    - 객체 형식으로 사용한다면 조건부 스타일링을 할 때 매우 편리하다.
      - 이 조건에 부합하는 값을 props로 받아와서 사용하면 동적으로 스타일 설정 가능
  
  #### Sass
   - sass-loader
     - webpack에서 Sass 파일을 읽어옴
   - node-sass
     - Sass로 작성된 코드들을 CSS로 변환한다.
   - nested구조, DOM 트리 구조대로 클래스 작성가능 -> 가독성, 편리함
   - 변수 사용 가능
     - `$size: 100px` 이렇게 작성해놓고 밑에서 값 적는 곳에 `$size`작성하면 됨
   - 믹스인 사용 (자주 사용하는 구문)
     - `mixin place-at-center() { ... }` 선언 후 사용 할 때는 `@include place-at-center();`

  #### styled-components
   - \\`\`\\ 사이에 `${자바스크립트 표현}`이 들어가면 끊어서 함수 인자로 전달한다. 이 표현을 안쓰면 문자열 그대로 감. 이를 사용하는 이유는 스타일링할 때 props에 접근하기 위해서이다.
   - 장점은 자바스크립트 내부에서 스타일을 정의하기 때문에 동적 스타일링이 더욱 편함
 
 #### 메모
   - `yarn eject`
     - node_modules/react-scripts 경로에 내장된 리액트 프로젝트의 환경설정 파일들을 프로젝트 루트 경로로 이동한다.
   
   - 경로설정
     **config/paths.js**에  파일에 해당 파일 경로 넣어주고
     ```javascript
     module.exports = {
      (...),
      styles: resolveApp(‘src/styles’)
     };
     ```

     **config/webpack.config.js**의 sass-loader 부분에
     ```javascript               
     {
      loader: require.resolve(‘sass-loader’),
      options: {
        includePaths: [paths.styles]  // 추가
       }
     }
     ```
     ~~왜 안대~~
   - npm 또는 yarn으로 설치한 패키지 내부에 있는 파일을 불러올 때는 `~` 문자를 사용해서 node_modules에 접근할 수 있다
     - `@import '~open-color/open-color';`

