package me.yujun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 이 빈 설정파일 자체가 prod라는 profile일때 사용된다. 아니면 이 빈 설정파일은 사용이 안된다.
 */


@Profile("prod")
@Configuration
public class BaseConfiguration {

    @Bean
    public String hello() {
        return "hello";
    }
}

