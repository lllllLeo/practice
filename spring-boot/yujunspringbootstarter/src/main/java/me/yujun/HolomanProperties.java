package me.yujun;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * properties 파일에 있는 값을 쓰려면 @ConfigurationProperties를 등록해줘야함. 애노테이션 등록하면 위에 빨간 창뜨는데
 * properties에서 지원하는 자동완성을 지원하려면 의존을 주입해야한다.
 */

@ConfigurationProperties("holoman")
public class HolomanProperties {

    private String name;

    private int howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }
}
