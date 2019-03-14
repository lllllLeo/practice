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
   
    