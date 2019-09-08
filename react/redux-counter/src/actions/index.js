/* action 객체를 만드는액션 생성 함수들을 선언한다. (action creators).
여기에서 () => ({})은 function() { return { } } 와 동일한 의미
*/

import * as types from './ActionTypes';

// 카운터를 새로 만들 때 기본 색상을 받을 수 있도록 color가 파라미터로 설정
export const create = (color) => ({
    type: types.CREATE,
    color
});

// 맨 마지막 카운터를 삭제하기 때문에 따로 index 값이 주어지지 않음
export const remove = () => ({
    type : types.REMOVE
});

// increment, decrement, setColor 함수들은 어떤 카운터를 수정해야 할지 명시하려고 index 값을 파라미터로 받음
export const increment = (index) => ({
    type: types.INCREMENT
});

export const decrement = (index) => ({
    type: types.DECREMENT
});

// 다른 액션 생성자들과 달리 파라미터를 갖고 있다.

export const setColor = ({index, color}) => ({
    type : types.SET_COLOR,
    color
});