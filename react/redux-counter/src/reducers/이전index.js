import color from './color';
import number from './number';

import { combineReducers } from 'redux';

// 최초 변화를 일으키기 전 가지고 있어야 할 초기값 정의
  //  initialState 함수

/* 리듀서 함수를 정의.
 리듀서는 state와 action을 파라미터로 받는다. state가 undefined일 때(스토어가 생성될 떄) state 기본 값을 initialState로 사용한다
 action.type에 따라 다른 작업을 하고, 새 상태를 만들어서 반환한다.
 이때 주의할 점은 state를 직접 수정하면 안 되고,
 기존 상태 값에 원하는 값을 덮어쓴 새로운 객체를 만들어서 반환해야 한다.

 ------------
 리듀서를 분리하면 서브 리듀서라고 한다. 만든 후에는 이를 통합시키는 루트 리듀서를 만들어야 한다.

*/

/* 서브 리듀서들을 하나로 합친다.
combineReducers를 실행하고 나면, 나중에 store 형태를 파라미터로 전달한 객체 모양대로 만든다.
지금은 다음과 같이 만듭니다.
{
    numberData: {
        number: 0
    },
    colorDate: {
        color: 'black'
    }
}
*/

const reducers = combineReducers({
    numberData: number,
    colorData: color
});

export default reducers;