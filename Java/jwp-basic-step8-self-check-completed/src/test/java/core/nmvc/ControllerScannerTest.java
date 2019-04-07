package core.nmvc;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ControllerScannerTest {
    private static final Logger logger = LoggerFactory.getLogger(ControllerScanner.class);

    private ControllerScanner cf;

    @Before
    public void setup() {
        cf = new ControllerScanner("core.nmvc");
    }

//    @Controller를 사용한 클래스를 알 수 있다.
    @Test
    public void getControllers() throws Exception {
        Map<Class<?>, Object> controllers = cf.getControllers();
        logger.info(controllers.toString());
        for(Class<?> controller : controllers.keySet()){
            logger.debug("controller : {}", controller);
        }
    }
}
