package me.yujun.model;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private Long id;
    private String userName;
    private String grade;

//    @ManyToOne은 즉시 로딩(EAGER)이 기본값이다. 즉시 로딩으로 실행될 때는 연결된 엔티티 정보까지 한 번에 가져오려고 하므로 성능에 문제가 발생할 수 있다. 그래서 @ManyToOne을 사용할 때는 RetchType.LAZY를 지정해서 지연 로딩되도록 하는 것이 좋다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHOOL_ID")
    private School school;

    public Student(String userName) {
        this.userName = userName;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
