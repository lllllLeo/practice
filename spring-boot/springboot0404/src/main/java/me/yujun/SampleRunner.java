package me.yujun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class SampleRunner implements ApplicationRunner {

//    @Value("yujun.name")
//    private String name;

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Autowired
    YujunProperties yujunProperties;

    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        System.out.println("=================");
        System.out.println(yujunProperties.getName());  // prod 에 정의
        System.out.println(yujunProperties.getFullName());  // include = proddb 에 정의
        System.out.println(hello);
        System.out.println("=================");
        */

        logger.debug("======================");
        logger.debug(hello);
        logger.debug(yujunProperties.getName());
        logger.debug(yujunProperties.getFullName());
        logger.debug("======================");

    }
}
