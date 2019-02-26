package calculator;

import me.yujun.calculator.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @Before
    public void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_빈문자열_또는_null(){
        assertEquals(0, stringCalculator.add(""));
        assertEquals(0, stringCalculator.add(null));
    }

    @Test
    public void add_숫자하나(){
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void add_쉼표구분자(){
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void add_쉼표_또는_콜론구분자(){
        assertEquals(6, stringCalculator.add("1,2:3"));
    }

    @Test
    public void add_custom_구분자(){
        assertEquals(6, stringCalculator.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception{
        stringCalculator.add("-1,2,3");
    }
}
