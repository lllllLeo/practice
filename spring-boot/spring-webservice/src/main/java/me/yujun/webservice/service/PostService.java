package me.yujun.webservice.service;

import lombok.AllArgsConstructor;
import me.yujun.webservice.domain.dto.PostsMainResponseDto;
import me.yujun.webservice.domain.dto.PostsSaveRequestDto;
import me.yujun.webservice.domain.posts.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 Controller에서 Dto.toEntity를 통해서 바로 전달해도 되지만 굳이 나눈 이유는
 Service와 Contorller의 역할을 분리하기 위해서다.
 비즈니스 로직, 트랜잭션 관리는 Service 에서 관리하고, View와 연동되는 부분은 Controller에서 담당하도록 구성
 **/

@AllArgsConstructor
@Service
public class PostService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }


    /*
      .map(PostsMainResponseDto::new)는 실제로는 .map(posts -> new PostsMainResponseDto(posts))와 같습니다.
      repository 결과로 PostsRepository에서 넘어온 Posts의 Stream을 map을 통해 PostsMainResponseDto로 변환 -> List로 반환하는 메소드
    * */
    @Transactional
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
