# 실습을 위한 개발 환경 세팅
* https://github.com/slipp/web-application-server 프로젝트를 자신의 계정으로 Fork한다. Github 우측 상단의 Fork 버튼을 클릭하면 자신의 계정으로 Fork된다.
* Fork한 프로젝트를 eclipse 또는 터미널에서 clone 한다.
* Fork한 프로젝트를 eclipse로 import한 후에 Maven 빌드 도구를 활용해 eclipse 프로젝트로 변환한다.(mvn eclipse:clean eclipse:eclipse)
* 빌드가 성공하면 반드시 refresh(fn + f5)를 실행해야 한다.

# 웹 서버 시작 및 테스트
* webserver.WebServer 는 사용자의 요청을 받아 RequestHandler에 작업을 위임하는 클래스이다.
* 사용자 요청에 대한 모든 처리는 RequestHandler 클래스의 run() 메서드가 담당한다.
* WebServer를 실행한 후 브라우저에서 http://localhost:8080으로 접속해 "Hello World" 메시지가 출력되는지 확인한다.

# 각 요구사항별 학습 내용 정리
* 구현 단계에서는 각 요구사항을 구현하는데 집중한다. 
* 구현을 완료한 후 구현 과정에서 새롭게 알게된 내용, 궁금한 내용을 기록한다.
* 각 요구사항을 구현하는 것이 중요한 것이 아니라 구현 과정을 통해 학습한 내용을 인식하는 것이 배움에 중요하다. 

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
### 요구사항 2 - get 방식으로 회원가입
* 

### 요구사항 3 - post 방식으로 회원가입
* QueryString은 HTTP 요청의 본문(body)을 통해 전달된다. POST 방식으로 데이터를 전달하면서 Header에 본문 데이터에 대한 길이가 Content-Length라는 필드 이름으로 전달 된다.

* <code>Header가 Key, Value 형태로 넘어오니까 split()을 한 후 Map에 저장한다. 그리고 IOUtils.readData()를 통해 본문을 읽어온ㄷ나.</code>

### 요구사항 4 - redirect 방식으로 이동
* > HTTP/1.1 302 Found  
    Location: /index.html 
* 302 Found 리다이렉트 상태 응답 코드는 클라이언트가 요청한 리소스가 Location 헤더에 주어진 URL에 일시적으로 이동되었음을 가리킨다.
* 302 Status code를 활용해서 페이지를 이동할 경우 요청과 응답이 한 번이 아니라 두 번 발생한다. 여기서는 
```
/user/create 요청 -> 회원가입 처리 -> /index.html로 302 응답
```
후
```
/index.html 요청 -> /index.html 읽기 -> /index.html 200 응답
```
 > 302 Status code는 자바 웹개발에서 reponse.sendRedirect() 를 활용하면 똑같은 방식으로 작용하는데 내부적으로 302 Status code를 활용하는 것이다. (Location : ~~.~ 포함)  
 
 > 다른 웹 애플리케이션로 개발하면서 redirect 방식으로 페이지를 이동한다고 하면 내부적으로 302 Status code를 활용해서 이동하겠구나 하고 생각하면 됨.


* <code>FileInputStream, FileOutputStream</code>은 **byte[] 단위의 데이터**만 입/출력을 할 수 있다. (문자나 byte 형식의 문자) 그래서 다른 데이터를 읽어야 할 때 항상 데이터를 변환해줘야 한다. 
* <code>DataInputStream, DataOutputStream</code>은 자바 기본 자료형(char, int, long 등)으로 데이터를 입력하고 출력할 수 있다. 즉 데이터 입출력시 기본 자료형을 ByteStream으로 변환하여 파일입출력을 수행한다.
### 요구사항 5 - cookie
* 

### 요구사항 6 - stylesheet 적용
* 

### heroku 서버에 배포 후
* 