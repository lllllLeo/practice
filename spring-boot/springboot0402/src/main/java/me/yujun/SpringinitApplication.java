package me.yujun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;

@SpringBootApplication
public class SpringinitApplication {

    public static void main(String[] args) {
//        SpringApplication 실행방법 1
//        이렇게하면 SpringApplication(static method)이 제공하는 다양한 커스터마이징 기능을 사용하기 어렵다.
//        SpringApplication.run(SpringinitApplication.class, args);

//        SpringApplication 실행방법 2 커스터마이징 가능
//        위 코드와 결과는 동일
//        SpringApplication app = new SpringApplication(SpringinitApplication.class);
//        app.run(args);

//        SpringApplication 실행방법 3 커스터마이징 가능
//        new SpringApplicationBuilder()
//                .sources(SpringinitApplication.class)
//                .run(args);


        /***************** SpringApplication 2부 ******************/
//        SpringApplication app = new SpringApplication(SpringinitApplication.class);
////        app.addListeners(new SampleListener()); // Listener를 등록한다.
//        app.run(args);


        /***************** 외부설정 1부 ******************/
        SpringApplication app = new SpringApplication(SpringinitApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
