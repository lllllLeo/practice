package me.yujun;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Bean으로 등록하면 등록되어있는 Bean중에 해당하는 이벤트의 리스너를 실행을 해준다.
 * 중요한것은 이 이벤트가 언제시작하는지 -> application-context가 만들어졌느냐/안만들어졌느냐
 * 만들어진 다음 발생하는 이벤트는 Bean을 실행할 수 있는데 그 이벤트 들의 리스너가 Bean이면
 * 알아서 호출이 된다.
 * 문제는 이전에 발생하는 이벤트는
 * <p>
 * <p>
 * ApplicationStartingEvent 는 application-context가 만들어지기 이전에 발생하는 이벤트이다.
 * application 맨 처음에 발생하는 이벤트이다. 이 이벤트가 발생한 시점에는 application-context가
 * 만들어지지 않았다. 그래서 Bean으로 등록을 한다고 하더라도 Listener가 동작을 안한다.
 * <p>
 * 그래서 이런 경우에는 따로 main에서 등록을 해줘야함. 그래서 Bean으로 등록할 필요가 없다 @Component 지우자 슥
 * <p>
 * <p>
 * ApplicationArguments 사용하기
 * <p>
 * VM options 에서 -D로 들어오는것은 VM option으로 치고 (JVM option은 application arguments가 아니다.)
 * Program arguments로 -- 들어오는것만 arguments로 사용한다. (오로치 -- 로 주는애들이 application arguments이다.)
 * arguments.에 유용한 메서드 많으니까 필요에 따라 써보셈
 * <p>
 * ApplicationRunner (추천)
 * <p>
 * 좀 더 고급진 api를 통해 사용할 수 있다.
 * <p>
 * ApplicationRunner들이 여러개이면 @Order(1) 해서 순서를 정해줄 수 있다. (숫자가 낮은게 먼저)
 * <p>
 * CommandLineRunner
 */
/*
@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
//public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("=====================");
        System.out.println("Application is started");
        System.out.println("=====================");
    }
}
*/

/**
 *   ApplicationArguments 사용하기
 *
 * VM options 에서 -D로 들어오는것은 VM option으로 치고 (JVM option은 application arguments가 아니다.)
 * Program arguments로 -- 들어오는것만 arguments로 사용한다. (오로치 -- 로 주는애들이 application arguments이다.)
 * arguments.에 유용한 메서드 많으니까 필요에 따라 써보셈
 * */
/*
@Component
public class SampleListener{

    public SampleListener(ApplicationArguments arguments){
        System.out.println("foo: "+arguments.containsOption("foo")); // foo가 있는지 찍기 / false
        System.out.println("bar: "+arguments.containsOption("bar")); // bar가 있는지 찍기 / true
    }
}
*/
/**
 * ApplicationRunner (추천)
 *
 * 좀 더 고급진 api를 통해 사용할 수 있다.
 *
 * ApplicationRunner들이 여러개이면 @Order(1) 해서 순서를 정해줄 수 있다. (숫자가 낮은게 먼저)
 * */
/*
@Component
@Order(1)
public class SampleListener implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo: "+args.containsOption("foo")); // foo가 있는지 찍기 / false
        System.out.println("bar: "+args.containsOption("bar")); // bar가 있는지 찍기 / true
    }
}*/
/**
 * CommandLineRunner
 * */
/*@Component
public class SampleListener implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(System.out::println);   // bar만 찍힘. JVM option 무시. 결국 다 똑같음
    }
}
*/
