# 웹 서버 시작 및 테스트
* WebServer
   * 웹 서버를 시작하고, 사용자의 요청이 있을 때까지 대기 상태에 있다가 사용자의 요청이 있을 경우 받아서 RequestHandler에 작업을 위임하는 클래스이다.
   * ServerSocket에 사용자 요청이 발생하는 순간 클라이언트와 연결을 담당하는 Socket을 RequestHandler에 전달하면서 새로운 스레드를 실행하는 방식으로 멀티스레드 프로그래밍을 지원하고 있다.
* ServerSocket
   * Java에 포함되어 있는 클래스로 사용자 요청이 발생할 때까지 대기 상태에 있도록 지원하는 클래스
* RequestHandler
   * Thread를 상속하고 있으며, 사용자의 요청에 대한 처리와 응답에 대한 처리를 담당(<code>run()</code> 메서드가 담당)하는 클래스이다.

* WebServer를 실행한 후 브라우저에서 http://localhost:8080으로 접속해 "Hello World" 메시지가 출력되는지 확인한다.

### 요구사항 1 - http://localhost:8080/index.html로 접속시 응답
* index 페이지에 접근하면 '''Unchecked runtime.lastError: The message port closed before a response was received.''' 에러가 뜨는데 찾아보니까 크롬 확장프로그램들을 비활성화하면 된다는데 다 끄기 귀찮아서 그냥 한다.
* Header는 line 단위로 읽는다.
* 보통 <code>try { }</code> 으로 썼었는데 JDK7 부터는 <code>try (){ }</code>로 쓸 수 있는데 
  차이점은 일단 여기 코드에서 
  
  <pre>
  try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) { ~ }
  </pre>
  안에 있는 <code>InputStream</code>과 <code>OutputStream</code>이 try의 body 절이 끝나면 자동으로 자원을 <code>close()</code> 한다. 
  이게 가능한 이유는 <code>InputStream</code>과 <code>OutputStream</code>은 <code>Closeable</code>를 Implements를 하고있기 때문이다. 
  이외에도 이와 같이 자동으로 <code>close()</code>를 하고 싶으면 이 각각의 클래스 파일들이 <code>Closeable</code> 인터페이스를 implements 하고 있을때 이와 동일하게 사용할 수 있다.
  
* BufferedReader
  * readLine() : 값을 읽어올 때, String 값으로 개행문자를 포함해 한 줄을 전부 읽어온다. (Scanner메서드에서 nextLine()과 비슷)
  * read() : 값을 읽어올 때, int 값으로 변형하여 읽어온다. 
    * 예를들면
    * ~.txt에 1이라는 숫자가 저장되어 있는데 read()로 읽으면 int 형 숫자 1로 읽어오는 것이 아니라 txt형식으로 저장된 ASCII 형식의 문자값 '1'을 읽어오는 것이므로 int 값으로 49를 읽어온다.
    * 해결방법
      1. int a = br.read() - 48;  
       br.readLine();
       > ASCII 값에서 48을 뺀 뒤 엔터 값을 읽어온다.
      1. int a = integer.parseInt(br.readLine());
       > 엔터 값을 포함한 한 줄을 통째로 입력받은 뒤 int로 변환
### 요구사항 2 - get 방식으로 회원가입
* 

### 요구사항 3 - post 방식으로 회원가입
* QueryString은 HTTP 요청의 본문(body)을 통해 전달된다. POST 방식으로 데이터를 전달하면서 Header에 본문 데이터에 대한 길이가 Content-Length라는 필드 이름으로 전달 된다.

* <code>Header가 Key, Value 형태로 넘어오니까 split()을 한 후 Map에 저장한다. 그리고 IOUtils.readData()를 통해 본문을 읽어온ㄷ나.</code>

### 요구사항 4 - redirect 방식으로 이동
* > HTTP/1.1 302 Found  
    Location: /index.html 
* 302 Found 리다이렉트 상태 응답 코드는 클라이언트가 요청한 리소스가 Location 헤더에 주어진 URL에 일시적으로 이동되었음을 가리킨다.
* 302 Status code를 활용해서 페이지를 이동할 경우 요청과 응답이 한 번이 아니라 두 번 발생한다. 다음과 같은 과정이 일어난다. 
```
/user/create 요청 -> 회원가입 처리 -> /index.html로 302 응답
```
다시 재요청
```
/index.html 요청 -> /index.html 읽기 -> /index.html 200 응답
```
 > 302 Status code는 자바 웹개발에서 reponse.sendRedirect() 를 활용하면 똑같은 방식으로 작용하는데 내부적으로 302 Status code를 활용하는 것이다. (Location : ~~.~ 포함)  
 
 > 다른 웹 애플리케이션로 개발하면서 redirect 방식으로 페이지를 이동한다고 하면 내부적으로 302 Status code를 활용해서 이동하겠구나 하고 생각하면 됨.
 


* <code>FileInputStream, FileOutputStream</code>은 **byte[] 단위의 데이터**만 입/출력을 할 수 있다. (문자나 byte 형식의 문자) 그래서 다른 데이터를 읽어야 할 때 항상 데이터를 변환해줘야 한다. 
* <code>DataInputStream, DataOutputStream</code>은 자바 기본 자료형(char, int, long 등)으로 데이터를 입력하고 출력할 수 있다. 즉 데이터 입출력시 기본 자료형을 ByteStream으로 변환하여 파일입출력을 수행한다.
### 요구사항 5 - cookie
* Login을 성공하면 Server에서 Header에 Set-Cookie : logined=true 응답값을 보낸다. (Chrome 개발자도구 Network Tab에서 Cookies/Response Cookies에 보면 값이 보임)
* 다시 index.html로 재요청을 할 때 Request Cookies에 똑같이 logined=true를 담아서 다시 클라이언트에 보낸다. 이렇게 서버에서 클라이언트에게 Cookie 정보를 주면 브라우저는 Cookie를 인식을 해서 모든 요청에 대해서 Cookie를 담아서 서버에 보낸다.(css, favicon 등)
* 즉 Server에서 응답을 할 때 Set-Cookie:logined=true Cookie값을 보내면 Browser는 이 Cookie 값을 읽은 다음에 이 Browser는 Server에 재요청을 할 때 Set-Cookie:logined=true가 포함되도록 처리가 된다.

### 요구사항 6 - stylesheet 적용
* *.css 는 Content-type이 text/html 이 아니라 text/css라서 바꿔주기만 하면 됨

* String 클래스의 <code>trim()</code>은 문자열에 있는 왼쪽, 오른쪽 공백을 다 제거 해준다.
* <code>parseBoolean()</code> 객체 타입을 String -> Boolean 바꿔주는데 값이 null이 아니고 값이 "true" 인 경우에 boolean 타입으로 <code>true</code> 리턴해줌.(대/소문자 상관X)
  > 같지 않을 경우 항상 <code>false</code>를 리턴함
### heroku 서버에 배포 후
* 