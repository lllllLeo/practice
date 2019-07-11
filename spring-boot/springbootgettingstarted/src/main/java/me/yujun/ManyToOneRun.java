package me.yujun;

import me.yujun.model.SchoolService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ManyToOneRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ManyToOneRun.class, args);

        SchoolService schoolService = context.getBean(SchoolService.class);

        System.out.println("ManyToOneRun 클래스@@@@@@@@@@@@@@@@@@@@");
        schoolService.findStudentInfo();
    }
}
