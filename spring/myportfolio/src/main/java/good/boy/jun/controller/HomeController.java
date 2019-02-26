package good.boy.jun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value="/services", method = RequestMethod.GET)
	public String services() {
		return "services";
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}
	
	@RequestMapping(value="/blog", method = RequestMethod.GET)
	public String blog() {
		return "blog";
	}
	
	
}
