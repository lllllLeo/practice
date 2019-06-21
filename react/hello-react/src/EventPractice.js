import React, { Component } from 'react';

class EventPractice extends Component {
    
    state = {
        message: ' ',
        username: ' '
    }

    // 생성자 메소드에 정의하면 새 메소드를 만들때마다 수정해야한다. 화살표 메소드로 하기 ㄱㄱ
    // constructor(props) {
    //     super(props);
    //     this.handleChange = this.handleChange.bind(this);
    //     this.handleClick = this.handleClick.bind(this);
    // }

    // handleChange(e) {
    handleChange = (e) => {
        this.setState({
            [e.target.name] : e.target.value // [] 는 Key 값을 사용하는것
        });
    }

    // handleClick() {
    handleClick = () => {
        alert(this.state.username + ":" + this.state.message);
        this.setState({
            username : ' ',
            message : ' '
        });
    }

    handleKeyPress = (e) => {
        if(e.key === 'Enter') {
            this.handleClick();
        }
    }

    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type="text"
                    name="username"
                    placeholder="유저명"
                    value={this.state.username}
                    onChange={this.handleChange}
                    />
                <input
                    type="text"
                    name="message"
                    placeholder="아무거나 입력해보세요"
                    value={this.state.message}
                    onChange= {this.handleChange}
                    onKeyPress = {this.handleKeyPress}
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