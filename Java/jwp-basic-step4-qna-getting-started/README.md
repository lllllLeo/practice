# Ajax 활용해서 질/답게시판
---


## JQuery
`serialize()`
  - 표준 URL-encoded 표기법으로 텍스트 문자열을 만든다. 보통 `<form>`를 선택해서 직렬화 하는 방식으로 많이 사용. `<form>`의 자식으로 있는 `<input>`, `<textarea>`, `<select>` 와 같은 개별 요소들을 **쿼리스트링**으로 만들어준다.
  - `form`요소는 반드시 name 속성을 가지고 있어야 직렬화에 포함이 된다. checkbox, radio buttion은 선택된 요소만 포함이 됨. 
  - 단 type='file' 요소는 포함이 안됨!
 
 
 
              
### DeleteAnswerController.class
- 응답을 줄 때 따로 Result.class를 만들어서 ok, fail을 따로 만들어서 상태, 메시지 관리를 하고 리턴을 했구나.