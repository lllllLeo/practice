import React, { Component } from 'react';
import TodoItem from '../TodoItem';

class TodoList extends Component {
    shouldComponentUpdate(nextProps, nextState) {
        return this.props.todos !== nextProps.todos;
    }
    
    render () {
        const { todos, onToggle, onRemove } = this.props;
        const todoList = todos.map(
            todo => (
                <TodoItem
                  key={todo.id}
                  done={todo.done}
                  onToggle={() => onToggle(todo.id)}
                  onRemove={() => onRemove(todo.id)}>
                  {todo.text}
                </TodoItem>
            )
        )
// onToggle={() => onToggle(todo.id)}>  왜 이렇게 새로운 함수를 선언해서 하는거지 this머시기 때문인가
        return (
            <div>
                { todoList }
            </div>
        );
    }
}

export default TodoList;
