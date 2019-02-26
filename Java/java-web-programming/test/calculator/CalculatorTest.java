package calculator;

import me.yujun.calculator.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator cal;

    @Before
    /* 테스트 메소드에 대한 초기화 작업을 하기 위한 Annotation */
    public void setup(){
        cal = new Calculator();
        System.out.println("before");
    }
    @Test
    public void add(){
        assertEquals(9, cal.add(6,3));
        System.out.println("add");
    }

    @Test
    public void subtract(){
        assertEquals(3,cal.subtract(6,3));
        System.out.println("subtract");
    }

    @After
    public void taardown(){
        System.out.println("teardown");
    }
}
