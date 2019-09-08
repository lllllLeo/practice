import * as types from '../actions/ActionTypes';

// 초기 상태를 정의
const initialState = {
    counters : [
        {
            color : 'black',
            number : 0
        }
    ]
};

function counter(state = initialState, action) {
    // 레퍼런스 생성
    // 자주 사용하는 state.counter 관련 코드양이 줄어들어서 깔끔해짐
    const { counters }= state;

    switch (action.type) {
        case types.CREATE:
            return {
                counters : [
                    ...counters,
                    {
                        color: action.color,
                        number: 0
                    }
                ]
            };
        case types.REMOVE:
            return {
                counters: counters.slice(0, counters.length - 1)
            };
        default:
            return state;
    }
}

export default counter;