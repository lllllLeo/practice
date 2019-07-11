package me.yujun.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// 데이터베이스 스키마의 내용을 자바 클래스로 표현할 수 있는 대상을 Entity 클래스라고 한다.
// 데이터베이스 테이블을 매핑하는 역할
@Entity // 어노테이션으로 선언하는 것으로 엔티티 매니저가 관리해야할 대상으로 인식시킴
@Table(name = "tb_user") // 실제 테이블명과 클래스명이 다른 경우 사용하여 매칭시킴
public class UserEntity implements Serializable {

    @Id // Key 매핑
    @GeneratedValue(strategy = GenerationType.AUTO) // DB에 자동으로 키 관련 객체를 생성
    private Long id;
    private String userName;
    private Integer age;
    private Date createAt;

    @Column(name="role")    // @Table과 마찬가지로 DB와 자바 클래스의 필드명이 서로 다른 경우 지정해서 매핑가능
    @Enumerated(EnumType.ORDINAL)   // EnumType을 ORDINAL로 하면 값이 int로 할당되고  / STRING으로 지정하면 ENUM의 이름으로 할당된다.
    private UserRole role;
    // 값 참조를 위해서 미리 인스턴스가 생성되어야 하는 필드는 JPA에서 제공하는 콜백 메서드를 사용해서 값을 세팅할 수 있다.
//    날짜 타입에 createdAt 필드를 영속성 콘텍스트가 로드할 때 befgoreCreate 메소드가 호출되어 createdAt 필드에 날짜값이 할당된다.
    @PrePersist
    public void beforeCreate(){
        createAt = new Date();
    }

    public UserEntity() {
    }

    public UserEntity(String userName) {
        this.userName = userName;
    }

    public UserEntity(String userName, Integer age, UserRole role) {
        this.userName = userName;
        this.age = age;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
