package me.yujun.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 handlebars-spring0-boot-starter 덕분에 Controller에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정된다.
   (prefix: src/main/resources/templates, suffix: .hbs)
 **/

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
