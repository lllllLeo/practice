 ## CharIOExample
 
 
 1. BufferedReader 클래스는 한 줄씩 입력 받기 위한 클래스이며 기본 생성자가 존재하지 않고 Reader 타입의 객체가 필요하다. 하지만 Reader 클래스는 추상 클래스이기 때문에 독립적으로 객체를 생성할 수가 없다. 이 경우에는 추상 클래스인 Reader를 상속받는 하위 클래스인 `InputStreamReader`를 통해 `BufferedReader` 의 생성자의 인자로 전달 할 수 있다.
  
 1. System.in 은 키보드로 입력한 값에 대한 InputStream 타입의 객체를 얻을 수 있다. BufferedReader 클래스의 생성자에는 InputStream을 입력받는 생성자가 없으므로 InputStreamReader 클래스를 이용해야 한다.
 
 *  결국 순서는 키보드에서 입력한 문자열은 키보드 버퍼에 저장해 두었다가 사용자가 입력을 마치면 JVM에 전달이되고 전달된 문자는 다시 System.in인 InputStream 객체로 저장되었다가 InputStreamReader 객체를 사용하는데 사용이 되고 BufferedReader 클래스로 부터 객체를 생성하는데 사용된다. BufferedReader에는 버퍼가 있으므로 문자열에 버퍼를 저장해 놓았다가 readline() 메소드를 이용한 한 줄씩 읽어 오는 것이다.
 * `Keyboard buffer -> inputStream -> InputStreamReader -> BufferedReader -> br.readLine()`
 
 * Buffer를 사용하는 이유는 문자를 효율적으로 입출력하여 CPU의 부하를 줄일 수 있기 때문이다.
 
 * `readLine()`
    * readLine()은 끝에 개행문자를 읽지 않는다.
    * 한줄을 읽는다. "\n", "\r"을 만날때 까지 읽어온다.
  
 ## Enum Class (enumeration) JDK1.5 ~
  * **enum** : 열거형
  * **열거형** : 서로 연관된 상수들의 집합  
  * **장점** : 
    1. 코드가 단순해지고 가독성이 좋음.
    1. 키워드가 enum이라서 구현의도가 열거형임을 명확히 할 수 있음.
    
  * **선언** : 다른 클래스들과 마찬가지로 새로운 `.java`, `Class 안`, `Class` 밖에 선언 가능
  * **열거형 선언** : 열거된 순서부터 index 값을 가짐. 대문자 사용
  ```
  public enum phone {
     GALAXY, IPHONE, DDONGPHONE        // 세미 콜론(;) 안붙임.
  }
  ```
  * 열거형 상수와 관련된 값과 선언 :
  ```
  YES("1", true)
  NO("0", false);   // 관련된 값을 지정 시 끝에 세미 콜론(;)을 붙여야함.
  ``` 
  * 메소드
    * `value()` : 열거된 모든 원소를 배열에 담아 순서대로 리턴
    * `ordinal()` : 원소에 연거된 순서를 정수 값으로 리턴
    * `valueOf(String arg)` : 매개변수로 넘어온 String 값과 열거형에 존재하는 이름을 갖는 원소를 리턴
 
  * enum의 생성자의 접근제어자가 private인 이유 :  
   enum타입은 고정된 상수들의 집합으로써, 런타임(run-time)이 아닌 컴파일타임(compile-time)에 모든 값을 알고 있어야 합니다. 즉 다른 패키지나 클래스에서 enum 타입에 접근해서 동적으로 어떤 값을 정해줄 수 없습니다. 따라서 컴파일 시에 타입안정성이 보장됩니다(해당 enum클래스 내에서 까지도 new키워드로 인스턴스 생성이 불가능하며 newInstance(), clone()등의 메소드도 사용 불가). 이 때문에 생성자의 접근제어자를 private으로 설정해야 합니다. 이렇게 되면 외부에서 접근 가능한 생성자가 없으므로 enum타입은 실제적으로 final과 다름이 없습니다. 클라이언트에서 enum의 인스턴스를 생성할 수 없고 상속을 받을 수도 없으므로, 클라이언트의 관점에서 보면 인스턴스는 없지만 선언된 enum 상수는 존재하는 셈입니다. 결국 enum타입은 인스턴스 생성을 제어하며, 싱글톤(singleton) 을 일반화합니다. 이러한 특성 때문에, enum타입은 싱글톤을 구현하는 하나의 방법으로 사용되기도 합니다.  
   http://www.nextree.co.kr/p11686/
   