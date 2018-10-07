package good.boy.jun.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import good.boy.jun.model.dto.workDTO;
import good.boy.jun.service.workService;


@Controller
@RequestMapping("/work")
public class WorkController {

	@Inject 
	workService workservice;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkController.class); 
	
/*	@RequestMapping("/")
	public String index() {
		return "home";
	}*/
	
	@RequestMapping("")
	public String work(Model model)	{
		logger.info(": : : : work : : : :");
		try {
			List <workDTO> list = workservice.worklist();
			model.addAttribute("list",list);
			logger.info("list는 "+ list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(list.get(0));
		return "work";
	}
	
	@RequestMapping(value="/{work_number}" , method = RequestMethod.GET)
	public String workDetail(@PathVariable String work_number, Model model) {
		logger.info(": : : : detail : : : :");
		logger.info("work_number은 "+ work_number);
		workDTO workdto;
		try {
			workservice.workviewcount(work_number);	//조회수가 먼저올라가야지 디테일페이지에 조회수가 올라간상태로 보임
			workdto = workservice.workDetail(work_number);
			//workservice.viewcount(work_uid);
			model.addAttribute("work_number", work_number);
			model.addAttribute("workdto", workdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
}
