import Counter from '../components/Counter';
import * as actions from '../actions';
import { connect } from 'react-redux';

// 13가지 색상 중 랜덤으로 선택하는 함수

export function getRandomColor() {
    const color = [
        '#495057',
        '#f03e3e',
        '#d6336c',
        '#ae3ec9',
        '#7048e8',
        '#4263eb',
        '#1c7cd6',
        '#1098ad',
        '#0ca678',
        '#37b24d',
        '#74b816',
        '#f59f00',
        '#f76707'
    ];

    // 0부터 12까지 랜덤 숫자
    const random = Math.floor(Math.random() * 13);

    // 랜덤 색상 반환
    return colors[random];
}

// mapStateToProps: store.getState() 결과 값인 state를 파라미터로 받아 
// 컴포넌트의 props로 사용할 객체를 반환한다.

// store 안의 state 값을 props로 연결
const mapStateToProps = (state) => ({
    color: state.color,
    number: state.number
});


// mapDispatchToProps: dispatch를 파라미터로 받아 액션을 디스패치하는 함수들을 
// 객체 안에 넣어서 반환한다.

/* 액션 생성 함수를 사용하여 액션을 생성하고,
   해당 액션을 dispatch하는 함수를 만든 후 props로 연결
*/

const mapDispatchToProps = (dispatch) => ({
    onIncrement: () => dispatch(actions.increment()),
    onDecrement: () => dispatch(actions.decrement()),
    onSetColor: () => {
        const color = getRandomColor();
        dispatch(actions.setColor(color));
    }
});

// Counter 컴포넌트의 Container 컴포넌트
// Counter 컴포넌트를 애플리케이션의 데이터 레이어와 묶는 역할을 한다.
const CounterContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(Counter);

export default CounterContainer;

// mapStateToProps의 color 값, number 값과 
// mapDispatchToProps의 onIncrement 값, onDecrement 값, onSetColor 값이 
// Counter 컴포넌트의 props로 들어간다.