package me.yujun.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void findStudentInfo() {
        School school = new School("유준고등학교");
        schoolRepository.save(school);

        Student stu1 = new Student("유준");
        Student stu2 = new Student("기덕");
        Student stu3 = new Student("호준");

        stu1.setSchool(school);
        stu2.setSchool(school);
        stu3.setSchool(school);

        studentRepository.save(stu1);
        studentRepository.save(stu2);
        studentRepository.save(stu3);

        List<Student> students = studentRepository.findAll();

        for (Student s : students) {
            System.out.println(s.getUserName() + "," + s.getSchool().getName());
        }
    }

    @Transactional
    public void findSchoolInfo() {
        School sc1 = new School("노인고등학교");
        sc1.registerStudent(new Student("이제훈"));
        sc1.registerStudent(new Student("김기범"));

        School sc2 = new School("유준고등학교");
        sc2.registerStudent(new Student("김유준"));
        sc2.registerStudent(new Student("김기덕"));

//        schoolRepository.save(new HashSet<School>() {{
//             add(sc1);
//             add(sc2);
//        }});

        List<School> schools = schoolRepository.findAll();

        for(School s : schools) {
            System.out.println(s.toString());
        }
    }

}
