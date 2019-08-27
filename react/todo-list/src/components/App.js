import React, { Component } from 'react';
import PageTemplate from './PageTemplate';
import TodoInput from './TodoInput';
import TodoList from './TodoList';

class App extends Component {
    state = {
        input: ' ',
        todos: [
            { id:0, text: '리액트 공부하기', done: true},
            { id:1, text: '컴포넌트 스타일링 해보기', done: false}
        ]
    }

    getId = () => {
        return ++this.id;
    }

    handleInsert = (e) => {
        const { todos, input } = this.state;

        const newTodo = {
            text: input,
            done: false,
            id: this.getId()
        };

        this.setState({
            todos: [...todos, newTodo],
            input: ' '
        });
    }

    handleChange = (e) => {
        const { value } = e.target;
        this.setState({
            input: value
        });
    }
    render() {
        const { input, todos } = this.state; // 비구조화 할당. 이렇게 하면 값을 사용할 때마다 this.props 또는 this를 참조하지 않아도 된다.
        const {
            handleChange,
            handleInsert
        } = this;
        return(
            <div>
                <PageTemplate>
                    <TodoInput onInsert={handleInsert} onChange={handleChange} value={input}/>
                    <TodoList todos={todos}/>
                </PageTemplate>
                
            </div>
        );
    }
}

export default App;