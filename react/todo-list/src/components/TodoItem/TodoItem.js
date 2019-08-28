import React, { Component } from 'react';
import styles from './TodoItem.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);

class TodoItem extends Component {

    shouldComponentUpdate(nextProps, nextState) { // done일떄만 리랜더링
        return this.props.done !== nextProps.done;
    }

    render() {
        const {done, children, onToggle, onRemove} = this.props;
        /* 앞 코드에서는 비구조화 할당을 이용하여 this.props 안에 있는
       done, children, onToggle, onRemove 레퍼런스를 만들어 주었습니다.
       이렇게 하면 props를 사용할 때마다 this.props.onToggle, this.props.done처럼 
       매번 앞부분에 this.props를 붙이는 것을 생략할 수 있습니다.
       이렇게 레퍼런스를 만들면, 렌더링 함수 위쪽에서 이 컴포넌트가 
       어떤 props를 사용하는지 한눈에 볼 수 있으므로 매우 유용합니다.

       아래에 readOnly가 있는데 원래 readOnly=true 이런데 리액트에서 props를 설정할 떄 = 표시가
       생략되어 있으면 = {true}와 동일하다.

       delete에서 자식 onClick과 부모 onClick이 있는데 지우기 버튼을 누르면 onReove -> onToggle
       순으로 함수가 실행된다.
       -> propagation이라고 한다. 이를 방지하려면 자식 요소의 onClick 처리 함수 내부에서 e.stopPropagation
       함수를 호출해야 한다.
        */
        return(
            <div className={cx('todo-item')} onClick={onToggle}>
                <input className={cx('tick')} type="checkbox" checked={done} readOnly/>
                <div className={cx('text', {done})}>{children}</div>
                <div className={cx('delete')} onClick={(e) => {
                    onRemove();
                    e.stopPropagation();
                }
                }>[지우기]</div>
            </div>
        );
    }
}

export default TodoItem;