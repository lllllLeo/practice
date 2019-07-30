package me.yujun.webservice.domain.posts;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yujun.webservice.domain.BaseTimeEntity;

import javax.persistence.*;


/*
* 실제 DB의 테이블과 매칭될 클래스이며 Entity클래스 라고도 함
* @Column : 테이블의 컬럼을 나타내는데, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이 된다. 사용이유는 length를 바꾸거나 이런 옵션을 사용하기 위해 사용함
* */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
