package me.yujun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class SampleRunner implements ApplicationRunner {

    @Value("${yujun.name}")
    private String name;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("===================");
        System.out.println(name);
        System.out.println("===================");
    }
}
