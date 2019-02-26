package me.yujun.demospringhateoas;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class SampleController {

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/hello")
    public Resource<Hello> hello(){
        Hello hello = new Hello();
        hello.setPrefix("Hey!");
        hello.setName("yujun");

        /*
        우리가 제공할 리소스 + 링크 정보
        */
        Resource<Hello> helloResource = new Resource<>(hello);
        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());    //링크 정보
        // 이 클래스에서 제공하는 hello 메서드의 링크를 따서 이 링크를 self라는 relation으로 만들어서 추가함

        return helloResource;
        /*
        이 리소스 정보가 hello라는 객체가 JSON으로 변환이 되어서 응답이 나가긴 하겠지만
        우리가 아무런 링크 정보를 넣지 않았다. 그렇기 때문에 에러뜸

        링크 정보를 추가해보자
        */

    }
}
