package good.boy.jun.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import good.boy.jun.service.yujunService;

@Controller
public class YujunController {


	@Inject
	yujunService yujunservice;
	
	// 로그인 페이지 GET
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginGET() {
		return "login";
	}
	
	// 로그인 페이지 POST
	//여기서 Map에 넣지말고 DaoImpl에서 Map에 넣더라 책에서
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody void loginPOST(String yj_id, String yj_password, HttpSession session, HttpServletResponse response) {
		HashMap<String, String> forlogin = new HashMap<String, String>();
		boolean result;
		String check = "success";
		System.out.println(yj_id);			//login에서 넘어온 id
		System.out.println(yj_password);	//login에서 넘어온 password
		forlogin.put("yj_id", yj_id);
		forlogin.put("yj_password", yj_password);
		System.out.println("map에서 꺼낸"+forlogin.get("yj_id"));			//map에서 꺼낸 id
		System.out.println("map에서 꺼낸"+forlogin.get("yj_password"));	//map에서 꺼낸 password
		

		result = yujunservice.logincheck(forlogin);
		//System.out.println(result);
		session.setAttribute("session", "유준");
		
		
		if (!result) {
			System.out.println("로그인 실패");
			System.out.println("세션 지움");
			check = "error";
			session.invalidate();
		}

		try {
			response.getWriter().println(check);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/boo", method = RequestMethod.GET)
	public String boo() {
		return "boo";
	}
	
}
	
/*	@RequestMapping(value="/login2", method = RequestMethod.GET)
	public String login2GET() {
		return "login2";
	}
*/
	
/*	
	@RequestMapping(value="/login2", method = RequestMethod.POST)
	public String login2POST(String yj_id, String yj_password, HttpSession session) {
		HashMap<String, String> forlogin = new HashMap<String, String>();
		String result;
		System.out.println(yj_id);			//login에서 넘어온 id
		System.out.println(yj_password);	//login에서 넘어온 password
		forlogin.put("yj_id", yj_id);
		forlogin.put("yj_password", yj_password);
		System.out.println(forlogin.get("yj_id"));			//map에서 꺼낸 id
		System.out.println(forlogin.get("yj_password"));	//map에서 꺼낸 password
		
		
		result = yujunservice.logincheck(forlogin);
		System.out.println(result);
		if(result == null) {
			 로그인 실패 메시지 보내기, 다시 login 페이지로
			System.out.println("로그인 실패");
			return null;
		}
		System.out.println("로그인 성공");
		session.setAttribute("session", "유준");
		return "redirect:/";
}*/
	
