package good.boy.jun.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	/*
	 private : 외부에서 로그를 가로채지 못하도록 하기 위해서
	 static final : 로그 내용이 바뀌지 않으므로
	 
	 로그를 수집할 method에서 로그 수집 명령어 호출
	 logger.info("로그 타이틀", 출력할 값);
	*/
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//게시판 글 전체 조회

    @RequestMapping(value="", method=RequestMethod.GET)
	public String boardlist(Model model) {
		logger.info(": : : : B o a r d : : : :");
		try {
			List <boardDTO> list = service.readall();
			model.addAttribute("list",list);
			logger.info("list는 "+list);
			logger.info("list는 "+list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board";
	}

   /* //게시판 글 전체 조회(페이징 처리)
    @RequestMapping(value="", method=RequestMethod.GET)
    public String boardListPaging(Model model){
        logger.info(": : : : B O A R D : : : :");
        try {
            int page = service.pageCount();
            page = page / 10 + 1;
            service.boardListPaging(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "board";
    }*/

	// 글 조회
	@RequestMapping(value="/{board_num}", method=RequestMethod.GET)
	public String readGET(@PathVariable int board_num, Model model, boardDTO dto) {
		logger.info(": : : : R E A D : : : :");
		logger.info("board_num은 "+board_num);
		try {
			service.viewcount(board_num);
			dto = service.read(board_num);
			logger.info("dto는 "+ dto);
			model.addAttribute("dto",dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "read";
		
	}
	
	//글 등록페이지 GET
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerGET() {
		logger.info(" : : : : R E G I S T E R ( G E T ) : : : :");
		return "register";
	}
	
	//글 등록하기 POST 
	@RequestMapping(value="register", method=RequestMethod.POST)
	public @ResponseBody void registerPOST(boardDTO dto, HttpServletResponse response) {
		logger.info(": : : : R E G I S T E R ( P O S T ) : : : :");
		logger.info("받아온 dto content는 "+dto.getBoard_content());
		
		try {
			service.register(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//글 수정페이지 GET
	@RequestMapping(value="update/{board_num}", method=RequestMethod.GET)
	public String updateGET(@PathVariable int board_num, boardDTO dto, Model model) {
		logger.info(": : : : U P D A T E ( G E T ) : : : :");
		try {
			dto = service.read(board_num);
			logger.info("dto content는 "+dto.getBoard_content());
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
		logger.info(": : : : U P D A T E ( P O S T ) : : : :");
		try {
			logger.info(""+dto);
			logger.info("수정 후 바뀐 내용 "+dto.getBoard_title()+ " "+ dto.getBoard_content());
			service.update(dto);
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
		logger.info(": : : : D E L E T E : : : :");
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

