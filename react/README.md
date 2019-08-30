
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
   - 함수를 호출하는 인자로 배열을 사용하고 싶을 때나 배열을 정의하는 리터럴 내에서 사용할 수 있다.
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


### 19/08/25

#### 메모
 - 아래에 readOnly가 있는데 원래 readOnly=true 이런데 리액트에서 props를 설정할 떄 = 표시가 생략되어 있으면 = {true}와 동일하다.


### 19/08/28

#### 메모
 - 리액트에는 부모 컴포넌트가 리렌더링되면 자식 컴포넌트도 리렌더링되는 속성이 있습니다. 여기에서도 App 컴포넌트가 리렌더링되면서 그 하위 컴포넌트들도 모두 리렌더링되었습니다. 작은 프로젝트에서 소규모 데이터만 다룰 때는 이 부분을 따로 최적화할 필요가 없겠지만, 규모가 크거나 커질 수 있는 프로젝트라면 불필요한 리렌더링은 막아야 합니다. 여기에서 우리가 논의하는 불필요한 리렌더링은 실제 웹 브라우저의 페이지에 나타난 DOM의 렌더링이 아니라 Virtual DOM에 하는 렌더링을 의미합니다.

 - shouldComponentUpdate()를 구현해야하는 상황은?
   1. 컴포넌트 배열이 랜더링되는 리스트 컴포넌트일 때
   2. 리스트 컴포넌트 내부에 있는 아이템 컴포넌트일 때
   3. 하위 컴포넌트 개수가 많으며, 리랜더링되지 말아야 할 상황에서도 리랜더링이 진행될 때

   > 리스트를 랜더링할 떄는 언제나 shouldComponentUpdate를 구현해 놓는 것을 습관화 하자. 그리고 나머지 경우에는 프로젝트를 작업하면서 버벅거린다고 느낄 때 성능 조사를 하고, 상황에 따라 shouldComponentUpdate를 구현
    

  #### Redux
   - 리액트에서 상태를 더 효율적으로 관리하는 데 사용하는 **상태 관리 라이브러리** / 상태 관리의 로직을 컴포넌트 밖에서 처리하는 것
     - 스토어 : 어플리케이션의 상태 값들을 내장하고 있다.
     - 액션 : 상태 변화를 일으킬 때 참조하는 객체
     - 디스패치 : 액션을 스토어에 전달하는 것을 의미
       - store.dispatch(increment(1));
     - 리듀서 : 상태를 변화시키는 로직이 있는 함수
     - 구동 : 스토어 값이 필요한 컴포넌트는 스토어를 구독

   > Todolist 플젝은 App.js에서 상태 관리 로직을 다 처리했는데 이렇게 되면 App 컴포넌트의 state를 업데이트 하면 App 컴포넌트가 리랜더링되고, 리액트의 특성상 하위 컴포넌트도 모두 리랜더링된다. 그래서 TodoInput만 업데이트하길 원해도 TodoList도 함께 리랜더링된다. 그래서 최적화가 필요하다.
   - action : store에서 상태 변화를 일으킬 때 참조하는 객체이다.
     - type의 값은 필수이다. 나머지는 선택

   - reducer : 액션의 type에 따라 변화를 일으키는 함수 / 상태에 변화를 일으키는 함수. 파라미터를 두 개 받는데, 첫 번쨰는 현재 상태(state), 두 번쨰는 액션 객체를 파라미터로 받는다.
   　　－리듀서가 초기에 사용할 초기 상태 initialState 값부터 먼저 설정해야 리듀서를 만들 수 있다.
       - 리듀서 함수에서 counter(state = initialState) 라고 되어있는데 ES6 문법으로, state 값이 undefined라면 initialState를 기본 값으로 사용한다는 의미이다.
       - 리덕스에서 상태를 업데이트할 때는 컴포넌트의 state를 다룰 때처럼 값을 직접 수정하면 안된다. 새로운 객체를 만든 후 그 안에 상태를 정의해야 한다.
       - Object.assign 함수를 실행하면 파라미터로 전달된 객체들을 순서대로 합쳐 준다. -> 새 객체를 만들어 줌
   - 리덕스 스토어를 구독한다는 것은 리덕스 스토어의 상태가 바뀔 때마다 특정 함수를 실행시킨다는 의미
   - subscribe() : 이 함수가 호출되면 반호나 값으로 구동을 취소하는 unsubscribe 함수를 반환한다. 나중에 구독을 취소해야 할 때는 unsubscribe()를 입력하여 호출하면 됨
   - getState() 함수는 현재 스토어 상태를 반환

   - store : 리액트에서 스토어를 생성할 때 보통 프로젝트의 엔트리 포인트인 `src/index.js`파일에서 만든다
   - store.dispatch(action); 을 하면 이 액션들이 디스패치될 때마다 구독할 때 등록했던 함수를 실행 함

     ```javasciprt
     const unsubscribe = store.subscribe(() => {
        console.log(store.getState()) //  <-
     });
     ```

   - Provider : react-redux 라이브러리에 내장된 리액트 어플리케이션에 손쉽게 스토어를 연동할 수 있도록 도와주는 컴포넌트이다.
     - Provicer 컴포넌트를 불러온 후 연동할 프로젝트의 최상위 컴포넌트(redux-counter프로젝트에서는 App컴포넌트)를 감싸고, Provider 컴포넌트의 props로 store를 넣어주면 된다

     ```javascript
       <Provider store={store}>
          <App/>
       </Provider>,
     ```

   ##### 리덕스의 세 가지 규칙
    1. 스토어는 언제나 단 한개이다.
      - 여러 개 생성해서 상태를 관리하면 안됨. 그 대신 리듀서를 여러 개 만들어서 관리할 수 있음.
    2. state는 읽기 전용이다. 
      - 리덕스의 상태, state 값은 읽기 전용이다. 값을 절대로 직접 수정하면 안된다. 그렇게 하면 리덕스의 구독 함수를 제대로 실행하지 않거나 컴포넌트의 리랜더링이 되지 않을 수도 있다.  
     상태를 업데이트할 떄는 언제나 새 상태 객체를 만들어서 넣어 줘야 한다. Object.assign을 사용한다고 해서 이전에 사용하던 객체들이 메모리에 누적되지는 않는다. 메모리 누수 걱정 ㄴㄴ. 상태 레퍼런스가 사라지면 자동으로 메모리 관리를 한다. 또 nested된 객체가 있을 때(여러 괄호로 감싼) 그 내부의 깊은 값까지 복사하는 것이 아니라, 객체 내부의 키 레퍼런스만 복사하므로 객체가 복잡하다고 해서 성능이 약화되지는 않는다.
    3. 변화는 순수 함수(reduce())로 구성
      - 모든 변화는 순수 함수로 구성해야 한다. 순수 함수에서 결과 값을 출력할 때는 파라미터 값에만 의존해야 하며, 같은 파라미터는 언제나 같은 결과를 출력해야 한다.  
      예를 들어 리듀서 함수 내부에서 외부 네트워크와 데이터베이스에 직접 접근하면 안 된다. 요청이 실패할 수도 있고, 외부 서버의 반환 값이 변할 수 있기 때문이다.  
      리듀서 함수 내부에서 현재 날짜를 반환하는 new Date() 함수나 Math.random() 함수 등도 사용하면 안된다.

 ### redux-counter project
  #### 프리젠테이셔널 컴포넌트
    - 오직 뷰만 담당한다.
    - DOM 엘리먼트와 스타일이 있으며, 프리젠테이셔널 컴포넌트나 컨테이너 컴포넌트가 있을 수도 있다. 하지만 리덕스 스토어에 직접 접근할 권한은 없으며, 오직 props로만 데이터를 가져올 수 있다.
    - 대부분은 state가 없다. 있다고 해도 데이터와 관련된 것이 아니라 UI와 관련된 것이어야 한다.
    - 주로 함수형 컴포넌트로 작성하며, state가 있어야 하거나 최적화를 하려고 라이프 사이클 메서드가 필요할 떄는 클래스형 컴포넌트로 작성된다.
  #### 컨테이너 컴포넌트
    - 프리젠테이셔널 컴포넌트들과 컨테이너 컴포넌트들의 관리를 담당한다.
    - 내부에 DOM 엘리먼트를 직접적으로 사용할 떄는 없고, 감싸는 용도일 때만 사용한다.
    - 스타일도 가지고 있지 않아야 한다. 스타일은 모두 프리젠테이셔널 컴포넌트에서 정의해야 한다.
    - 상태를 가지고 있을 때가 많으며, 리덕스에 직접 접근할 수 있다. 

 > 이 구조의 장점은 사용자가 이용할 유저 인터페이스와 상태를 다루는 데이터가 분리되어 프로젝트를 이해하기 쉽고, 컴포넌트 재사용률도 높다.


