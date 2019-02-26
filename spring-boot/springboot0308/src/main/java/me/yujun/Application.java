package me.yujun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/hello")
    public String hello(){
        return "hello Spring";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
/*    @Bean
    public ServletWebServerFactory serverFactory(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());    // 메서드를 만들어서 커넥터를 추가(http를 받기위해)
        return tomcat;
    }

    private Connector createStandardConnector(){
        // Tomcat의 connector 로 만든다
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        return connector;
    }*/
