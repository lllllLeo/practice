package core.ref;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.model.Question;
import next.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;
        logger.debug(clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        logger.info("필드");
        for (Field field : fields) {
            System.out.println(field);
        }
        logger.info("메서드");
        for (Method method : methods) {
            System.out.println(method);
        }
        logger.info("생성자");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

    }
    
    @Test
    public void newInstanceWithConstructorArgs() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            constructor.newInstance("yujun", "gd", "zz", "4");
        }

    }
    
    @Test
    public void privateFieldAccess() throws IllegalAccessException {
        Student student = new Student();
        Class<Student> clazz = Student.class;
        logger.debug(clazz.getName());
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        fields[0].set(student, "유준");
        fields[1].setInt(student, 7);
        logger.info("student name : {}", student.getName());
        logger.info("student age : {}", student.getAge());
    }
}
