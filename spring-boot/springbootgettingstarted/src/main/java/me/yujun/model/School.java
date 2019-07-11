package me.yujun.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="SCHOOL_ID")
    private Long id;
    private String name;
    private String address;
    private String telnumber;

    @OneToMany(mappedBy = "school") // mappedBy는 연관 관계의 주인을 명시하기 위해 사용하는데 연관 관계의 주인은 다수 쪽이다. mappedBy의 school값은 school 클래스가 아니라 Student.school이라고 생각하면 편하다. -> Student클래스에서 school을 참조할 때  작성한 필드명 School school
    private Set<Student> students;

    public void registerStudent(Student s) {
        if(students == null) {
            students = new HashSet<Student>();
        }
        students.add(s);
    }

    public School(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", students=" + students +
                '}';
    }
}
