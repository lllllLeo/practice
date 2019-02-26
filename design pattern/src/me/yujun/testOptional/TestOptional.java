package me.yujun.testOptional;

import java.util.Optional;

public class TestOptional {


    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("dd");
        String result = optional.orElse("g");
        System.out.println(result);
//        System.out.println(optional);
//        System.out.println(optional.isPresent());
//        System.out.println(optional.orElse("ㅎ")); // 값이 없다면 ㅎ를 가져온다
//        System.out.println(optional.orElseGet("뭐야"));

    }

}
