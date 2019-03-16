 WebServer
 ==
 - ContextLoaderListener
   - 톰캣 서버가 시작할때 이 메소드가 호출되어서 초기화 작업을 진행함
   - ContextLoaderListener가 ServletContextListener 인터페이스를 구현하고 있으며 @WebListener 애노테이션 설정이 있다.  
   - ServeltContextListener 인터페이스 구현체 중 @WebListener 애노테이션이 설정되어 있으면 서블릿 컨테이너를 시작하는 과정에서
    contextInitialized() 메소드를 호출해 초기화 작업을 진행한다. -> web.xml의 listener와 동일한 기능(리스너 태그 등록)
   - ServletContextListener에 대한 초기화는 서블릿 초기화보다 먼저 진행됨.
   - ServletContextListener초기화는 웹 애플리케이션 전체에 영향을 미치는 초기화가 필요한 경우 활용   
   
   
   -- 
   - contextInitialized : 초기화와 동시에 실행
   - contextDestroyed : Destory와 동시에 실행 
   - ResourceDatabasePopulator : SQL 스크립트 파일을 지정(jwp.sql)
   - DatabasePopulatorUtils.excute()를 하면 jwp.sql 파일이 실행된다. (이처럼 애플리케이션을 기동할 때 데이터를 추기화하는 경우는 프로덕션 환경에서는 거의 없으므로 주로 테스트용으로 사용함)
 
 - SQLException : 컴파일타임 Exception이기 때문에 매번 try/catch절을 통해 Exception 처리를 해야 한다.
 
 ### JdbcTemplate.class
 - JdbcTemplate, SelectJdbcTemplate(JdbcTemplate.class랑 합침)은 `Template Method 패턴` 
 - **Template Method 패턴** 
   - 반복적으로 발생하는 중복 로직을 상위 클래스가 구현하고 변화가 발생하는 부분만 추상 메소드로 만들어 구현하도록 하는 디자인 패턴
   - 단점은 부모가 가지고 있는 추상메소드를 모든 자식 클래스는 구현을 해야한다는 점이다.(현재 JdbcTemplate.class의 단점)
   - 현재 select는 `mapRows()`, `setParameters()` 두 개의 메소드를 필요로 하지만 insert나 update는 `setParameters()`만 필요로 한다. 그래서 지금 강제로 `mapRows()`를 Override하는 상황임. 별로임
   
   > 인터페이스로 독립적으로 분리해서 각각의 인터페이스가 필요로 한 시점에 인터페이스를 구현해서 인자를 전달하는 방식으로 개선해보자  
  
 - 인터페이스 2개를 각각 만들어서 메소드 별로 필요 인터페이스를 구현함
 
 - RowMapper 타입이 Object였는데 이대로 하면 매번 캐스팅해줘야한다. 그래서 Generics로 <T>로 리턴타입을 바꾸고 interface를 구현할 때 원하는 타입으로 구현해주면 됨 `RowMapper<User>` 이런식으로
 
 - `pstmt.setXxxx()` 으로 구현되어있는데 이렇게하면 인자가 많이 필요한 상황이면 계속 `pstmt.setXxxx()`으로 계속 적어줘야한다. 그래서 이 부분을 전달받는 곳에서 인자의 수가 매번 바뀔 수 있으니 **가변인자**로 받을 수 있음. 그리고 타입이 String말고도 int 등 다양한 타입이 올 수 있으니까 지금 `Object`로 받음
 - **가변인자 (Varargs / variable Arguments)**  
   - 선언할 때 ...을 붙여주면 컴파일러가 `String... strs` 를 배열형식 `String[] strs`로 바꿈. 그리고 매개변수로 주어지는 가변인수들을 모아서 배열 객체로 만들어버림
   - 가변인자는 맨 마지막에 적어야함.
      
   
   
 
 
  
 
    