package me.yujun.webservice.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.yujun.webservice.domain.posts.Posts;


/**
   이 DTO클래스는 Entity클래스와 비슷하지만 다른점이 있는데 @Setter 이다.
   절대로 테이블과 매핑되는 Entity 클래스를 Request / Reponse 클래스로 사용해서는 안된다.
   Entity 클래스는 가장 Core한 클래스라고 보면 된다.
   수많은 서비스 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작한다.
   Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되지만
   DTO는 Request / Response 용 이므로 View를 위한 클래스라 자주 변경이 필요하다.

   그래서 View Layer와 DB Layer를 철저하게 역할 분리를 하는게 좋다.

 실제로 Controller에서 결과값으로 여러 테이블을 조인해서 줘야할 경우가 빈번하기 때문에 Entity 클래스만으로 표현하기가 어려운 경우가 많습니다.  <- ?

 **/


@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}

