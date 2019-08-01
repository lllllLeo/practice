package me.yujun.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

/*
* Mybatis 등에서 Dao라고 불리는 DB Layer 접근자이다. JPA에서는 Respository라고 부르며 인터페이스로 생성한다.
* 생성 후 JpaRepository<Entity클래스, PK타입> 를 상속하면 기본적인 CRUD 메소드가 자동생성 된다.
* @Repository를 추가할 필요도 없다.
* */

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
