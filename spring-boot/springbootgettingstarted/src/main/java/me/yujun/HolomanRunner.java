package me.yujun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// ApplicationRunner는 arg인자 받아서 뭔가 하고 싶을때 spring boot application이 만들어지고 띄웠을때 자동으로 실행되는 빈을 띄우고싶다 할때
@Component
public class HolomanRunner implements ApplicationRunner {

    //    이 프로젝트에서 Holoman을 빈으로 등록하지 않았지만 이처럼 사용할 수 있다.
    @Autowired
    Holoman holoman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holoman);
    }
}
