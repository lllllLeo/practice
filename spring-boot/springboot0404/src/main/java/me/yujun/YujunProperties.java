package me.yujun;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
@ConfigurationProperties("yujun")
//@Validated  // properties에 들어오는 값들을 검증하는 어노테이션
public class YujunProperties {

    //    @NotEmpty           // 이렇게하면 위에 @Validated이 들어오는 값을 검증하니까 properties에 key는 있고 Value가 없으면 이 @NotEmpty에 걸려서 Error가 뜬다.
    private String name;

    //    @Size(min = 1, max = 100)   //이런식으로도 검증할 수 있다.
    private int age;

    private String fullName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
