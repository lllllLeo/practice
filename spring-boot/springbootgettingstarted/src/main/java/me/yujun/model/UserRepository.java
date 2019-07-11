package me.yujun.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


// Entity 조작에 필요한 쿼리를 메서드화해서 사용할 수 있는 역할을 한다.

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> { // <T, Id extends Serializable>인데  엔티티 클래스와 ID타입이 될 수 있는 Integer 또는 Long을 제네릭 안에 기술
    UserEntity findByUserName(@Param("userName") String userName);  // findby+필드명

}
