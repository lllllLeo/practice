package me.yujun;

import me.yujun.model.UserEntity;
import me.yujun.model.UserRepository;
import me.yujun.model.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JPAMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.save(new UserEntity("유준", 60, UserRole.ADMIN));
        UserEntity user = userRepository.findByUserName("유준");
        System.out.println("나이 : " + user.getAge() + "," + "이름 : "+ user.getUserName() + "," + "생성일 : " + user.getCreateAt());
    }
}
