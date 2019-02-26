package me.yujun.springcorsserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    /*
    implements WebMvcConfigurer  를 확장해서 만든 스프링부트가 제공하는
    스프링 MVC의 기능 그대로 다 사용하면서 추가로 확장만하는 것이다.
    */

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    여기서 ctrl + space 하고 cors 검색하면 아래 메서드가 나옴

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // "/hello"
                .allowedOrigins("http://localhost:18080");

    }
}
