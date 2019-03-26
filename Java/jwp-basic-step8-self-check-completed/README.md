# 자바 리플렉션 Java Reflection
- 객체를 통해 클래스의 정보를 분석해 내는 프로그램 기법
- 자바 클래스 파일은 바이트 코드로 컴파일되어 static 영역에 위치하게 된다. 그래서 클래스 이름만 알고 있으면, 언제든 이 영역을 뒤져서 클래스에 대한 정보를 가져올 수 있다.
- 클래스의 타입을 몰라도 컴파일된 바이트 코드를 통해 역으로 클래스의 정보를 알아낼 수 있음(컴파일 타임에 클래스의 이름을 알 수 있으면)
- 투영, 반사 라는 사전적인 의미를 지님
- 클래스 이름, 메소드, 필드 등 클래스의 다양한 정보들을 알아볼 수 있다.
- 필드의 접근제어자가 private 인 경우에도 reflection으로 뽑을 수 있음

 - 리플렉션은  조합(Composition)과 함께 사용되어 다형성을 구현하는 강력한 도구이다. 조합을 사용하여 교체할 수 있는 
위임 클래스를 리플렉션을 통해 동적/정적으로 생성하고 교체하는 방식으로 사용된다.  프레임워크에서 유연성이 있는 동작을
위해 자주 사용되는 방식이기도 하다.   
-> 알아보기 
- `getFields()` : public만 뽑아옴
- `getDeclaredFields()`, `getDeclaredMethods()`, `getDeclaredConstructors()`하면 private, protected 도 뽑아옴
- `newInstance()` : 기본 생성자를 가지는 경우 인스턴스를 생성할 수 있음. 없으면 `class.newInstance()` 못함
- 인자가 있는 생성자는 `constructor.newInstance(Object... args)` 로 생성

#### localhost 1099 already in use
- cmd 창에서 `netstat –ano | findstr 1099` 해서 나오는 pid를 가지고 `taskkill /f /pid [pid숫자]` 하면 됨

