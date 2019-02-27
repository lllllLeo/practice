 ## CharIOExample
 
 
 1. BufferedReader 클래스는 한 줄씩 입력 받기 위한 클래스이며 기본 생성자가 존재하지 않고 Reader 타입의 객체가 필요하다. 하지만 Reader 클래스는 추상 클래스이기 때문에 독립적으로 객체를 생성할 수가 없다. 이 경우에는 추상 클래스인 Reader를 상속받는 하위 클래스인 '''InputStreamReader'''를 통해 '''BufferedReader'''의 생성자의 인자로 전달 할 수 있다.
  
 1. System.in 은 키보드로 입력한 값에 대한 InputStream 타입의 객체를 얻을 수 있다. BufferedReader 클래스의 생성자에는 InputStream을 입력받는 생성자가 없으므로 InputStreamReader 클래스를 이용해야 한다.
 
 *  결국 순서는 키보드에서 입력한 문자열은 키보드 버퍼에 저장해 두었다가 사용자가 입력을 마치면 JVM에 전달이되고 전달된 문자는 다시 System.in인 InputStream 객체로 저장되었다가 InputStreamReader 객체를 사용하는데 사용이 되고 BufferedReader 클래스로 부터 객체를 생성하는데 사용된다. BufferedReader에는 버퍼가 있으므로 문자열에 버퍼를 저장해 놓았다가 readline() 메소드를 이용한 한 줄씩 읽어 오는 것이다.
 * Keyboard buffer -> inputStream -> InputStreamReader -> BufferedReader -> br.readLine()'''
 
 * Buffer를 사용하는 이유는 문자를 효율적으로 입출력하여 CPU의 부하를 줄일 수 있기 때문이다.
 
 * readLine()
    * readLine()은 끝에 개행문자를 읽지 않는다.
    * 한줄을 읽는다. "\n", "\r"을 만날때 까지 읽어온다.
  