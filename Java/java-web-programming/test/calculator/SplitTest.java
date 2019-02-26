package calculator;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SplitTest {

    /* 이런식으로 메서드가 어떻게 동작하는지 궁금할때 학습목적으로 테스트해 볼 수 있음 */
    @Test
    public void split(){
        String[] values = "1".split(",");
        assertArrayEquals(new String[] {"1"}, values);

        values = "1,2".split(",");
        assertArrayEquals(new String[] {"1","2"}, values);
    }

}
