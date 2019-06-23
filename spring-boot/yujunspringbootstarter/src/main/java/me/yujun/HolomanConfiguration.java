package me.yujun;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Holoman @Bean을 리턴하는 설정파일
 *
 * @EnableAutoConfiguration을 하면 spring.factories에 있는 org.springframework.boot.autoconfigure.EnableAutoConfiguration를 읽어온다. 그럼 여기에 들어와서 @Bean을 읽어서 준다.
 * 이 프로젝트를 빌드를 하고 Install 해야함 다른 프로젝트에서 사용할 수 있도록. 우측 Maven Projects - Lifecycle - install 하면 이 프로젝트를 빌드를해서 jar파일을 생성 후 다른 프로젝트에서 사용할 수 있도록
 * 다른 메이븐 프로젝트에서 사용할 수 있도록 로컬 메이븐 저장소에 설치를 한다. 그리고 pom.xml에 가서
 * <groupId>me.yujun</groupId>
 * <artifactId>yujun-spring-boot-starter</artifactId>
 * <version>1.0-SNAPSHOT</version>
 * 를 복사해서 다른 프로젝트의 pom.xml에  Dependency를 추가한다.
 */
@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
// properties를 사용하려면 써야함. 그리고 매개변수로  HolomanProperties를 주입을 해줘서 properties.getHowLong() 사용
public class HolomanConfiguration {

    @Bean
    public Holoman holoman(HolomanProperties properties) {
        Holoman holoman = new Holoman();
        holoman.setHowLong(properties.getHowLong());
        holoman.setName(properties.getName());

        return holoman;

    }
}
