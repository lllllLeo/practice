package me.yujun.springbootexception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/hello")
    public String hello(){
        throw new SampleException();
    }

    /*
    이 SampleController 안에서 발생하는 SampleException이라는 예외가 발생하면
    이 핸드러를 사용하겠다.
    이 컨트롤러안에서만 사용가능

    ExceptionHandler를 전역적으로 사용하고 싶으면
    클래스를 만들고 @ControllerAdvice를 선언하고 밑과 똑같이
    @ExceptionHandler를 선언하고 정의하면 됨. 여러 컨트롤러에서 발생하는
    샘플 익셉션을 처리하는 메서드가 동작을 하게 된다.
    */
    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e){
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");
        return appError;
    }
//    ResponseEntity<SampleError>
}
