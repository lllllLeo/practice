package good.boy.jun.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import good.boy.jun.model.dto.boardDTO;
import good.boy.jun.service.boardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	boardService service;
	
	//게시판 글 전체 조회
	@RequestMapping(value="", method=RequestMethod.GET)
	public String boardlist(Model model) {
		System.out.println(": : : : B o a r d : : : :");
		try {
			List <boardDTO> list = service.readall();
			System.out.println(list.get(0)+"/1");
			model.addAttribute("list",list);
			System.out.println(list.get(0)+"/2");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board";
	}
	
	
	// 글 조회
	@RequestMapping(value="/{board_num}", method=RequestMethod.GET)
	public String readGET(@PathVariable int board_num, Model model, boardDTO dto) {
		System.out.println(": : : : R E A D : : : :");
		try {
			service.viewcount(board_num);
			dto = service.read(board_num);
			System.out.println(dto);
			model.addAttribute("dto",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "read";
		
	}
	
	//글 등록페이지 GET
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerGET() {
		return "register";
	}
	
	//글 등록하기 POST 
	@RequestMapping(value="register", method=RequestMethod.POST)
	public @ResponseBody void registerPOST(boardDTO dto, HttpServletResponse response) {
		System.out.println(": : : : R E G I S T E R : : : :");
		System.out.println(dto);
		
		try {
			service.register(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//글 수정페이지 GET
	@RequestMapping(value="update/{board_num}", method=RequestMethod.GET)
	public String updateGET(@PathVariable int board_num, boardDTO dto, Model model) {
		System.out.println(": : : : U P D A T E ( G E T ) : : : :");
		try {
			dto = service.read(board_num);
			System.out.println(dto.getBoard_content());
			model.addAttribute("dto",dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "update";
	}
	
	//글 수정페이지 POST
	@RequestMapping(value="update/{board_num}", method=RequestMethod.POST)
	public String updatePOST(boardDTO dto) {
		System.out.println(": : : : U P D A T E ( P O S T ) : : : :");
		try {
			service.update(dto);
			System.out.println(dto.getBoard_content());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/board";
	}
	
	//글 삭제
	// 굳이 error를 만들어줄필요있나 어처피 있는 게시글에서 그 게시글 번호를 받아서 삭제하는건데
	@RequestMapping(value="delete/{board_num}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable int board_num, HttpServletResponse response) {
		System.out.println(": : : : D E L E T E : : : :");
		boolean result;
		String check = "success";
		try {
			result = service.delete(board_num);
			
			if(!result) {
				check = "error";
				return check;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
}

