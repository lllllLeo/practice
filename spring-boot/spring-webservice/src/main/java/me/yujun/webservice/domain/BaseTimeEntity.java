package me.yujun.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 보통 Entity에는 해당 데이터의 생성시간과 수정시간을 포함시킨다.
 언제 만들어졌는지, 언제 수정되었는지 등은 차후 유지보수에 있어 굉장히 중요한 정보이기 때문이다.
 그렇다보니 매번 DB에 insert하기전, update 하기전에 날짜 데이터를 등록/수정 하는 코드가 여기저기 들어간다.
 이 문제를 해결하기 위해 JPA Auditing 사용


 이 클래스는 모든 Entity들의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할


 @MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 함
 @EntityListeners(AuditingEntityListener.class) : BaseTimeEntity 클래스에 Auditing 기능을 포함시킴
 @CreatedDate : Entity가 생성되어 저장될 때 시간이 자동 저장된다.
 @LastModifiedDate : 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.

 abstract 메서드 인 이유 : 해당 클래스만으로 인스턴스 생성되는걸 막기 위함입니다.
 BaseTimeEntity는 시간 관련된 내용들을 담당하고, 어디까지나 엔티티 클래스들을 보조하기 위함인데,
 이를 코드 상으로 표현하기엔 추상 클래스가 적당하기 때문에 선택하게 됐습니다.


 -------
 즉, BaseTimeEntity를 상속받으면 등록일/수정일이 알아서 추가된다.
 **/

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

//    공용 생성일
    @CreatedDate
    private LocalDateTime createdDate;
//    공용 수정일
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
