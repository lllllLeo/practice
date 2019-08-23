import React, { Component } from 'react';

class IterationSample extends Component {
    
    state = {
        names : ['눈사람', '얼음', '눈', '바람'],
        name : ' '
    };

    handleChange = (e) => {
        this.setState({
            name : e.target.value
        });
    }

    handleInsert = (e) => {
        // names 배열에 값을 추가하고, name 값을 초기화 한다.
        this.setState({
            names : this.state.names.concat(this.state.name),
            name : ' '
        });
    }

    handleRemove = (index) => {
        // 편의상 name의 레퍼런스를 미리 만든다. -> 왜지 뭐가 편하노
        const { names } = this.state;

        this.setState({
            names: names.filter((item, i) => i !== index) 
            // 여기서 조건을 i로 인덱스를 비교해서 하는데 item없이 하면 i가 요소 자리에 들어가서
            // 어쩔 수 없이 item,i 이렇게 (값, 인덱스)가 들어가는 거 같다. item은 따로 쓰지도 않고 
            // 나루호도

            // names : [
            //     ...names.slice(0, index),
            //     ...names.slice(index + 1, names.length)
            // ]
        });
    }
    
    render() {
        const nameList = this.state.names.map(
            (name, index) => (
            <li
              key = {index}
              onDoubleClick = {() => this.handleRemove(index)}>
              {name}
              </li>
            )
        );

    return (
        <div>
            <input
                onChange = {this.handleChange}
                value = {this.state.name}/>
            <button onClick = {this.handleInsert}>추가</button>
            <ul>
                {nameList}
            </ul>
        </div>
    );
  }
}

export default IterationSample;