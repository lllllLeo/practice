import React, { Component } from 'react';

class EventPractice extends Component {
    
    state = {
        message: ' '
    }

    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handleChange(e) {
        this.setState({
            message : e.target.value
        });
    }

    handleClick() {
        alert(this.state.message);
        this.setState({
            message : ' '
        });
    }

    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type="text"
                    name="message"
                    placeholder="아무거나 입력해보세요"
                    onChange= {this.handleChange}
                />
                <button onClick={this.handleClick}>입력해</button>
            </div>
        );
    }
}

export default EventPractice;


// {
//     (e) => { //e 객체는 SyntheticEvent로 웹 브라우저의 네이티브 이벤트를 감싸는 객체입니다. 네이티브 이벤트와 인터페이스가 같으므로 순수 자바스크립트에서 HTML 이벤트를 다룰 때와 똑같이 사용하면 됩니다.
//       this.setState({
//           message : e.target.value
//       })
//     }
//   } 