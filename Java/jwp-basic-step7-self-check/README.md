#### 1. Tomcat 서버를 시작할 때 웹 애플리케이션이 초기화하는 과정을 설명하라.
### `ContextLoaderListener`
  - 서블릿 컨테이너는 웹 애플리케이션의 상태를 관리하는 `ServletContext`를 생성한다. *
  - `ServletContextListener` 인터페이스 구현체 중 `@WebListener` 애노테이션이 설정되어 있으면 서블릿 컨테이너를 시작하는 과정에서 `contextInitialized()` 를 호출해 초기화 작업을 진행함.   
  -> `web.xml`의 listener와 동일한 기능 (`web.xml`에 리스너 태그 등록)
  - `ServletContextListener` 에 대한 초기화는 서블릿 초기화보다 먼저 진행된다.
  - `ServletContextListener` 초기화는 웹 애플리케이션 전체에 영향을 미치는 초기화가 필요한 경우에 활용됨.
  - `ResourceDatabasePopulator` 로 SQL 스크립트 파일을 지정한다. (jwp.sql)
  - `DatabasePopulatorUtils.execute(populator, ConnectionManager.getDataSource())` 로 populator와 지정한 database의 dataSource를 얻어와서 connection을 생성한다.
   
 ### `DispatherServlet`
  - `contextInitialized`에서 초기화가 끝난 후 `DispatherServlet`에서 `init()`으로 초기화가 진행된다. init()은 사용자에 맞춰서 재정의할 수 있으며 초기화 때 필요한 기능들을 적어주면 됨. 여기서는 `RequestMapping.java`로 URL 매핑 초기화를 하였다. 
 
#### 2. Tomcat 서버를 시작한 후 http://localhost:8080으로 접근시 호출 순서 및 흐름을 설명하라.
1. 서블릿에 접근하기 전에 먼저 `ResourceFilter`와 `CharacterEncodingFilter`의 `doFilter()`가 실행된다.
1. 위의 초기화들이 끝난 후 http://localhost:8080으로 접근하면 `RequestMapping.java` 에 `/` 으로 mapping 돼어있는 `HomeController()`가 호출됨.
1. `HomeController.class`은 `AbstractController.class`를 상속받고 있으며 `jspView("home.jsp").addObject("questions", questionDao.findAll())` ModelAndView 타입으로 리턴해준다. 
  - `AbstractController.class` 은 `jspView`와 `jsonView` 메소드가 존재 
1. `ModelAndView` 타입으로 리턴 받고 `view.render()`로 응답
   

#### 7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생하는 이유에 대해 설명하라.
- `ShowController.java` 에 아래와 같이 Field로 선언되어있음 
```java
private Question question;
private List<Answer> answers;
```
- Stack 영역에는 메소드의 인자, 로컬 변수 등을 관리하는 메모리 영역으로 **각 스레드마다 서로 다른 스택 영역을 가진다.**
- Heap 영역은 클래스의 인스턴스 상태 데이터를 관리하는 영역으로 **스레드가 서로 공유할 수 있는 영역이다.**
- 그래서 사용자 1이 1번 글을 읽어오기 위해 눌렀을때 (1번글 요청) 응답하기 전에 사용자 2가 2번 글을 읽어오기 위해 2번글을 요청하면 사용자1과 사용자2에 1번글 응답을 한다. 필드에 선언되어있는 question과 answer은 공유할 수 있는 공간인 Heap영역에 있으니까 스레드끼리 공유해서 이런 문제가 생긴다.
- -> 로컬변수로 선언하면 됨 

#### Singleton
매 요청마다 모든 클래스의 인스턴스를 생성하지 않아도 됨. 이에 해당하는 클래스가 컨트롤러, DAO, JdbcTemplate과 같이 상태 값은 가지지 않으면서 메소드만 가지는 클래스  
```java
public class JdbcTemplate {

    private static JdbcTemplate jdbcTemplate;

//  외부에서 인스턴스를 생성할 수 없도록 기본 생성자를 private 접근 제어자로 구현
    private JdbcTemplate() {} 
//  인스턴스에 대한 생성은 이 메서드로만 가능하도록 허용
    public static JdbcTemplate getInstance() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate();
        }
        return jdbcTemplate;
    }
}
//  여러 개의 쓰레드가 동시에 getInstance() 메소드를 호출하는 경우 인스턴스가 하나 이상 생성될 수 있는 문제가 있는 코드
```

- **인스턴스가 하나만 생성하도록 보장**
```java
public class JdbcTemplate {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate();
    
    private JdbcTemplate() {}
    
    public static JdbcTemplate getInstance() {
        return jdbcTemplate;
    }
}
// Singleton 패턴을 사용해야 하는 경우가 있다면 위와 같이 구현할 것을 추천
```
- Contoller의 경우는 이미 인스턴스 하나를 재사용하고 있다. 서블릿 컨테이너가 시작하는 시점에 `DispatcherServlet`이 초기화(init())를 하면서 각 컨트롤러의 인스턴스를 Map에 저장한 후 재사용하는 방식으로 구현되어 있다.

#### QnaService
- **`deleteQuestion()`는 CannotDeleteException이라는 컴파일타입 Exception을 throw 하고있는데 사용자에게 예외처리를 통해 에러 메시지를 전달하거나, 다른 작업을 하도록 유도할 필요가 있는 경우 런타임 Exception보다는 컴파일 타임 Exception이 적합하다.**  
  -> 음.. 더 알아보도록 하자

