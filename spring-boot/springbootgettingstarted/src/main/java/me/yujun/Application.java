package me.yujun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

//        NONE하는 이유는 그냥 좀 결과 빨리 뜨게 하려고
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }


    /*
     * 직접 빈으로 등록해봅시다.
     * 하고 돌려보면 영상에서는 이전에 등록한 5가 나온다.
     * 스프링 부트에서 빈을 등록할때 2가지 방법이 있는데 ComponentScan으로 등록하는 것이 첫번째이다. 그러니까 이 클래스에서 @Bean이 먼저 등록된다.
     * 그 이후에는 AutoConfiguration으로 등록하는거다. 그래서 그 두번째로 만들어진 Bean(setHowLong(5))이 여기 있는 얘를 덮어쓴거다.
     * 그래서 이걸 해결하는 방법이 @ConditionalOnMissingBean 이다.
     * */
//    @Bean
//    @ConditionalOnMissingBean   // Bean으로 등록되지 않도록 조건을 걸어줌 => Holoman 타입의 Bean이 없을 때만 Bean으로 등록해줌.
//    public Holoman holoman(){
//        Holoman holoman = new Holoman();
//        holoman.setName("yujun");
//        holoman.setHowLong(60);
//        return holoman;
//    }

    /*
     * 나는 setName, setHowLong만 하고 싶은데 굳이 Bean으로 등록해야하는가 하면 (위에꺼 주석)
     * 일단 여기 없으면 AutoConfiguration으로 Bean을 가져온다. 여기에 Bean은 정의하지 않았지만 application.properties에 있는 값들은 사용할 수 있다.'
     * 우리는 여기에서는 properties만 정의하면된다 bean을 재정의 할 필요 없이
     *
     *
     * 자동 빈 등록을 할 때 @EnableConfigurationProperties(HolomanProperties.class) 즉, HolomanProperties클래스를 사용하는데 HolomanProperties얘는 @ConfigurationProperties("holoman")인
     * holoman properties 파일을 참조한다. -> application.properties에 있는 holoman.name = 유준, holoman.how-long = 55 을 참조한다.
     * */


}
