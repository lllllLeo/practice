package good.boy.jun.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * 호출되는 메소드에서 발생된 Exception을 모두 처리하는 역할
   1. 클래스에 @ControllerAdvice 애노테이션 처리
   2. 각 메소드에 @ExceptionHandler를 이용해서 적절한 타입의 Exception을 처리
   
   ControllerAdvice 클래스의 메소드는 발생한 Exception 객체의 타입만을 파라미터로 사용할 수 있고, 일반 Controller와 같이 Model을 파라미터로 사용하는 것은 
      지원하지 않기 때문에 직접 ModelAndView 타입을 사용하는 형태로 작성해야 한다.
*/
/*@ControllerAdvice*/
public class CommonExceptionAdvice {

	/*@ExceptionHandler
	public String common(Exception e) { 
		return "errorpage";
	}*/
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex) {

		
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("/errorpage");
		modelandview.addObject("exception",ex);
		
		
		return modelandview;
	}
}
