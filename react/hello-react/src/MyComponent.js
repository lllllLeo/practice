import React, { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {

    // 방법1
    static propTypes = {
        name : PropTypes.string,
        age : PropTypes.number.isRequired // 필수적으로 존재해야 하며, 숫자이다.
    }

    // constructor(props) {
    //     super(props); // Component의 constructor 메서드를 먼저 호출해야 해서 super를 사용.
    //                  // 컴포넌트를 만들 때 props 값들을 사용하므로 props를 메서드의 파라미터로 전달합니다.
    //     this.state = {
    //         number: 0
    //     }
    // }
    
    /**
     * 원래 초기 state는 constructor 메서드에서 정의해야 하지만, defaultProps와 propTypes를 
     * 정의할 때 사용한 transform-class-properties 문법으로 constructor 바깥에서 정의할 수도 있습니다.
     */
    state = {
        number : 0
    }

    render() {
        return (
            <div>
                <p>안녕하세요, 제 이름은 {this.props.name} 입니다.</p>
                <p>저는 {this.props.age}살 입니다.</p>
                <p>숫자: {this.state.number}</p>
                <button onClick={() => {
                    this.setState({
                        number : this.state.number + 1
                    })
                }
            }>더하기</button>
            </div>
        );
    }
}

MyComponent.defaultProps = {
    name : '기본 이름'
}

// 방법2
MyComponent.propTypes = {
    name : PropTypes.string // name props 타입을 문자열로 설정한다.
}

export default MyComponent;