package me.yujun.webservice.web;

import lombok.AllArgsConstructor;
import me.yujun.webservice.domain.dto.PostsSaveRequestDto;
import me.yujun.webservice.domain.posts.PostsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
