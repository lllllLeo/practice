import React, { Component } from 'react';
import PageTemplate from './PageTemplate';
import TodoInput from './TodoInput';
import TodoList from './TodoList';

const initialTodos = new Array(500).fill(0).map(
    (foo, index) => ({id: index, text: `일정 ${index}`, done: false})
);

class App extends Component {
    state = {
        input: ' ',
        todos: initialTodos,
    }

    getId = () => {
        return ++this.id;
    }

    handleRemove = (id) => {
        const { todos } = this.state;
        const index = todos.findIndex(todo => todo.id === id);

        console.log('handleRemove')
        this.setState({
            todos: [
                ...todos.slice(0, index),
                ...todos.slice(index + 1, todos.length)
            ]
        });
    }

    handleToggle = (id) => {
        const { todos } = this.state;
        const index = todos.findIndex(todo => todo.id === id);
        
        console.log('handleToggle')
        // 수정이니까 todos[index].done의 값을 !로 반전
        const toggled = {
            ...todos[index],
            done: !todos[index].done
        }

        this.setState({
            todos: [
                ...todos.slice(0, index),
                toggled,
                ...todos.slice(index+1, todos.length)
            ]
        });

    }

    handleInsert = (e) => {
        const { todos, input } = this.state;

        const newTodo = {
            text: input,
            done: false,
            id: this.getId()
        };
        console.log(this.getId());
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
            handleInsert,
            handleToggle,
            handleRemove
        } = this;
        return(
            <div>
                <PageTemplate>
                    <TodoInput onInsert={handleInsert} onChange={handleChange} value={input}/>
                    <TodoList todos={todos} onToggle={handleToggle} onRemove={handleRemove}/>
                </PageTemplate>
                
            </div>
        );
    }
}

export default App;